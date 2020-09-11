package com.demo.chat.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OnlineUser implements Serializable {
    private List<String> onlineUsers;
}
