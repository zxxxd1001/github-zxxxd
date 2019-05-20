package com.git.zxxxd.service;

import com.git.zxxxd.entity.Depts;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "PROVIDER-DEPTS",fallbackFactory =DeptClientServiceFallBackFactory.class )
@RequestMapping("depts")
public interface DeptClientService {
    @RequestMapping(value = "add", method = RequestMethod.POST)
    boolean add(Depts depts);

    @RequestMapping(value = "findById/{deptNo}", method = RequestMethod.GET)
    Depts findById(@PathVariable("deptNo") Long deptNo);

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    List findAll();

    @RequestMapping(value = "discovery")
    Object discovery();
}
