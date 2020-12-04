package com.itheima.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

/**
 * 产品控制层
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    //查询产品所有数据
//    @Secured({"ROLE_PROUCT","ROLE_ADMIN"}) //开始授权认证注解 SpringSecurity 内置制定的注解
//    @RolesAllowed({"ROLE_PROUCT","ROLE_ADMIN"}) //Java 中的 api 的 jsr250 的注解
    @PreAuthorize("hasAnyAuthority('ROLE_PROUCT','ROLE_ADMIN')") //spring官方的提供的注解 el 表达式形式
    @RequestMapping("/findAll") ///
    public String findAll(){
        return "product-list";
    }
}
