package com.demo.chat.util;


public class GenerateCronUtil {
    private static String[] weekDays = { "MON", "TUE", "WED", "THU", "FRI", "SAT","SUN" };
    public static String getCron(String type,String code){
        if(type=="everyDay"){
            //"0 0 12 * * ?" 每天中午12点触发
            String[] c = code.split(":");
            String s = "0 "+c[1]+" "+c[0]+" * * ?";

        }
        if(type=="everyWeek"){
            //0 0 12 ? * WED 表示每个星期三中午12点
            String s = "0 0 9 ? *"+" "+weekDays[Integer.valueOf(code)-1];
            return s;
        }
        if(type=="everyMonth"){
            //"0 15 10 15 * ?" 每月15日上午10:15触发
            String s = "0 0 9 "+code+" * ?";
            return s;
        }
        else {
            return null;
        }
    }
}
