//package com.itheima.controller.advice;
//
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 项 目 名 称：spring_security_management
// * 类 名 称：HandlerControllerException
// * 类 描 述：TODO
// * 创建时间：2020/12/11 12:45 AM
// * 创 建 人：huanghao
// *
// * @version: V1.8
// */
//
///**
// * 编写异常处理器
// */
//@Component //通用的注解
//public class HandlerControllerException implements HandlerExceptionResolver {
//
//    /**
//     * 重写该方法 resolveException
//     * @param httpServletRequest Serlvet 的 APi
//     * @param httpServletResponse APi
//     * @param o 出现异常的对象 哪个异常出异常了
//     * @param e 出现的异常信息
//     * @return  返回值 ModelAndView
//     */
//    @Override
//    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
//
//        //创建 异常的返回值 对象
//        ModelAndView mv  = new ModelAndView();
//
//        //将异常信息放入 request 域中.基本不用
//        mv.addObject("errorMessage",e.getMessage());
//
//        //指定不同异常跳转的页面 forwar: 请求转发 请求路径不变  redirect: 重定向 403.jsp
//        if (e instanceof AccessDeniedException){
//            mv.setViewName("redirect:/403.jsp");
//        } else{
//            mv.setViewName("redirect:/500.jsp");
//        }
//        return mv;
//
//    }
//}
