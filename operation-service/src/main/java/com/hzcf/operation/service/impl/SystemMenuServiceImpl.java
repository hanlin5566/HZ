package com.hzcf.operation.service.impl;

import com.hzcf.operation.gen.entity.SystemMenu;
import com.hzcf.operation.gen.mapper.SystemMenuMapper;
import com.hzcf.operation.service.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * author:qinfeng.zheng
 * work:系统菜单
 * time:2017年11月24日09:49:29
 */
@Service(value = "systemMenuService")
public class SystemMenuServiceImpl implements SystemMenuService {

    @Autowired
    private SystemMenuMapper systemMenuMapper;


    public  int addSystemMenu(SystemMenu systemMenu){
        return  systemMenuMapper.insert(systemMenu);
    }

   public int updateSysteMenu(SystemMenu systemMenu){
        return  systemMenuMapper.updateByPrimaryKey(systemMenu);
   }

  public   SystemMenu selectByPrimaryKey(int id){
       return  systemMenuMapper.selectByPrimaryKey(id);
    }
}
