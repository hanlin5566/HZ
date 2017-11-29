package com.hzcf.operation.service.impl;

import com.hzcf.operation.gen.entity.SystemRoleMenu;
import com.hzcf.operation.gen.entity.SystemRoleMenuExample;
import com.hzcf.operation.gen.mapper.SystemRoleMenuMapper;
import com.hzcf.operation.service.SystemRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "systemRoleMenuService")
public class SystemRoleMenuServiceImpl implements SystemRoleMenuService{


    @Autowired
    private SystemRoleMenuMapper systemRoleMenuMapper;

    @Override
    public int addRoleMenu(SystemRoleMenu systemRoleMenu){
        return  systemRoleMenuMapper.insert(systemRoleMenu);
    }

    @Override
    public  int updateRoleMenu(SystemRoleMenu systemRoleMenu){
        return systemRoleMenuMapper.updateByPrimaryKey(systemRoleMenu);
    }

    @Override
    public SystemRoleMenu selectPrimaryKey(int id){
        return  systemRoleMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemRoleMenu> selectByExample(SystemRoleMenuExample example){
        return  systemRoleMenuMapper.selectByExample(example);
    }
}
