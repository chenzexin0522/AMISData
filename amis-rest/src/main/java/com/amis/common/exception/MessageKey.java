package com.amis.common.exception;


public interface MessageKey {
     String RETURN_OK = "0000";                                 //成功
    String SYSTEM_ERROR = "1001";                               //服务异常
    String REQUEST_EXCEPTIONS_OR_PARAMETER_ERROR = "1002";      //添加失败
    String PARAMETER_ERROR = "1003";                            //请求异常或参数错误
    String INSERT_FAIL= "1004";                                 //添加失败
    String PHOME_NUMBER_OR_PASSWORD_ERROR = "1005";             //账号或密码错误
    String PHOME_NUMBER_EXISTENCE = "1006";                     //您输入的号码已存在
    String DB_OPERATIONE_FAIL="1007";                           //数据库操作失败
    String VERCODE_NON_EXISTENT="1008";                         //您还未获取验证码
    String OLD_PASSWORD_ERROR="1009";                           //您输入的旧密码错误
    String DELETE_FAIL="1010";                                  //删除失败
    String UPDATE_FAIL="1011";                                  //插入失败
    String SELECT_FAIL="1012";                                  //查询失败
}
