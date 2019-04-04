package com.git.zxxxd.mapper;

import com.git.zxxxd.bean.Employee;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeMapper {
    Employee getById(Integer id);
    int insertEmployee(Employee employee);
}
