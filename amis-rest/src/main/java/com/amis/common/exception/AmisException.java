package com.amis.common.exception;

import com.amis.common.utils.AmisTools;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class AmisException extends Exception implements Serializable {

    private static final long serialVersionUID = -3981092309290166672L;
    private String result;
    private MessageKey resultMessage;

    /*
    构造方法
     */
    public AmisException() {
    }


    /**
     * 自定义业务异常
     *
     * @param messageKey 消息编号
     */
    public AmisException(String messageKey) {
        super(AmisTools.getMessageByKey(messageKey));
        this.setResult(messageKey);
    }


    /**
     * 自定义业务异常
     *
     * @param result  消息编号
     * @param message 消息
     */
    public AmisException(String result, String message) {
        super(message);
        this.setResult(result);
    }


    /**
     * 自定义业务异常
     *
     * @param e       异常信息
     * @param result  消息编号
     * @param message 占位符中参数
     */
    public AmisException(Exception e, String result, String message) {
        super(message, e);
        this.setResult(result);
    }

    /**
     * 自定义业务异常
     *
     * @param messageKey 消息编号
     * @param message    消息
     */
    public AmisException(String messageKey, Object... message) {
        super(String.format(AmisTools.getMessageByKey(messageKey), message));
        this.setResult(messageKey);
    }
}
