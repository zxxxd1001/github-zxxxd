package com.git.zxxxd.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.git.zxxxd.bean.Employee;
import com.git.zxxxd.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Qualifier("empCacheManager")
    @Autowired
    RedisCacheManager empCacheManager;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Cacheable(value = "emp",cacheManager = "empCacheManager")
    public Employee getPathById(Integer id) {
        return employeeMapper.getById(id);
    }

    public Employee getById(Integer id) throws IOException {
        String msg = stringRedisTemplate.opsForValue().get(id.toString());
        ObjectMapper mapper = new ObjectMapper();
        if(msg==null){
            Employee e=employeeMapper.getById(id);
            //获取某个缓存
            stringRedisTemplate.opsForValue().append(id.toString(),mapper.writeValueAsString(e));
            return e;
        }else{
            return mapper.readValue(msg,Employee.class);
        }
    }

    public Employee insertEmployee(Employee id) {
        return id;
    }
}
