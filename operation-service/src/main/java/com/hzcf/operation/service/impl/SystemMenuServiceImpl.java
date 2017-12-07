package com.hzcf.operation.service.impl;

import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.gen.entity.SystemMenu;
import com.hzcf.operation.gen.entity.SystemMenuExample;
import com.hzcf.operation.gen.mapper.SystemMenuMapper;
import com.hzcf.operation.service.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * author:qinfeng.zheng
 * work:系统菜单
 * time:2017年11月24日09:49:29
 */
@Service(value = "systemMenuService")
public class SystemMenuServiceImpl implements SystemMenuService {

    @Autowired
    private SystemMenuMapper systemMenuMapper;


    @Override
    public  int addSystemMenu(SystemMenu systemMenu){
        return  systemMenuMapper.insert(systemMenu);
    }

    @Override
    public int updateSysteMenu(SystemMenu systemMenu){
        return  systemMenuMapper.updateByPrimaryKey(systemMenu);
    }

   @Override
   public   SystemMenu selectByPrimaryKey(int id){
       return  systemMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public  List<SystemMenu> selectByExample(SystemMenuExample example){
       return  systemMenuMapper.selectByExample(example);
    }


    @Override
    public  List<SystemMenu> selectByExamplePage(SystemMenuExample example,PageInfo pageInfo){
        return  systemMenuMapper.selectByExampleWithRowbounds(example,pageInfo);
    }

}
