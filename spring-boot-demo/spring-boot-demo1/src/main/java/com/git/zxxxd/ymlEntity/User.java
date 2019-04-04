package com.git.zxxxd.ymlEntity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@PropertySource("classpath:user.properties")
@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private String names;
    private Integer age;
    private Date date;
    private Boolean flag;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "User{" +
                "names='" + names + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", flag=" + flag +
                '}';
    }
}
