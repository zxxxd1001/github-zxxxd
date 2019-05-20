package com.git.zxxxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient //开启发现服务功能
@SpringBootApplication
public class ConsumerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerUserApplication.class, args);
	}

	/**
	 * ribbon和eureka整合后consumer可以直接调用服务而不用关系地址和端口
	 * @return
	 */
	@LoadBalanced //使用负载均衡机制
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
