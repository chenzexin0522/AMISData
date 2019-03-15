package com.amis.dao;

import com.amis.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    Users login(String u_phone);
}
