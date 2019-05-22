package com.git.zxxxd.dao;

import com.git.zxxxd.entity.Dept;
import com.git.zxxxd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class DeptService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private  UserService userService;

    public Dept getById(Integer id){
        return entityManager.find(Dept.class,id);
    }

    @Transactional
    public int deleteById(Integer id) {
        entityManager.remove(entityManager.find(Dept.class,id));
        return 1;
    }

    public int deleteByIds(Integer id) {
        entityManager.remove(entityManager.find(Dept.class,id));
        return 1;
    }

    @Transactional
    public void insertDept(Dept d) {
        entityManager.persist(d);
        User u=new User();
        u.setLastName("asd");
        userService.insertUser(u);
    }
}
