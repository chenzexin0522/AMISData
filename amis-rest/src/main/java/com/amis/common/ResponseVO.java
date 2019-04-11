package com.amis.common;

import com.amis.common.utils.AmisTools;
import lombok.Data;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 与Client端交互用的实体类
 *
 * @author infi.wang
 */
@Data
public class ResponseVO implements Serializable {

    private static final long serialVersionUID = 6010481115038758220L;

    private static final String RETURN_OK = "0000";

    private String resultCode;
    private String message;
    private Object data;
    private int id;

    public ResponseVO() {
        this.resultCode = RETURN_OK;
        this.message = getMessageByKey(RETURN_OK);
    }

    public ResponseVO(String messageKey) {
        this.resultCode = messageKey;
        this.message = getMessageByKey(messageKey);
    }

    public ResponseVO(String messageKey, String language) {
        this.resultCode = messageKey;
        this.message = getMessageByKey(messageKey,language);
    }

    /**
     *
     * @param messageKey key值
     * @return 信息
     */
    public static String getMessageByKey(String messageKey) {
        return AmisTools.getMessageByKey(messageKey);
    }
    public static String getMessageByKey(String messageKey,String language) {
        Locale locale = new Locale("zh", "CN");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", locale);
        return resourceBundle.getString(messageKey);
    }
}
