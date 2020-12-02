package com.itheima.dao;

import com.itheima.domain.SysUser;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * 用户的持久层与数据库映射 接口
 */
public interface UserDao {

    //查询
    @Select("select * from sys_user where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.itheima.dao.RoleDao.findByUid"))
    })

    //根据用户名称查询的方法
    public SysUser findByName(String username);

    //添加用户的信息
    @Insert("insert into sys_user (username, password) values (#{username}, #{password})")
    public void save(SysUser user);

    //查询用户信息
    @Select("select * from sys_user")
    public List<SysUser> findAll();

    //查询角色信息
    @Select("SELECT r.id FROM sys_role r, sys_user_role ur " +
            "WHERE ur.rid=r.id AND ur.uid=#{uid}")
    public List<Integer> findRolesByUid(Integer id);

    //删除角色信息
    @Delete("delete from sys_user_role where uid=#{userId}")
    public void removeRoles(Integer userId);

    //添加角色信息
    @Insert("insert into sys_user_role values (#{uid}, #{rid})")
    public void addRoles(@Param("uid") Integer userId, @Param("rid") Integer rid);
}











