package com.git.zxxxd.controller;

import com.git.zxxxd.entity.Depts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer/depts")
public class ConsumerDeptsController {
//    private static final String REST_URL_PREFIX="http://localhost:8001";
    /**
     * 注册再EurekaServer中的微服务名称
     */
    private static final String REST_URL_PREFIX="http://PROVIDER-DEPTS";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "add")
    public boolean add(Depts Depts) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/depts/add", Depts, Boolean.class);
    }

    @RequestMapping("findById/{deptNo}")
    public Depts findById(@PathVariable("deptNo") Long deptNo) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/depts/findById/" + deptNo, Depts.class);
    }

    @RequestMapping("findAll")
    public List findAll() {
        //三个参数：url,requestMap ResponseBean.class
        return restTemplate.getForObject(REST_URL_PREFIX + "/depts/findAll", List.class);
    }

    @RequestMapping(value = "discovery")
    public Object discovery(){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/depts/discovery", Object.class);
    }

}
