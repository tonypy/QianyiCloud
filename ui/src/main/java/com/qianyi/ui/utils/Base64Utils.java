package com.qianyi.ui.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * @author tonypy
 * 2018/2/24
 * base64编解码工具
 * */
public class Base64Utils {

    /**
     * base64编码
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encodeStr(String str) throws UnsupportedEncodingException{
        Base64 base64=new Base64();
        byte [] bytes = str.getBytes("UTF-8");
        String result = base64.encodeToString(bytes);
        return result;
    }

    /**
     * base64解码
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String decodeStr(String str) throws UnsupportedEncodingException{
        byte[] b = str.getBytes();
        Base64 base64 = new Base64();
        b = base64.decode(b);
        String s=new String(b, "UTF-8");
        return s;
    }

}
