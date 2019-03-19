package com.amis.controller.user;

import com.amis.common.ResponseVO;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.entity.PhoneCode;
import com.amis.entity.UserPhoneCode;
import com.amis.entity.Users;
import com.amis.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * @Author chenzexin
     * @Date 2019/3/11 11:01 
     * @param phoneCode
     * @return com.amis.common.ResponseVO
     * @Description  获取验证码
     **/
    @RequestMapping(value = "getVerCode",method = RequestMethod.POST)
    public ResponseVO getVerCode(@RequestBody PhoneCode phoneCode) throws Exception{
        if (phoneCode == null || StringUtils.isBlank(phoneCode.getP_phone())) {
             throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return userService.insertPhoneCode(phoneCode);
    }

    /**
     * @Author chenzexin
     * @Date 2019/3/18 10:33 
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        验证码登录
     **/
    @RequestMapping(value = "verCodeLogin",method = RequestMethod.POST)
    public ResponseVO verCodeLogin(@RequestBody PhoneCode phoneCode) throws Exception{
        if (phoneCode == null || StringUtils.isBlank(phoneCode.getP_phone())
            || StringUtils.isBlank(phoneCode.getP_verCode())) {
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return userService.selectPhoneCode(phoneCode);
    }

    /**
     * @Author chenzexin
     * @Date 2019/3/18 10:33
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        验证验证码
     **/
    @RequestMapping(value = "checkverCode",method = RequestMethod.POST)
    public ResponseVO checkverCode(@RequestBody PhoneCode phoneCode) throws Exception{
        if (phoneCode == null || StringUtils.isBlank(phoneCode.getP_phone())
                || StringUtils.isBlank(phoneCode.getP_verCode())) {
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return userService.checkverCode(phoneCode);
    }

    /**
     * @Author chenzexin
     * @Date 2019/3/15 15:15
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description      账号密码登录
     **/
    @RequestMapping(value = "usercplogin",method = RequestMethod.POST)
    public ResponseVO usercplogin(@RequestBody Users users) throws Exception {
        if (users == null || StringUtils.isBlank(users.getU_phone()) || StringUtils.isBlank(users.getU_password())) {
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return userService.cplogin(users);
    }

    /**
     * @Author chenzexin
     * @Date 2019/3/15 17:42
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        用户注册
     **/
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseVO register(@RequestBody Users users)throws Exception{
        if (users == null || StringUtils.isBlank(users.getU_name())
                || StringUtils.isBlank(users.getU_password())
                || StringUtils.isBlank(users.getU_phone())
                || StringUtils.isBlank(users.getU_gender())){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return userService.register(users);
    }

    /**
     * @Author chenzexin
     * @Date 2019/3/17 12:59
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        修改用户基本信息
     **/
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public ResponseVO updateUser(@RequestBody Users users) throws Exception{
        if (users == null || users.getU_role() == 0 || users.getU_id() == 0){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return userService.updateUser(users);
    }

    /**
     * @Author chenzexin
     * @Date 2019/3/18 10:15
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        删除用户
     **/
    @RequestMapping(value = "deleteUser",method = RequestMethod.POST)
    public ResponseVO deleteUser(@RequestBody Users users) throws Exception{
        if (users == null || users.getU_id() == 0){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return userService.deleteUser(users);
    }


    /**
     * @Author chenzexin
     * @Date 2019/3/18 17:12
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        忘记密码
     **/
    @RequestMapping(value = "forgetPassword",method = RequestMethod.POST)
    public ResponseVO forgetPassword(@RequestBody UserPhoneCode userPhoneCode)throws Exception{
        if (StringUtils.isBlank(userPhoneCode.getNewPassword())
                ||StringUtils.isBlank(userPhoneCode.getPhone())
                ||StringUtils.isBlank(userPhoneCode.getVerCode())){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return userService.forgetPassword(userPhoneCode);
    }



}
