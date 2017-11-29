package com.hzcf.operation.service;

import com.hzcf.operation.gen.entity.SystemRoleMenu;
import com.hzcf.operation.gen.entity.SystemRoleMenuExample;

import java.util.List;

public interface SystemRoleMenuService {

	int addRoleMenu(SystemRoleMenu systemRoleMenu);

	int updateRoleMenu(SystemRoleMenu systemRoleMenu);

	SystemRoleMenu selectPrimaryKey(int id);

	List<SystemRoleMenu> selectByExample(SystemRoleMenuExample example);


}
