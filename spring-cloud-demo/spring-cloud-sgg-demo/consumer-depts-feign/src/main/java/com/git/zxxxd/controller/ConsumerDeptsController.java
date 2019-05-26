package com.git.zxxxd.controller;

import com.git.zxxxd.entity.Depts;
import com.git.zxxxd.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consumer/depts")
public class ConsumerDeptsController {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "add")
    public boolean add(Depts depts) {
        return deptClientService.add(depts);
    }

    @RequestMapping("findById/{deptNo}")
    public Depts findById(@PathVariable("deptNo") Long deptNo) {
        return deptClientService.findById(deptNo);
    }

    @RequestMapping("findAll")
    public List findAll() {
        //三个参数：url,requestMap ResponseBean.class
        return deptClientService.findAll();
    }

    @PostMapping("updateById")
    public void findAll(@RequestBody Depts depts) {
        deptClientService.updateById(depts);
    }

    @RequestMapping(value = "discovery")
    public Object discovery(){
        return  deptClientService.discovery();
    }

}
