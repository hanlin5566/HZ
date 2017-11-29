package com.hzcf.operation.service.impl;

import com.hzcf.operation.gen.entity.SystemUserRole;
import com.hzcf.operation.gen.entity.SystemUserRoleExample;
import com.hzcf.operation.gen.mapper.SystemUserRoleMapper;
import com.hzcf.operation.service.SystemUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * work:用户和角色的关联关系表
 * author:qinfeng.zheng
 * time:2017年11月24日10:04:08
 */
@Service(value = "systemUserRoleService")
public class SystemUserRoleServiceImpl implements SystemUserRoleService {

    @Autowired
    private SystemUserRoleMapper systemUserRoleMapper;

    @Override
    public  int addSystemUserRole(SystemUserRole systemUserRole){
        return systemUserRoleMapper.insert(systemUserRole);
    }
    @Override
    public  int updateSysteUserRole(SystemUserRole systemUserRole){
        return systemUserRoleMapper.updateByPrimaryKey(systemUserRole);
    }

    @Override
    public SystemUserRole selectByPrimaryKey(int id){
        return systemUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemUserRole> selectByExample(SystemUserRoleExample example){
        return  systemUserRoleMapper.selectByExample(example);
    }
}
