package com.hzcf.operation.service;


import com.hzcf.operation.gen.entity.SystemDept;

public interface SystemDeptService {

	  int addSystemDept(SystemDept systemDept);

	  int updateSystemDept(SystemDept systemDept);

	  SystemDept selectByPrimarykey(int id);
}
