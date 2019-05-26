package com.git.zxxxd.controller;

import com.git.zxxxd.entity.Depts;
import com.git.zxxxd.service.DeptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("depts")
public class DeptsController {
    @Autowired
    private DeptsService deptsService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody Depts Depts) {
        return   deptsService.add(Depts);
    }
    @RequestMapping(value = "findById/{deptNo}",method = RequestMethod.GET)
    public Depts findById(@PathVariable("deptNo") Long deptNo) {
        return  deptsService.findById(deptNo);
    }

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    public List<Depts> findAll() {
        return deptsService.findAll();
    }

    @PostMapping(value = "updateById")
    public void updateById(@RequestBody Depts Depts) {
        deptsService.updateById(Depts);
    }

    /**
     * 增加自己服务描述的接口
     * @return
     */
    @RequestMapping(value = "discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("总共有多少个微服务"+list.size());

        //查询STUDY-SPRINGCLOUD-DEPT 服务
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-DEPTS");

        //打印STUDY-SPRINGCLOUD-DEPT服务信息
        for (ServiceInstance element :instances){
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.discoveryClient;

    }

}
