package com.git.zxxxd.domain.dao;

import com.git.zxxxd.domain.entity.PlanBedResourceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class PlanBedDao {

    private EntityManager entityManager;

    @Autowired
    public PlanBedDao(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    public void getPlanBedResourceLog(){
        List<PlanBedResourceLog> list=entityManager.createQuery("select q from PlanBedResourceLog q").getResultList();
        System.out.println(list.isEmpty()?0:list.size());
    }
}
