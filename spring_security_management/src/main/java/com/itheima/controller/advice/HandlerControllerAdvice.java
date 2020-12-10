package com.itheima.controller.advice;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * 项 目 名 称：spring_security_management
 * 类 名 称：HandlerControllerAdvice
 * 类 描 述：TODO
 * 创建时间：2020/12/11 1:12 AM
 * 创 建 人：huanghao
 *
 * @version: V1.8
 */

/**
 * 异常处理器
 */
@ControllerAdvice
public class HandlerControllerAdvice {

    // 统一异常处理 403 页面
    @ExceptionHandler(AccessDeniedException.class)
    public String handlerException(){
        return "redirect:/403.jsp";
    }

    // 统一处理异常 404 页面
    @ExceptionHandler(Error.class)
    public String error(){
        return "redirect:/404.jsp";
    }

    // 统一异常处理 500 页面
    @ExceptionHandler(RuntimeException.class)
    public String runtimeException(){
        return "redirect:/500.jsp";
    }

}


