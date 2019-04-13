package com.git.zxxxd.mapper;

import com.git.zxxxd.bean.Employee;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeMapper {
    @Select("select * from employee where id=#{id}")
    Employee getById(Integer id);

    int insertEmployee(Employee employee);
}
