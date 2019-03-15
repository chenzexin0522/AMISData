package com.amis.dao;

import com.amis.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    /**
     * @Author chenzexin
     * @Date 2019/3/15 15:58
     * @param u_phone
     * @return com.amis.entity.Users
     * @Description        手机短信验证登录
     **/
    Users login(String u_phone);

    /**
     * @Author chenzexin
     * @Date 2019/3/15 15:59
     * @param u_phone
     * @param u_password
     * @return com.amis.entity.Users
     * @Description        账号密码验证登录
     **/
    Users cplogin(String u_phone,String u_password);

    /**
     * @Author chenzexin
     * @Date 2019/3/15 16:02
     * @param users
     * @return com.amis.entity.Users
     * @Description        注册账号
     **/
    int register(Users users);

    /**
     * @Author chenzexin
     * @Date 2019/3/15 16:28
     * @param phone
     * @return com.amis.entity.Users
     * @Description        根据手机号码查询
     **/
    Users findByPhone(String u_phone);


}
