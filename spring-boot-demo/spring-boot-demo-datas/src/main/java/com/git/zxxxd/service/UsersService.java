package com.git.zxxxd.service;

import com.git.zxxxd.bean.Users;
import com.git.zxxxd.mapper.one.UsersOneMapper;
import com.git.zxxxd.mapper.two.UsersTwoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

    private UsersOneMapper usersOneMapper;
    private UsersTwoMapper usersTwoMapper;

    @Autowired
    public UsersService(UsersOneMapper usersOneMapper, UsersTwoMapper usersTwoMapper) {
        this.usersOneMapper = usersOneMapper;
        this.usersTwoMapper = usersTwoMapper;
    }

    @Transactional
    public Users save(Users users) {
        if (users.getId() % 2 != 0) {
            int i = usersOneMapper.insertUsers(users);
        } else {
            int i = usersTwoMapper.insertUsers(users);
        }
        return users;

//        int i = usersOneMapper.insertUsers(users);
//        int x = 1;
//        int y = 0;
//        x = x % y;
//        i = usersTwoMapper.insertUsers(users);
//        return users;
    }

    public Users get(Integer id) {
        if (id % 2 != 0) {
            return usersOneMapper.getById(id);
        }
        return usersTwoMapper.getById(id);
    }

    public Users getPlus(Integer id) {
        if (id % 2 != 0) {
            return usersOneMapper.selectById(id);
        }
        return usersTwoMapper.selectById(id);
    }

    public Users savePlus(Users users) {
        if (users.getId() % 2 != 0) {
            int i = usersOneMapper.insertUsers(users);
        } else {
            int i = usersTwoMapper.insertUsers(users);
        }
        return users;
    }
}
