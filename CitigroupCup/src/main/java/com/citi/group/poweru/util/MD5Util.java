package com.dream.util;

import java.security.MessageDigest;

/**
 * @Auther YanZhiJian
 * @Date 2020/7/2 2:22 下午
 */
public class MD5Util {

    private static MessageDigest md5 = null;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用于获取一个String的MD5值
     * @param string 字符串
     * @return String
     */
    public static String getMd5(String string) {
        byte[] bs = md5.digest(string.getBytes());
        StringBuilder sb = new StringBuilder(40);
        for (byte x : bs) {
            if ((x & 0xff) >> 4 == 0) {
                sb.append("0").append(Integer.toHexString(x & 0xff));
            } else {
                sb.append(Integer.toHexString(x & 0xff));
            }
        }
        return sb.toString();
    }
}
