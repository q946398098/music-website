package com.example.yin.handler;

import com.example.yin.common.R;
import io.minio.messages.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 处理其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R handleException(Exception e) {
        return R.error(e.getMessage());
    }
}
