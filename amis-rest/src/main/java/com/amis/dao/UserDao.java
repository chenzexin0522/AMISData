package com.amis.dao;

import com.amis.common.ResponseVO;
import com.amis.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {


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

    /**
     * @Author chenzexin
     * @Date 2019/3/17 12:08
     * @param users
     * @return int
     * @Description        修改用户基本信息
     **/
    int updateUser(Users users);

    /**
     * @Author chenzexin
     * @Date 2019/3/18 10:13
     * @param users
     * @return int
     * @Description        删除用户
     **/
    int deleteUser(Users users);

    /**
     * @Author chenzexin
     * @Date 2019/3/18 16:52
     * @param users
     * @return int
     * @Description        忘记密码
     **/
    int forgetPassword(Users users);

    /**
     * @Author chenzexin
     * @Date 2019/3/19 14:02
     * @param users
     * @return int
     * @Description        修改手机号码
     **/
    int updatePhone(Users users);

    /**
     * @Author chenzexin
     * @Date 2019/3/19 16:04
     * @param users
     * @return int
     * @Description        修改密码
     **/
    int updatePassword(Users users);

    /**
     * @Author chenzexin
     * @Date 2019/3/19 16:07
     * @param users
     * @return com.amis.entity.Users
     * @Description        根据id和密码查询用户是否存在
     **/
    Users selectIdPassword(Users users);


    /**
     * @Author chenzexin
     * @Date 2019/4/12 10:21
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        修改图片
     **/
    ResponseVO updatePicture(Users users);
}
