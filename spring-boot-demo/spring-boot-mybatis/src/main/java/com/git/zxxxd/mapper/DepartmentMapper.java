package com.git.zxxxd.mapper;

import com.git.zxxxd.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    int insertDeptById(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    int updateDeptById(Department department);
}
