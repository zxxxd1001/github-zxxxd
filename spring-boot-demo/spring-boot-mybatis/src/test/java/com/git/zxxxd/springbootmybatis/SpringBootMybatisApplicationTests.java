package com.git.zxxxd.springbootmybatis;

import com.git.zxxxd.bean.Department;
import com.git.zxxxd.mapper.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void contextLoads() {
        Department d= departmentMapper.getDeptById(1);
        System.out.println();
    }

}
