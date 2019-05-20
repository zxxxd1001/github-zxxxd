package com.git.zxxxd.service;

import com.git.zxxxd.entity.Depts;

import java.util.List;

public interface DeptsService {
    public boolean add(Depts deptEntity);

    public Depts findById(Long deptNo);

    public List findAll();
}
