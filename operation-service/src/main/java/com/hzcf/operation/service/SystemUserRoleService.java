package com.hzcf.operation.service;


import com.hzcf.operation.gen.entity.SystemUserRole;

public interface SystemUserRoleService {

	  int addSystemUserRole(SystemUserRole systemUserRole);

	  int updateSysteUserRole(SystemUserRole systemUserRole);

	  SystemUserRole selectByPrimaryKey(int id);

}
