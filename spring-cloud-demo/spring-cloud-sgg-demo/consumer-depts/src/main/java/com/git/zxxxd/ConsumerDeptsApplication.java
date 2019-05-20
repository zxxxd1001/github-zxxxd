package com.git.zxxxd;

import com.git.irule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="PROVIDER-DEPTS",configuration = MyRule.class)
public class ConsumerDeptsApplication {
    public static void main(String[] args) {
            SpringApplication.run(ConsumerDeptsApplication.class,args);
    }
}
