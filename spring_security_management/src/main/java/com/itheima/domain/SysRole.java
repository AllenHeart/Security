package com.itheima.domain;

import lombok.Data;

/**
 * 系统角色实体类
 */
@Data
public class SysRole {

    //角色 id
    private Integer id;

    //角色昵称
    private String roleName;

    //角色描述
    private String roleDesc;
}
