package com.hzcf.operation.inter;


import com.hzcf.operation.gen.entity.SystemUserRole;

public interface SystemUserRoleService {

	  int addSystemUserRole(SystemUserRole systemUserRole);

	  int updateSysteUserRole(SystemUserRole systemUserRole);

	  SystemUserRole selectByPrimaryKey(int id);

}
