package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品控制层
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    //查询产品所有数据
    @RequestMapping("/findAll") ///
    public String findAll(){
        return "product-list";
    }
}
