package com.git.zxxxd.service;

import com.git.zxxxd.bean.Employee;
import com.git.zxxxd.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public int insertEmploy(Employee e){
        return employeeMapper.insertEmployee(e);
    }
}
