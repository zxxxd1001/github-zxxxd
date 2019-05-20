package com.git.zxxxd.service.impl;

import com.git.zxxxd.dao.DeptsDao;
import com.git.zxxxd.entity.Depts;
import com.git.zxxxd.service.DeptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptsService {

    @Autowired
    DeptsDao deptDao;
    @Override
    public boolean add(Depts depts) {
      return   deptDao.addDept(depts);
    }

    @Override
    public Depts findById(Long deptNo) {
        return  deptDao.findById(deptNo);
    }

    @Override
    public List<Depts> findAll() {
        return deptDao.findAll();
    }
}