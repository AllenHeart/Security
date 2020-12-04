package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单控制层`
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    //查询订单所有的数据
    @RequestMapping("/findAll")
    public String findAll(){
        return "order-list";
    }
}
