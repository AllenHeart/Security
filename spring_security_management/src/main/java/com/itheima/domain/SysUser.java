package com.itheima.domain;

import lombok.Data;
import java.util.List;

/**
 * 系统用户实体类
 */
@Data
public class SysUser {

    //用户号id
    private Integer id;

    //用户的昵称
    private String username;

    //用户的密码
    private String password;

    //用户的状态
    private Integer status;

    //角色对象
    private List<SysRole> roles;
}
