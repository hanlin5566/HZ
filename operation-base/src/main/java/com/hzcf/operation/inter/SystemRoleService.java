package com.hzcf.operation.inter;


import com.hzcf.operation.gen.entity.SystemRole;

public interface SystemRoleService {

	  int addSystemRole(SystemRole systemRole);

	  int updateSysteRole(SystemRole systemRole);

	  SystemRole selectByPrimaryKey(int id);

}
