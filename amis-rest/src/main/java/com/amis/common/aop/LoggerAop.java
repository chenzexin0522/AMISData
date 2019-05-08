package com.amis.common.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Component
@Aspect
public class LoggerAop {

    private Logger logger = LoggerFactory.getLogger(LoggerAop.class);
    @Pointcut("execution(public * com.amis.controller..*.*(..))")
    public void loggerPoint(){

    }
    @Before("loggerPoint()")
    public void controllerBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("接口url:"+request.getRequestURI());
        Enumeration<String> parameterNames = request.getParameterNames();
        logger.info("请求地址:"+request.getRequestURL().toString());
        logger.info("请求方式:"+request.getMethod());
        logger.info("请求类方法:"+joinPoint.getSignature());
        logger.info("请求类方法参数:"+ Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(returning = "map",pointcut = "loggerPoint()")
    public void controllerAfter(Object map){
        logger.info("出参："+JSONObject.toJSONString(map));
    }
}
