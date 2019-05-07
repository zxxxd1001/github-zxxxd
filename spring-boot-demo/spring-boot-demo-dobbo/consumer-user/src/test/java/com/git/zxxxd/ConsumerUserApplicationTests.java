package com.git.zxxxd;

import com.git.zxxxd.bean.UserAddress;
import com.git.zxxxd.service.ConsumerService;
import com.git.zxxxd.service.UserService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerUserApplicationTests {
	@Autowired
	ConsumerService consumerService;

	@Test
	public void contextLoads() {

		consumerService.hello();
		consumerService.getUserAddressList();
	}

	@Test
	public void test() {
		List<UserAddress> list= consumerService.get();
		for(UserAddress u:list){
			System.out.println(u.getUserAddress());
		}
	}


}
