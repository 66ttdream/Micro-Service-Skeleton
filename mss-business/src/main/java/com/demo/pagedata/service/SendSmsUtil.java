package com.demo.pagedata.service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import java.util.Map;
/**
 * @Description:    短信发送服务
 * @Author:         liuji
 */
//@Service
public class SendSmsUtil {

    @Value("${alisms.accessKeyId}")
    private static String accessKeyId;
    @Value("${alisms.accessSecret}")
    private static String accessSecret;
    @Value("${alisms.signName}")
    private static String signName;
    @Value("${alisms.templateCode}")
    private static String templateCode;


    public static String aliSendSms(String PhoneNumbers,String TemplateParam){
        String result = "";
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-chengdu");
        request.putQueryParameter("PhoneNumbers", PhoneNumbers);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", TemplateParam);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            String infojson = response.getData();
            Gson gson2 = new Gson();
            Map map = gson2.fromJson(infojson, Map.class);
            String codes = map.get("Message").toString();
            System.out.println("codes="+codes);
            if(codes.equals("OK")){
                result="ok";
            }else {
                result="not_ok";
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        System.out.println("result="+result);
        return result;
    }

}

