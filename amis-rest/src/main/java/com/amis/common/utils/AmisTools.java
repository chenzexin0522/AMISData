package com.amis.common.utils;

import org.springframework.beans.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmisTools {

    private static Exception ex;

    /**
     * 私有构造方法，不允许实例化
     */
    private AmisTools() {
    } // End Tools

    /**
     * 判断一个对象是否为空 字符串则去除前后的空格进行比较 数组则按长度为0进行比较
     *
     * @param object 数据对象
     * @return true:数据对象为空;false:数据对象非空.
     */
    public static boolean isEmpty(Object object) {
        return YfDataType.isEmpty(object);
    } // End isEmpty

    /**
     * 输出信息到控制台
     *
     * @param object 输出的数据对象
     */
    public static void log(Object object) {
        System.out.println(object);
    } // End log

    public static String toHexString(byte[] bytes) {
        return toHexString(bytes, 0, bytes.length);
    }

    public static String toHexString(byte[] bytes, int start, int end) {
        StringBuffer sb = new StringBuffer();
        for (; start < end; ++start) {
            sb.append(String.format("%02x", bytes[start]));
        }
        return sb.toString();
    }


    public static String trimEnd(String stream, String trimstr) {
        // null或者空字符串的时候不处理
        if (stream == null || stream.length() == 0 || trimstr == null || trimstr.length() == 0) {
            return stream;
        }

        // 结束位置
        int epos = 0;

        // 正规表达式
        String regpattern = "[" + trimstr + "]*+";
        Pattern pattern = Pattern.compile(regpattern, Pattern.CASE_INSENSITIVE);

        // 去掉结尾的指定字符
        StringBuffer buffer = new StringBuffer(stream).reverse();
        Matcher matcher = pattern.matcher(buffer);
        if (matcher.lookingAt()) {
            epos = matcher.end();
            stream = new StringBuffer(buffer.substring(epos)).reverse().toString();
        }
        // 返回处理后的字符串
        return stream;
    }

    /**
     * 去掉指定字符串的开头和结尾的指定字符
     *
     * @return 处理后的字符串
     */
    public static String trim(String stream, String trimstr) {
        // null或者空字符串的时候不处理
        if (stream == null || stream.length() == 0 || trimstr == null || trimstr.length() == 0) {
            return stream;
        }

        // 结束位置
        int epos = 0;

        // 正规表达式
        String regpattern = "[" + trimstr + "]*+";
        Pattern pattern = Pattern.compile(regpattern, Pattern.CASE_INSENSITIVE);

        // 去掉结尾的指定字符
        StringBuffer buffer = new StringBuffer(stream).reverse();
        Matcher matcher = pattern.matcher(buffer);
        if (matcher.lookingAt()) {
            epos = matcher.end();
            stream = new StringBuffer(buffer.substring(epos)).reverse().toString();
        }
        // 去掉开头的指定字符
        matcher = pattern.matcher(stream);
        if (matcher.lookingAt()) {
            epos = matcher.end();
            stream = stream.substring(epos);
        }

        // 返回处理后的字符串
        return stream;
    }

    public static <T> T copy(T c) {
        if (AmisTools.isEmpty(c)) {
            return null;
        }
        T t = null;
        try {
            t = (T) c.getClass().newInstance();
            BeanUtils.copyProperties(c, t);
        } catch (Exception e) {
            return null;
        }
        return t;
    }


    /**
     * 根据key获取信息
     *
     * @param messageKey key值
     * @return 信息
     */
    public static String getMessageByKey(String messageKey) {
        Locale locale = new Locale("zh", "CN");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", locale);
        String message = "";
        try {
//            message = new String(resourceBundle.getString(messageKey).getBytes("ISO-8859-1"), "UTF-8");
            message = new String(resourceBundle.getString(messageKey).getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     * 获取http请求头部或者参数中的token值
     *
     * @param request http请求传递的值
     * @return 返回token
     */
    public static String getAuthToken(HttpServletRequest request) {
        String token;
        token = request.getParameter("accessToken");
        if (token == null) {
            token = request.getHeader("accessToken");
        }
        return token;
    }

    /**
     * 判断字符串中是否不包含字母<br> 如果包含字母就返回false,不包含字母就返回true
     *
     * @param resultStr 字符串
     * @return 判断结果
     */
    public static boolean checkIsNotContainLetters(String resultStr) {
        String re1 = "[^a-z]+$";
        Pattern p = Pattern.compile(re1, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = p.matcher(resultStr);
        return matcher.matches();
    }

    public static byte[] hexToByteArray(String s) {
        if (AmisTools.isEmpty(s)) {
            return null;
        }
        return hexToByteArray(s, 0, s.length());
    }

    public static byte[] hexToByteArray(String s, int start, int end) {
        int len = (end - start) / 2 * 2;
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(start + i), 16) << 4) + Character
                    .digit(s.charAt(start + i + 1), 16));
        }
        return data;
    }

}
