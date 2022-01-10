package com.git.zxxxd.mapper.two;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.git.zxxxd.bean.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersTwoMapper  extends BaseMapper<Users> {
    Users getById(Integer id);

    int insertUsers(Users employee);
}
