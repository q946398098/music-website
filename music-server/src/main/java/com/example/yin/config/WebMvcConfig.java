package com.example.yin.config;

//import com.example.yin.interceptor.CorsInterceptor;
import com.example.yin.interceptor.CorsInterceptor;
import com.example.yin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 祝英台炸油条
 * @Time : 2022/6/7 17:08
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public CorsInterceptor corsInterceptor() {
        return new CorsInterceptor();
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(corsInterceptor())
               .addPathPatterns("/**");

        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/admin/login/status")
                .excludePathPatterns("/user01/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 如果服务器返回了 Access-Control-Allow-Origin，
        // 浏览器会进一步检查 Access-Control-Allow-Credentials
        // 如果 Access-Control-Allow-Credentials 为 false，浏览器会阻止跨域请求携带凭证（如 Cookie)
        // 即使 Access-Control-Allow-Origin 被设置为允许跨域，如果 Access-Control-Allow-Credentials 为 false，浏览器仍然会阻止跨域请求携带凭证
        registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("*").allowedHeaders("*").allowCredentials(true);
    }


}