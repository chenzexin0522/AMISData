package com.amis.controller.user;

import com.amis.common.ResponseVO;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
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
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description  获取验证码
     **/
    @RequestMapping(value = "getVerCode",method = RequestMethod.POST)
    public ResponseVO getVerCode(@RequestBody Users users) throws Exception{
        String verCode = "662842";
        String relustVerCode="[AMIS]验证码："+verCode+" (AMIS欢迎您)";
        if (users == null || StringUtils.isBlank(users.getU_phone())) {
             throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(relustVerCode);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/3/11 13:43
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description      验证码登录
     **/
    @RequestMapping(value = "userlogin",method = RequestMethod.POST)
    public ResponseVO userlogin(@RequestBody Users users) throws Exception{
        if (users == null || StringUtils.isBlank(users.getU_phone())) {
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return userService.login(users);
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




}
