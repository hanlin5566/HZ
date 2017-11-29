package com.hzcf.operation.service.impl;


import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.gen.entity.SystemRole;
import com.hzcf.operation.gen.entity.SystemRoleExample;
import com.hzcf.operation.gen.entity.SystemUser;
import com.hzcf.operation.gen.mapper.SystemRoleMapper;
import com.hzcf.operation.service.SystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * author:qinfneg.zheng
 * work:系统角色
 * time:2017年11月23日19:37:52
 */
@Service("systemRoleService")
public class SystemRoleServiceImpl implements SystemRoleService {

    @Autowired
    private SystemRoleMapper systemRoleMapper;

    @Override
    public  int addSystemRole(SystemRole systemRole){
        return  systemRoleMapper.insert(systemRole);
    }

    @Override
    public  int updateSysteRole(SystemRole systemRole){
        return  systemRoleMapper.updateByPrimaryKey(systemRole);
    }

    @Override
    public SystemRole selectByPrimaryKey(int id){
        return  systemRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemRole> selectByExample(SystemRoleExample example, PageInfo pageInfo){
        return  systemRoleMapper.selectByExampleWithRowbounds(example,pageInfo);
    }
}
