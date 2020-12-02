package com.itheima.dao;

import com.itheima.domain.SysRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 角色持久层与数据库映射 接口
 */
public interface RoleDao {

    //查询角色的信息
    @Select("SELECT r.id, r.role_name roleName, r.role_desc roleDesc " +
            "FROM sys_role r, sys_user_role ur " +
            "WHERE r.id=ur.rid AND ur.uid=#{uid}")

    //通过角色id查询的方法
    public List<SysRole> findByUid(Integer uid);

    //添加用户角色的信息
    @Insert("insert into sys_role (role_name, role_desc) values (#{roleName}, #{roleDesc})")
    public void save(SysRole role);

    //查询角色的信息
    @Select("select id, role_name roleName, role_desc roleDesc from sys_role")
    public List<SysRole> findAll();
}
