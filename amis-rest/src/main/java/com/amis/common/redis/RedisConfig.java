package com.amis.common.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;


/**
 * @ClassName RedisConfig
 * @Description
 * @Author chenzexin
 * @Date 2019/4/24 11:29
 **/
//spring boot1.5以上版本@ConfigurationProperties取消location注解后的替代方案 cannot resolve method location   与@EnableConfigurationProperties是替代关系
//没有使用@Component或@Confinguration，因此此对象不会注册到Spring容器中，需要@EnableConfigurationProperties
@Component
@ConfigurationProperties(prefix = "spring.redis") //读取application.properties文件中以“spring.redis”开头的变量值。
public class RedisConfig {


    private String host;

    private int port;

    private String password;

    private int timeout;


    //@Bean    //此处注入JedisPoolConfig对象没有意义，不需要
    public Jedis getRedisConfig() {
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.auth("amis123");
        return jedis;
    }

    @Bean//@Bean注解将一个配置类的方法的返回值定义为一个bean，注册到spring里面
    public Jedis getJedisPool() {
        Jedis jedis = getRedisConfig();
        return jedis;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


      public String getPassword() {
            return password;
      }

      public void setPassword(String password) {
            this.password = password;
      }


    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
