package com.example.yin.interceptor;


import com.example.yin.common.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public boolean preHandle( HttpServletRequest request,  HttpServletResponse response,  Object handler) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("name") == null){
            System.out.println("----1");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            R errorResponse = R.error("未授权，请登录");
            String jsonResponse = objectMapper.writeValueAsString(errorResponse);
//            response.getWriter().write("{\"message\": \"未授权，请登录\"}");
            response.getWriter().write(jsonResponse);
            return false;
        }
        return true;
    }


}
