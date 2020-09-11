package com.demo.chat.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author liuji
 * @Deprecated 群组信息
 */
@Builder
@Getter
@AllArgsConstructor
public class User {
    //用户id
    private String user_id;
    //群id
    private String user_group;

    @Override
    public String toString() {
        return "{userid:"+user_id+",user_group"+user_group+"}";
    }
}
