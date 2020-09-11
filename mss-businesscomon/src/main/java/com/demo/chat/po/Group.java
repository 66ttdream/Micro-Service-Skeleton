package com.demo.chat.po;


import com.demo.chat.vo.User;

import java.util.List;

/**
 * @author liuji
 * @Deprecated 群组信息
 */
public class Group {
    //群id
    private String group_id;
    //群成员，list中包含群成员id
    private List<User> member;
    //群主
    private String group_owner;

}
