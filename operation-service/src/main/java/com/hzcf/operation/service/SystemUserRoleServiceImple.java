package com.hzcf.operation.service;

import com.hzcf.operation.gen.entity.SystemUserRole;
import com.hzcf.operation.gen.mapper.SystemUserRoleMapper;
import com.hzcf.operation.inter.SystemUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * work:用户和角色的关联关系表
 * author:qinfeng.zheng
 * time:2017年11月24日10:04:08
 */
@Service(value = "systemUserRoleService")
public class SystemUserRoleServiceImple implements SystemUserRoleService{

    @Autowired
    private SystemUserRoleMapper systemUserRoleMapper;

    public  int addSystemUserRole(SystemUserRole systemUserRole){
        return systemUserRoleMapper.insert(systemUserRole);
    }

    public  int updateSysteUserRole(SystemUserRole systemUserRole){
        return systemUserRoleMapper.updateByPrimaryKey(systemUserRole);
    }

    public SystemUserRole selectByPrimaryKey(int id){
        return systemUserRoleMapper.selectByPrimaryKey(id);
    }
}
