package com.amis.common.aliyuncsCode;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName GetCode
 * @Description 获取短信验证码
 * @Author chenzexin
 * @Date 2019/3/18 14:43
 **/
public class GetCode {



    public String getVerCode(String phone){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIZtJ2WMFq4Wqy", "SUagDyOsSbr50At4nuh2TG2vcQwNvQ");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "AIMS服务端");
        request.putQueryParameter("TemplateCode", "SMS_164830785");
        String VerCode = getMsgCode();
        request.putQueryParameter("TemplateParam", "{\"code\":\""+VerCode+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            int status = response.getHttpStatus();
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return VerCode;
    }
    /**
     * 生成随机的6位数，短信验证码
     * @return
     */
    private static String getMsgCode() {
        int n = 6;
        StringBuilder code = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            code.append(Integer.valueOf(ran.nextInt(10)).toString());
        }
        return code.toString();
    }
}
