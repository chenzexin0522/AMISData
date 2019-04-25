package com.amis.controller.demo;

import com.amis.common.ResponseVO;
import com.amis.common.redis.RedisConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @ClassName DemoController
 * @Description
 * @Author chenzexin
 * @Date 2019/4/24 11:31
 **/
@RestController
@RequestMapping(value = "redis")
public class DemoController {

    @RequestMapping("/get")
    public ResponseVO get(){
        RedisConfig redisConfig = new RedisConfig();
        Jedis jedis =redisConfig.getJedisPool();
        //Jedis jedis = new Jedis("127.0.0.1");
        //jedis.auth("amis123");
        jedis.set("age", "sdfsdgsgdfgdfgergrtg");
        System.out.println(jedis.get("age"));
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(null);
        return responseVO;    }

}
