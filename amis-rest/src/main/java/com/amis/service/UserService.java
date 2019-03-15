package com.amis.service;


import com.amis.common.ResponseVO;
import com.amis.entity.Users;

public interface UserService {

    /**
     * @Author chenzexin
     * @Date 2019/3/15 15:37
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        手机短信验证登录
     **/
    ResponseVO login(Users users) throws Exception;

    /**
     * @Author chenzexin
     * @Date 2019/3/15 15:08
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        账号密码验证登录
     **/
    ResponseVO cplogin(Users users) throws Exception;

    /**
     * @Author chenzexin
     * @Date 2019/3/15 16:04
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        注册账号
     **/
    ResponseVO register(Users users)throws Exception;



}
