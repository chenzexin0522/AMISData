package com.amis.dao;

import com.amis.entity.PhoneCode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName PhoneCodeDao
 * @Description 手机验证码
 * @Author chenzexin
 * @Date 2019/3/18 15:14
 **/
@Mapper
public interface PhoneCodeDao {


    /**
     * @Author chenzexin
     * @Date 2019/3/18 10:49
     * @param phoneCode
     * @return int
     * @Description        添加手机号码-验证码
     **/
    int insertPhoneCode(PhoneCode phoneCode);

    /**
     * @Author chenzexin
     * @Date 2019/3/18 16:14
     * @param phoneCode
     * @return com.amis.entity.PhoneCode
     * @Description        验证验证码
     **/
    PhoneCode selectPhoneCode(PhoneCode phoneCode);

    /**
     * @Author chenzexin
     * @Date 2019/3/18 16:25
     * @param phoneCode
     * @return int
     * @Description        删除手机验证码记录
     **/
    int deletePhoneCode(PhoneCode phoneCode);

    /**
     * @Author chenzexin
     * @Date 2019/3/18 18:30
     * @param phoneCode
     * @return int
     * @Description        删除验证码记录（手机号即验证码判断）
     **/
    int deletePhoneAndCode(PhoneCode phoneCode);

    /**
     * @Author chenzexin
     * @Date 2019/4/28 17:48
     * @param p_phone
     * @return com.amis.entity.PhoneCode
     * @Description        验证手号码
     **/
    PhoneCode verificationPhone(String p_phone);
}
