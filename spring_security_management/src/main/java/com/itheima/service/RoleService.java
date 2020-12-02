package com.itheima.service;

import com.itheima.domain.SysRole;
import java.util.List;

/**
 * 角色业务层
 */
public interface RoleService {

    public void save(SysRole role);

    public List<SysRole> findAll();

}
