package com.demo.chat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.config.SpringBeansUtils;
import com.demo.chat.po.Message;
import com.demo.chat.service.MessageService;
import com.demo.chat.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author liuji
 */
@ServerEndpoint("/imserver/{user_id}")
@Component
@Slf4j
public class ChatController {

    //获取redistemplate对象
    public  RedisTemplate<String,String> useRedis(){
        RedisTemplate<String,String> redisTemplate = (RedisTemplate) SpringBeansUtils.getBean("redisTemplate");
        //redisTemplate.opsForValue().set("name","jack");
        return redisTemplate;
    }

    public  MessageService useMessageService(){
        MessageService messageService = (MessageService) SpringBeansUtils.getBean("messageService");
        //redisTemplate.opsForValue().set("name","jack");
        return messageService;
    }


    /**静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。*/
    private static int onlineCount = 0;
    /**concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。*/
    private static ConcurrentHashMap<String,ChatController> webSocketMap = new ConcurrentHashMap<>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    /**接收userId*/
    private String userId="";

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("user_id") String user_id) {
        this.session = session;
        this.userId=user_id;
        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            webSocketMap.put(userId,this);
            //加入set中
        }else{
            webSocketMap.put(userId,this);
            //加入set中
            addOnlineCount();
            //在线数加1
        }

        log.info("用户连接:"+userId+",当前在线人数为:" + getOnlineCount());
        //在线用户存入redis中
        useRedis().opsForList().leftPush("online",user_id);
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("用户:"+userId+",网络异常!!!!!!");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            //从set中删除
            subOnlineCount();
        }
        log.info("用户退出:"+userId+",当前在线人数为:" + getOnlineCount());
        if(getOnlineCount()==0){
            useRedis().delete("online");

        }else {
            useRedis().opsForList().remove("online",1,userId);
        }


    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户消息:"+userId+",报文:"+message);
        //可以群发消息
        //消息保存到数据库、redis
        if(StringUtils.isNotBlank(message)){
            try {
                //解析发送的报文
                JSONObject jsonObject = JSON.parseObject(message);
                //追加发送人(防止串改)
                jsonObject.put("fromUserId",this.userId);
                String toUserId=jsonObject.getString("toUserId");
                //传送给对应toUserId用户的websocket
                if(StringUtils.isNotBlank(toUserId)&&webSocketMap.containsKey(toUserId)){
                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
                    useMessageService().save(Message
                            .builder()
                            .id(UUID.getUUID())
                            .acceptName(toUserId)
                            .sendName(userId)
                            .content_data(jsonObject.getString(message))
                            .send_time(new Date())
                            .system_massage("1")
                            .build());
                }else{
                    log.error("请求的userId:"+toUserId+"不在线");
                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
                    useMessageService().save(Message
                            .builder()
                            .id(UUID.getUUID())
                            .acceptName(toUserId)
                            .sendName(userId)
                            .content_data(jsonObject.getString(message))
                            .send_time(new Date())
                            .system_massage("1")
                            .build());

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误:"+this.userId+",原因:"+error.getMessage());
        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 发送自定义消息
     * */
    public static void sendInfo(String message,@PathParam("userId") String userId) throws IOException {
        log.info("发送消息到:"+userId+"，报文:"+message);
        if(StringUtils.isNotBlank(userId)&&webSocketMap.containsKey(userId)){
            webSocketMap.get(userId).sendMessage(message);
        }else{
            log.error("用户"+userId+",不在线！");
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        ChatController.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        ChatController.onlineCount--;
    }
}
