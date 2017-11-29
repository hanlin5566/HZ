package com.hzcf.operation.service;


import com.hzcf.operation.gen.entity.SystemUserRole;
import com.hzcf.operation.gen.entity.SystemUserRoleExample;

import java.util.List;

public interface SystemUserRoleService {

	  int addSystemUserRole(SystemUserRole systemUserRole);

	  int updateSysteUserRole(SystemUserRole systemUserRole);

	  SystemUserRole selectByPrimaryKey(int id);

	  List<SystemUserRole> selectByExample(SystemUserRoleExample example);

}
