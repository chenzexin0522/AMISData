package com.amis.service;


import com.amis.common.ResponseVO;
import com.amis.entity.PhoneCode;
import com.amis.entity.UserPhoneCode;
import com.amis.entity.Users;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {


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

    /**
     * @Author chenzexin
     * @Date 2019/3/17 12:44
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        修改用户基本信息
     **/
    ResponseVO updateUser(Users users) throws Exception;

    /**
     * @Author chenzexin
     * @Date 2019/3/18 10:12
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        删除用户
     **/
    ResponseVO deleteUser(Users users) throws Exception;

    /**
     * @Author chenzexin
     * @Date 2019/3/18 10:50
     * @param phoneCode
     * @return com.amis.common.ResponseVO
     * @Description        添加手机号码-验证码
     **/
    ResponseVO insertPhoneCode(PhoneCode phoneCode) throws Exception;

    /**
     * @Author chenzexin
     * @Date 2019/3/18 16:16
     * @param phoneCode
     * @return com.amis.common.ResponseVO
     * @Description        验证验证码
     **/
    ResponseVO selectPhoneCode(PhoneCode phoneCode) throws Exception;

    /**
     * @Author chenzexin
     * @Date 2019/3/18 16:54
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        忘记密码
     **/
    ResponseVO forgetPassword(UserPhoneCode userPhoneCode)throws Exception;


    /**
     * @Author chenzexin
     * @Date 2019/3/18 17:40
     * @param phoneCode
     * @return com.amis.common.ResponseVO
     * @Description        验证验证码
     **/
    ResponseVO checkverCode(PhoneCode phoneCode)throws Exception;

}
