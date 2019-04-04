package com.git.zxxxd.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateParameter implements Formatter<Date> {
    //日期格式化对象
    private SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public String print(Date date, Locale local) {
        return dateFormat.format(date);
    }
    //解析文本字符串返回一个Formatter<T>类型对象
    @Override
    public Date parse(String source, Locale local) throws ParseException {
        return dateFormat.parse(source);
    }
}
