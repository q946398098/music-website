package com.example.yin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 说明：解决以下问题
 * <p>
 *     因使用WebMvcConfigurer加载静态时 url encode编码无法解析为正常中文问题
 * </p>
 *
 */

@EnableWebMvc
@Configuration
public class WebCharacterEncodingFilter implements WebMvcConfigurer {

    /**
     * 乱码处理
     */
    public HttpMessageConverter<String> responseBodyConverter() {
        final StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converter.setWriteAcceptCharset(false);
        return converter;
    }


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        if (!converters.isEmpty()) {
//            System.out.println("消息转换器长度是+" + converters.size());
            //将第一个扔到最后面，否则会覆盖掉默认的转换器
            converters.add(converters.get(0));
            //将自己的转换器放到第一个
            converters.set(0, responseBodyConverter());
        } else {
            converters.add(responseBodyConverter());
        }

        /*添加消息转换器，*/
//        for(HttpMessageConverter s: converters ){
//            System.out.println("消息转换器是+" + s.getClass().getName());
//        }
    }
}

