package com.example.yin;

import com.example.yin.service.impl.ConsumerServiceImpl;
import com.example.yin.utils.TestFileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YinMusicApplicationTests {
    // 用户
    @Test
    public void consumerTest3()
    {
        System.out.println(TestFileUtil.getPath());

    }
}
