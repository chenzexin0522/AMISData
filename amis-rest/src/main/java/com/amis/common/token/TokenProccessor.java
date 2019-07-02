package com.amis.common.token;

import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.common.md5.MD5Config;
import com.amis.common.redis.RedisConfig;
import com.amis.entity.Users;
import redis.clients.jedis.Jedis;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName TokenProccessor
 * @Description
 * @Author chenzexin
 * @Date 2019/4/24 15:52
 **/
public class TokenProccessor {
    private TokenProccessor(){}
    private static final TokenProccessor instance = new TokenProccessor();

    public static TokenProccessor getInstance() {
        return instance;
    }

    /**
     * 生成Token-Demo
     * @return
     */
    public static String makeToken() {
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @Author chenzexin
     * @Date 2019/4/25 11:41
     * @param users
     * @return java.lang.String
     * @Description        添加
     **/
    public static String addtoken(int id) throws Exception {
        RedisConfig redisConfig = new RedisConfig();
        Jedis jedis = redisConfig.getJedisPool();
        if (jedis == null){
            throw new AmisException(MessageKey.INJECTION_FAIL);
        }
        Long tokenStr = id + new Date().getTime();
        String token = MD5Config.md5Password(String.valueOf(tokenStr));
        System.out.println("token=============="+token);
        jedis.set(String.valueOf(id),token);           //将map：id = token ，加入到redis中
        jedis.expire(token,60*60*24*7);
        return token;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/25 11:41
     * @param users
     * @return java.lang.String
     * @Description        删除token
     **/
        public static boolean deletetoken(Users users) throws Exception {
        RedisConfig redisConfig = new RedisConfig();
        Jedis jedis = redisConfig.getJedisPool();
        if (jedis == null){
            throw new AmisException(MessageKey.INJECTION_FAIL);
        }
        jedis.del(String.valueOf(users.getU_id()));
        return true;
    }


}
