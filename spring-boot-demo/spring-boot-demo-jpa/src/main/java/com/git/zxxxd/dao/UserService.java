package com.git.zxxxd.dao;

import com.git.zxxxd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;

    public User getById(Integer id){
        return entityManager.find(User.class,id);
    }

    @Transactional
    public void insertUser(User id) {
        entityManager.persist(id);
    }


}
