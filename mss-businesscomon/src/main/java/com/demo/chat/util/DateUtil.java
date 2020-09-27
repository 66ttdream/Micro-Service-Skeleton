package com.demo.chat.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

   //获取月和日
    public static String parse(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String d = df.format(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(d,formatter);
        int month = localDateTime.getMonth().getValue();
        int day = localDateTime.getDayOfMonth();
        return Integer.toString(month)+"-"+Integer.toString(day);
    }

    //获取日期是星期几
    public static String getWeekOfDate(Date date) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    //获取当前时:分
    public static String getCurrentHourMinute() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        return hour + ":" + minute;
    }
    /**
     * 获取前一天的工作日日期
     * @return
     */
    public static Date getPreDay(Date date) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = c.getTime();
        return yesterday;
    }
    /**
     * 获取后一天的工作日日期
     * @return
     */
    public static Date getLaterDay(Date date) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date yesterday = c.getTime();
        return yesterday;
    }
}
