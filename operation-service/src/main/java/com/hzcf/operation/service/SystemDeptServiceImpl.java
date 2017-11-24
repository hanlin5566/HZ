package com.hzcf.operation.service;


import com.hzcf.operation.gen.entity.SystemDept;
import com.hzcf.operation.gen.mapper.SystemDeptMapper;
import com.hzcf.operation.inter.SystemDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * author:qinfeng.zheng
 * time:2017年11月24日10:16:11
 * work:系统部门
 */

@Service(value="systemDeptService")
public class SystemDeptServiceImpl implements SystemDeptService {

    @Autowired
    private SystemDeptMapper systemDeptMapper;

    public int addSystemDept(SystemDept systemDept){
        return  systemDeptMapper.insert(systemDept);
    }

    public int updateSystemDept(SystemDept systemDept){
        return systemDeptMapper.updateByPrimaryKey(systemDept);
    }

    public SystemDept selectByPrimarykey(int id){
        return systemDeptMapper.selectByPrimaryKey(id);
    }

}
