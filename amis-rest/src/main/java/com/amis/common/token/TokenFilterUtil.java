package com.amis.common.token;

import com.amis.common.exception.MessageKey;
import com.amis.common.redis.RedisConfig;
import com.amis.common.utils.AmisTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * @ClassName TokenFilterUtil
 * @Description
 * @Author chenzexin
 * @Date 2019/4/24 16:11
 **/
@Component
public class TokenFilterUtil  extends HandlerInterceptorAdapter {

    RedisConfig redisConfig = new RedisConfig();
    Jedis jedis =redisConfig.getJedisPool();
    Logger logger = LoggerFactory.getLogger(TokenFilterUtil.class);
    /**
     * 拦截器---每做一步操作都会经过这拦截器
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        /**
         * 请求令牌
         */
        System.out.println("===================="+request.getRequestURI());
        try {
            String token = request.getHeader("token");
            String userid = request.getHeader("userid");
            String user_token = jedis.get(userid);
            if (user_token == null){
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                writer.append("{\"resultCode\":\"" + MessageKey.TOKEN_NON_EXISTENT
                        + "\",\"message\":\"" + AmisTools.getMessageByKey(MessageKey.TOKEN_NON_EXISTENT) + "\"}");
                writer.flush();
                writer.close();
                return false;
            }
            if(user_token.length() >= 32){
                user_token = user_token.substring(user_token.length()-32,user_token.length());
            }else{
                throw new Exception();
            }
            if (!token.equals(user_token)) {
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                writer.append("{\"resultCode\":\"" + MessageKey.TOKEN_VALIDATION_FAILED
                        + "\",\"message\":\"" + AmisTools.getMessageByKey(MessageKey.TOKEN_VALIDATION_FAILED) + "\"}");
                writer.flush();
                writer.close();
                return false;
            }
            /**
             * 保存最后操作时间
             */
           /*Long time = System.currentTimeMillis();
            stringRedisTemplate.opsForValue()
                    .set(token + ":lastTime", time.toString());*/
        } catch (Exception e) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.append("{\"resultCode\":\"" + MessageKey.TOKEN_NON_EXISTENT
                    + "\",\"message\":\"" + AmisTools.getMessageByKey(MessageKey.TOKEN_NON_EXISTENT) + "\"}");
            writer.flush();
            writer.close();
            return false;
        }
        return true;
    }

}
