package com.amis.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.common.utils.AmisTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常拦截类
 */
@ControllerAdvice
@Slf4j
public class RestControllerAdvice {


    /**
     * 全局异常捕捉处理
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(HttpServletRequest request, Exception ex) throws AmisException {
        Map<String, Object> map = new HashMap();
        map.put("resultCode", MessageKey.SYSTEM_ERROR);
        map.put("message", AmisTools.getMessageByKey(MessageKey.SYSTEM_ERROR));
        logger(request, ex, map);
        return map;
    }

    /**
     * 全局异常捕捉处理
     */
    @ResponseBody
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Map errorHandler(HttpServletRequest request, HttpMessageNotReadableException ex) throws AmisException {
        Map<String, Object> map = new HashMap();
        log.error("================================ip============RestControllerAdvice" +request.getRemoteAddr());
        map.put("resultCode", MessageKey.REQUEST_EXCEPTIONS_OR_PARAMETER_ERROR);
        map.put("message", AmisTools.getMessageByKey(MessageKey.REQUEST_EXCEPTIONS_OR_PARAMETER_ERROR));
        logger(request, ex, map);
        return map;
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     */
    @ResponseBody
    @ExceptionHandler(value = AmisException.class)
    public Map errorHandler(HttpServletRequest request, AmisException ax) {
        Map<String, Object> map = new HashMap();
        map.put("resultCode", ax.getResultCode());
        map.put("message", ax.getMessage());
        logger(request, ax, map);
        return map;
    }

    /**
     * 记录日志
     */
    public void logger(HttpServletRequest request, Exception ex, Map<String, Object> resultMap) {
        StringBuffer msg = new StringBuffer();
        msg.append("异常拦截日志:");
        msg.append("[uri:").append(request.getRequestURI()).append("]");
        Enumeration<String> enumer = request.getParameterNames();
        while (enumer.hasMoreElements()) {
            String name = enumer.nextElement();
            String[] values = request.getParameterValues(name);
            msg.append("[").append(name).append("=");
            if (values != null) {
                int i = 0;
                for (String value : values) {
                    i++;
                    msg.append(value);
                    if (i < values.length) {
                        msg.append("｜");
                    }
                }
            }
            msg.append("]");
        }
//        msg.append("YFHeader:");
//        msg.append(JSON.toJSONString(YFHeaderUtils.getYFHeader(request)));
        msg.append("错误代码：");
        msg.append(JSON.toJSONString(resultMap));
        if (ex instanceof AmisException) {
            log.warn(msg.toString());
            log.warn("错误日志堆栈信息：", ex);
        } else if (ex instanceof RuntimeException) {
            log.error(msg.toString());
            log.error("错误日志堆栈信息：", ex);
        }
    }
}
