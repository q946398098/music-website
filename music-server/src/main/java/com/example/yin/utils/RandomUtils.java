package com.example.yin.utils;

import java.util.Random;

public class RandomUtils {
    public static String code(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // 可以包含的字符集合
        int length = 5; // 生成的字符串长度为5个字符
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            //生成一个随机的整数，范围从 0(包含)到指定值(不包含)
            //nextDouble
            int randomIndex = random.nextInt(characters.length());
            //该索引上的字符
            char randomChar = characters.charAt(randomIndex);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }
}
