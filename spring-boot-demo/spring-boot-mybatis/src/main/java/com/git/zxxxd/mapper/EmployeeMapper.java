package com.git.zxxxd.mapper;

import com.git.zxxxd.bean.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface EmployeeMapper {
    Employee getById(Integer id);

    int insertEmployee(Employee employee);

    void insertEmp(Employee d);

    void insertMap(Map<String, Object> d);

    List getEmployee(Employee e);
}
