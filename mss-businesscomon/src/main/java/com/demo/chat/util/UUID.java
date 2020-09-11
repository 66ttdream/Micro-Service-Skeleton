package com.demo.chat.util;

import static java.util.UUID.randomUUID;

public class UUID {
    public static String getUUID() {
        return randomUUID().toString();
    }
}
