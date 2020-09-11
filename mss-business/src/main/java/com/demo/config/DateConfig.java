package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//@Configuration
public class DateConfig {
    /***
     * Date日期类型转换器
     * @return
     */
    /*@Bean
    public Formatter<Date> dateFormatter() {
        return new Formatter<Date>() {

            @Override
            public Date parse(String text, Locale locale) throws ParseException {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                try {
                    date = sdf.parse(text);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return date;
            }

            @Override
            public String print(Date object, Locale locale) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return sdf.format(object);
            }
        };
    }*/
}
