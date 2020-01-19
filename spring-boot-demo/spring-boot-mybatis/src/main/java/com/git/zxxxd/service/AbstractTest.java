package com.git.zxxxd.service;

import com.git.zxxxd.bean.Department;
import com.git.zxxxd.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Transactional(rollbackFor = Exception.class)
    public void abstractTest(){
        Department d=new Department();
        d.setDepartmentName("1");
        int i= departmentMapper.insertDeptById(d);
        testC();

        int y= new Integer(null);
    }
    public abstract void testC();
}
