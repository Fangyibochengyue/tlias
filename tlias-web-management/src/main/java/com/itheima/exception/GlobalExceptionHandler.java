package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)//捕获所有类型的异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("对不起,操作失败,请联系管理员");
    }
}