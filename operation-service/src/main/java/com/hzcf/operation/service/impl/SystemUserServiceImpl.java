package com.hzcf.operation.service.impl;

import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.gen.entity.SystemUser;
import com.hzcf.operation.gen.entity.SystemUserExample;
import com.hzcf.operation.gen.mapper.SystemUserMapper;
import com.hzcf.operation.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/***
 * author:qinfeng.zheng
 * time:2017年11月23日12:03:16
 * work:系统用户管理
 */
@Service("systemUserService")
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

   @Override
   public int addSystemUserInfo(SystemUser systemUser){
        systemUserMapper.insert(systemUser);
       return systemUser.getId();
   }

   @Override
    public  int updateSystemUserInfo(SystemUser systemUser){
       return  systemUserMapper.updateByPrimaryKey(systemUser);
    }

    @Override
    public SystemUser selectByPrimarykey(int id){
        return  systemUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemUser> getSystemUserByCondition(SystemUserExample examp, PageInfo pageInfo){
        return  systemUserMapper.selectByExampleWithRowbounds(examp,pageInfo);
    }

    @Override
    public List<SystemUser> getSystemUserByExample(SystemUserExample example){
        return  systemUserMapper.selectByExample(example);
    }

   /* @Override
    public  int insertReturnGenId(SystemUser systemUser){
        return  systemUserMapper.insertSelective(systemUser);
    }*/
}
