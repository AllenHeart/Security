package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.SysRole;
import com.itheima.domain.SysUser;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 用户业务实现层
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired //用户业务类
    private UserDao userDao;

    @Autowired//角色的业务类
    private RoleService roleService;

    @Autowired //加盐加密封装对象
    private BCryptPasswordEncoder passwordEncoder;

    //动态获取 用户的 username 随机盐加密
    @Override
    public void save(SysUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public List<SysUser> findAll() {
        return userDao.findAll();
    }

    @Override
    public Map<String, Object> toAddRolePage(Integer id) {
        List<SysRole> allRoles = roleService.findAll();
        List<Integer> myRoles = userDao.findRolesByUid(id);
        //map 结合
        Map<String, Object> map = new HashMap<>();
        map.put("allRoles", allRoles);
        map.put("myRoles", myRoles);
        //返回 map 值
        return map;
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] ids) {
        userDao.removeRoles(userId);
        for (Integer rid : ids) {
            userDao.addRoles(userId, rid);
        }
    }

    //根据用户封装的对象加载用户特定的数据

    /**
     * 定义的权限认证业务
     *
     * @param username 用户在浏览器输入的用户名
     * @return UserDetails 是 SpringSecurity自己的用户对象
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            //1: 根据用户做查询
            SysUser sysUser = userDao.findByName(username);
            if (sysUser == null) {
                return null;
            }
            List <SimpleGrantedAuthority> authorities = new ArrayList<>();

            //通过 list 集合 存储角色数据 动态赋予角色
            List<SysRole> roles = sysUser.getRoles();
            //遍历用户的角色数据
            for (SysRole role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }

            //定义 动态的 username password 封装对象
            UserDetails userDetails = new User(sysUser.getUsername(),sysUser.getPassword(),authorities);
            return userDetails;
        } catch (Exception e) {
            //异常日志打印
            e.printStackTrace();
            //认证失败!
            return null;
        }
    }
}











