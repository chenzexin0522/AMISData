package com.amis.service.impl;

import com.amis.dao.UserDao;
import com.amis.entity.Users;
import com.amis.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName AdminServiceImpl
 * @Description 管理员业务层实现
 * @Author chenzexin
 * @Date 2019/3/29 17:57
 **/

@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserDao userDao;

    @Override
    public Users loginSub(String phone, String passowrd) {
        return userDao.cplogin(phone,passowrd);
    }
}
