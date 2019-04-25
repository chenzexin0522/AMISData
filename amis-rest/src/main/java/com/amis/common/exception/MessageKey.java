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
    String INJECTION_FAIL="1100";                               //注入redis失败
    String TOKEN_NON_EXISTENT="1101";                           //token不存在
    String TOKEN_EXPIRED="1102";                                //token已过期
    String TOKEN_VALIDATION_FAILED="1103";                      //token验证失败
    String TOKEN_GENERATE_SUCCESS="1104";                       //token生成成功
    String LOGOUT_SUCCESS="1105";                               //退出登录成功
    String LOGOUT_FAIL="1106";                                  //退出登录失败
    String ONLINE_STATE="1107";                                 //请先退出已登录设备，再进行登录
}
