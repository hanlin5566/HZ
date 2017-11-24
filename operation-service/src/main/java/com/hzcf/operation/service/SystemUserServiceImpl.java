package com.hzcf.operation.service;

import com.hzcf.operation.gen.entity.SystemUser;
import com.hzcf.operation.gen.mapper.SystemUserMapper;
import com.hzcf.operation.inter.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/***
 * author:qinfeng.zheng
 * time:2017年11月23日12:03:16
 * work:系统用户管理
 */
@Service("systemUserService")
public class SystemUserServiceImpl implements SystemUserService{

    @Autowired
    private SystemUserMapper systemUserMapper;

   @Override
   public int addSystemUserInfo(SystemUser systemUser){
       return systemUserMapper.insert(systemUser);
   }

   @Override
    public  int updateSystemUserInfo(SystemUser systemUser){
       return  systemUserMapper.updateByPrimaryKey(systemUser);
    }

    @Override
    public SystemUser selectByPrimarykey(int id){
        return  systemUserMapper.selectByPrimaryKey(id);
    }

}
