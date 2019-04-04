package com.git.zxxxd.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类型为Date，进行转换
 */
public class DateTimeParameter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
           return simpleDateFormat.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
