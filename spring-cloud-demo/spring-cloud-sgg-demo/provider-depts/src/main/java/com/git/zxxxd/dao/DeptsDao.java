package com.git.zxxxd.dao;

import com.git.zxxxd.entity.Depts;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeptsDao {
    /**
     * 插入
     * @param Depts
     *
     * @return
     */
    boolean addDept(Depts Depts);

    /**
     * 根据id查找
     * @param deptNo
     * @return
     */
    Depts findById(Long deptNo);

    /**
     * 查询全部
     * @return
     */
    List<Depts> findAll();
}
