package com.amis.service;

import com.amis.entity.Users;
import org.springframework.stereotype.Service;

/**
 * @InterfaceName AdminService
 * @Description 管理员业务层
 * @Author chenzexin
 * @Date 2019/3/29 17:57
 **/
@Service
public interface AdminService {

    /**
     * @Author chenzexin
     * @Date 2019/3/29 18:07
     * @param phone
     * @param passowrd
     * @return com.amis.entity.Users
     * @Description        管理员登录
     **/
    Users loginSub(String phone, String passowrd);
}
