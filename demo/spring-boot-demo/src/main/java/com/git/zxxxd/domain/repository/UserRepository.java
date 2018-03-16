package com.git.zxxxd.domain.repository;


import com.git.zxxxd.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {
    private ConcurrentMap map = new ConcurrentHashMap();

    private AtomicInteger idGenerator =new AtomicInteger();

    public boolean save(User user) {
        int id = idGenerator.incrementAndGet();
        user.setId(id);
        return map.put(id, user) == null;
    }
}
