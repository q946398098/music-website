package com.example.yin;

import com.example.yin.model.domain.Consumer;
import com.example.yin.service.impl.ConsumerServiceImpl;
import com.example.yin.utils.TestFileUtil;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YinMusicApplicationTests {
    // 用户
    @Autowired
    ConsumerServiceImpl consumerService;
    @Test
    public void consumerTest3() throws ParseException {
        System.out.println(consumerService.userOfId(8));
    }
}
