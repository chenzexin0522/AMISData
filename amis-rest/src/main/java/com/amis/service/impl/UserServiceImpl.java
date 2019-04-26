package com.amis.service.impl;

import com.amis.common.ResponseVO;
import com.amis.common.aliyuncsCode.GetCode;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.common.md5.MD5Config;
import com.amis.common.token.TokenProccessor;
import com.amis.common.utils.BasePicture;
import com.amis.dao.PhoneCodeDao;
import com.amis.dao.UserDao;
import com.amis.entity.Feedback;
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
        u_password = MD5Config.md5Password(u_password);
        Users resultUsers = userDao.cplogin(u_phone,u_password);
        if (resultUsers == null)    {
            throw new AmisException(MessageKey.PHOME_NUMBER_OR_PASSWORD_ERROR);
        }
        //if (users.getLog_state() == 1){                                       //判断登录状态：1-在线，则不允许登录
        //    ResponseVO responseVO = new ResponseVO(MessageKey.ONLINE_STATE);
        //     return responseVO;
        // }
        String tokenStr = TokenProccessor.addtoken(users);
        resultUsers.setToken(tokenStr);
        resultUsers.setLog_state(1);
        userDao.updateLogState(resultUsers);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(resultUsers);
        return responseVO;
    }

    @Override
    public ResponseVO register(Users users) throws Exception {
        String smgName = BasePicture.GenerateImage(users.getU_picture(),users.getU_phone());
        users.setU_picture(smgName);
        Users findUserPhone = findByPhone(users.getU_phone());
        if (findUserPhone != null){
            throw new AmisException(MessageKey.PHOME_NUMBER_EXISTENCE);
        }
        users.setU_password(MD5Config.md5Password(users.getU_password()));
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
        int os = 1 ; // phoneCodeDao.deletePhoneCode(phoneCode1);           //删除获取到的验证码------测试隐藏
        if (os == 0){
            throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
        }
        Users users = this.findByPhone(phoneCode.getP_phone());
        //if (users.getLog_state() == 1){                                       //判断登录状态：1-在线，则不允许登录
        //    ResponseVO responseVO = new ResponseVO(MessageKey.ONLINE_STATE);
       //     return responseVO;
       // }
        String tokenStr = TokenProccessor.addtoken(users);
        users.setToken(tokenStr);
        users.setLog_state(1);
        userDao.updateLogState(users);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(users);
        return responseVO;
    }

    @Override
    public ResponseVO forgetPassword(UserPhoneCode userPhoneCode) throws Exception {
        Users users = new Users();
        users.setU_password(userPhoneCode.getNewPassword());
        users.setU_phone(userPhoneCode.getPhone());
        users.setU_password(MD5Config.md5Password(users.getU_password()));
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

    @Override
    public ResponseVO updatePhone(UserPhoneCode userPhoneCode) throws Exception {
        Users users = new Users();
        users.setU_id(userPhoneCode.getId());
        users.setU_phone(userPhoneCode.getNewPhone());
        PhoneCode newphoneCode = new PhoneCode();
        newphoneCode.setP_phone(userPhoneCode.getPhone());
        newphoneCode.setP_verCode(userPhoneCode.getVerCode());
        PhoneCode oldphoneCode = new PhoneCode();
        oldphoneCode.setP_phone(userPhoneCode.getNewPhone());
        oldphoneCode.setP_verCode(userPhoneCode.getNewverCode());
        int os = userDao.updatePhone(users);
        if (os == 0){
            throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
        }
        int is = phoneCodeDao.deletePhoneAndCode(oldphoneCode);
        int as = phoneCodeDao.deletePhoneAndCode(newphoneCode);
        if (is == 0 || as == 0){
            throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    @Override
    public ResponseVO updatePassword(Users users) throws Exception {
        Users users1 = userDao.selectIdPassword(users);
        if (users1 == null){
            throw new AmisException(MessageKey.OLD_PASSWORD_ERROR);
        }
        users.setU_password(MD5Config.md5Password(users.getU_password()));
        int is = userDao.updatePassword(users);
        if (is == 0){
            throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    @Override
    public ResponseVO updatePicture(Users users) {
//        byte[] bs = users.getU_picture();
//         if (bs.length > 0) {
//   try {
//    String filePath = "保存路径";
//    System.out.println("开始上传");
//    File validateCodeFolder = new File(filePath);
//    if (!validateCodeFolder.exists()) {
//     validateCodeFolder.mkdirs();
//    }
        return userDao.updatePicture(users);
    }

    @Override
    public ResponseVO insertFeedback(Feedback feedback) throws Exception {
        int os = userDao.insertFeedback(feedback);
        if (os == 0){
            throw new AmisException(MessageKey.INSERT_FAIL);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    @Override
    public ResponseVO Logout(String token,Users users) throws Exception {
        boolean os = TokenProccessor.deletetoken(token);
        if (os == false){
            ResponseVO responseVO = new ResponseVO(MessageKey.LOGOUT_FAIL);
            return responseVO;
        }
        users.setLog_state(2);
        userDao.updateLogState(users);
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
