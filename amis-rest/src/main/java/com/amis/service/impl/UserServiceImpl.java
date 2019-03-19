package com.amis.service.impl;

import com.amis.common.ResponseVO;
import com.amis.common.aliyuncsCode.GetCode;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.dao.PhoneCodeDao;
import com.amis.dao.UserDao;
import com.amis.entity.PhoneCode;
import com.amis.entity.UserPhoneCode;
import com.amis.entity.Users;
import com.amis.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PhoneCodeDao phoneCodeDao;

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
        int os = userDao.register(users);
        if (os == 0){
            throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
        }
        Users resultUsers = findByPhone(users.getU_phone());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(resultUsers);
        return responseVO;
    }

    @Override
    public ResponseVO updateUser(Users users) throws Exception {
            int os = userDao.updateUser(users);
            if (os == 0){
                throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
            }
            ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
            return responseVO;
    }

    @Override
    public ResponseVO deleteUser(Users users) throws Exception {
        int os = userDao.deleteUser(users);
        if (os == 0){
            throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    @Override
    public ResponseVO insertPhoneCode(PhoneCode phoneCode) throws Exception {
        GetCode getCode = new GetCode();
        String retule = getCode.getVerCode(phoneCode.getP_phone());
        phoneCode.setP_verCode(retule);
        int os = phoneCodeDao.insertPhoneCode(phoneCode);
        if (os == 0){
            throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    @Override
    public ResponseVO selectPhoneCode(PhoneCode phoneCode) throws Exception {
        PhoneCode phoneCode1 = phoneCodeDao.selectPhoneCode(phoneCode);
        if (phoneCode1 == null || StringUtils.isBlank(phoneCode1.getP_verCode())
        || StringUtils.isBlank(phoneCode1.getP_phone())){
            throw new AmisException(MessageKey.VERCODE_NON_EXISTENT);
        }
        int os = phoneCodeDao.deletePhoneCode(phoneCode1);
        if (os == 0){
            throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(this.findByPhone(phoneCode.getP_phone()));
        return responseVO;
    }

    @Override
    public ResponseVO forgetPassword(UserPhoneCode userPhoneCode) throws Exception {
        Users users = new Users();
        users.setU_password(userPhoneCode.getNewPassword());
        users.setU_phone(userPhoneCode.getPhone());
        PhoneCode phoneCode = new PhoneCode();
        phoneCode.setP_phone(userPhoneCode.getPhone());
        phoneCode.setP_verCode(userPhoneCode.getVerCode());
        int os = userDao.forgetPassword(users);
        if (os == 0){
            throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
        }
        int is = phoneCodeDao.deletePhoneAndCode(phoneCode);
        if (is == 0){
            throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(this.findByPhone(phoneCode.getP_phone()));
        return responseVO;
    }

    @Override
    public ResponseVO checkverCode(PhoneCode phoneCode) throws Exception {
        PhoneCode phoneCode1 = phoneCodeDao.selectPhoneCode(phoneCode);
        if (phoneCode1 == null || StringUtils.isBlank(phoneCode1.getP_verCode())
                || StringUtils.isBlank(phoneCode1.getP_phone())){
            throw new AmisException(MessageKey.VERCODE_NON_EXISTENT);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
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
