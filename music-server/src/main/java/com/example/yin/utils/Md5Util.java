package com.example.yin.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    //
    public static String md5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 对输入字符串进行加密处理
        byte[] bytes = md.digest(input.getBytes());

        // 将加密后的字节数组转换为16进制字符串
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            //Integer.toHexString方法将每个字节转换为16进制字符串。由于Integer.toHexString会忽略负数的符号位，因此需要通过(b & 0xFF)将字节转换为无符号整数，
            // 再通过| 0x100确保结果为两位16进制数。substring(1, 3)截取两位16进制数。
            String hex = Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3);
            sb.append(hex);
        }

        return sb.toString();

    }

}
