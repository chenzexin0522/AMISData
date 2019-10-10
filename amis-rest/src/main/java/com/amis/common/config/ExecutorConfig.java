package com.amis.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ExecutorConfig
 * @Description
 * @Author chenzexin
 * @Date 2019/10/10 16:15
 **/

@Configuration
@EnableAsync
public class ExecutorConfig {

    @Bean(name = "excetor")
    public Executor getExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(30);
        executor.setMaxPoolSize(40);
        executor.setQueueCapacity(30);
        executor.setKeepAliveSeconds(60);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        executor.setThreadNamePrefix("excetor_1");
        return executor;
    }

}
