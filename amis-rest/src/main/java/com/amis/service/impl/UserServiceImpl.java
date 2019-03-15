package com.amis.service.impl;

import com.amis.common.ResponseVO;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
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
    public ResponseVO login(Users users)throws Exception{
        String u_phone = users.getU_phone();
        Users resultUsers = userDao.login(u_phone);
        if (resultUsers == null)    {
            throw new AmisException(MessageKey.PHOME_NUMBER_OR_PASSWORD_ERROR);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(resultUsers);
        return responseVO;
    }

    @Override
    public ResponseVO cplogin(Users users) throws Exception {
        String u_phone = users.getU_phone();
        String u_password = users.getU_password();
        Users resultUsers = userDao.cplogin(u_phone,u_password);
        if (resultUsers == null)    {
            throw new AmisException(MessageKey.PHOME_NUMBER_OR_PASSWORD_ERROR);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(resultUsers);
        return responseVO;
    }

    @Override
    public ResponseVO register(Users users) throws Exception {
        Users findUserPhone = findByPhone(users.getU_phone());
        if (findUserPhone != null){
            throw new AmisException(MessageKey.PHOME_NUMBER_EXISTENCE);
        }
        userDao.register(users);
        Users resultUsers = findByPhone(users.getU_phone());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(resultUsers);
        return responseVO;
    }


    /**
     * @Author chenzexin
     * @Date 2019/3/15 17:34
     * @param phone
     * @return com.amis.entity.Users
     * @Description        根据手机号码查找用户
     **/
    public Users findByPhone(String phone){
        return userDao.findByPhone(phone);
    }


}
