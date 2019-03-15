package com.amis.service.impl;

import com.amis.dao.UserDao;
import com.amis.entity.Users;
import com.amis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Users login(String u_phone) {
        Users users = userDao.login(u_phone);
        return users;
    }
}
