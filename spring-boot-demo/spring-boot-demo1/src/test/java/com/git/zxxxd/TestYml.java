package com.git.zxxxd;


import com.git.zxxxd.service.HelloService;
import com.git.zxxxd.ymlEntity.User;
import com.git.zxxxd.ymlEntity.YmlPerson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HelloWorldApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestYml {
    @Autowired
    private YmlPerson ymlPerson;
    @Value("${person.last-name}")
    private String lastName;

    @Autowired
    private User user;
    @Test
    public void test(){
        System.out.println(lastName);
        System.out.println(ymlPerson);
        System.out.println(user);

    }
}
