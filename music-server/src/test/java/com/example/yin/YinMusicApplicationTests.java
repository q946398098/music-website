package com.example.yin;

import com.example.yin.model.domain.Consumer;
import com.example.yin.service.impl.ConsumerServiceImpl;
import com.example.yin.utils.Md5Util;
import com.example.yin.utils.TestFileUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YinMusicApplicationTests {
    // 用户
//    @Autowired
//    ConsumerServiceImpl consumerService;
    @Test
    public void consumerTest3() throws ParseException, NoSuchAlgorithmException {


        String s1 = DigestUtils.md5Hex("123456");

        System.out.println(s1);

        String s = Md5Util.md5("123456");

        System.out.println(s);


    }
}
