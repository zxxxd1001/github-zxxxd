package com.git.zxxxd.test;

import com.git.zxxxd.service.HelloService;
import com.git.zxxxd.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestConfiguration {

    @Autowired
    private UserService userService;

    @Autowired
    private HelloService helloService;

    @Test
    public void test(){
        System.out.println(userService);
        System.out.println(helloService);
    }
}
