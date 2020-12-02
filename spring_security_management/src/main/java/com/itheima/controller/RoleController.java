package com.itheima.controller;

import com.itheima.domain.SysRole;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 角色控制层
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired //自动装配
    private RoleService roleService;

    //查询角色的所有数据
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<SysRole> list = roleService.findAll();
        model.addAttribute("list", list);
        return "role-list";
    }

    //根据角色 id添加数据
    @RequestMapping("/save")
    public String save(SysRole role){
        roleService.save(role);
        return "redirect:findAll";
    }
    
}
