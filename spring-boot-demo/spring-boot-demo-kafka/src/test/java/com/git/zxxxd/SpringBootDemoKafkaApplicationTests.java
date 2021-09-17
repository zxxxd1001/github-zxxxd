package com.git.zxxxd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoKafkaApplicationTests {

    /**
     * 1、单播（点对点） 注意service
     */
    @Test
    public void contextLoads() {

    }

    //接受数据,如何将数据自动的转为json发送出去
    @Test
    public void receive(){
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg(){
    }


    @Test
    public void addMessage(){
    }

}
