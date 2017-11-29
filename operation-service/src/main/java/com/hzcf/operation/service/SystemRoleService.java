package com.hzcf.operation.service;


import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.gen.entity.SystemRole;
import com.hzcf.operation.gen.entity.SystemRoleExample;

import java.util.List;

public interface SystemRoleService {

	  int addSystemRole(SystemRole systemRole);

	  int updateSysteRole(SystemRole systemRole);

	  SystemRole selectByPrimaryKey(int id);

	  List<SystemRole> selectByExample(SystemRoleExample example, PageInfo pageInfo);

}
