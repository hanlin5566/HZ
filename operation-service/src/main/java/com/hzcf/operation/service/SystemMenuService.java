package com.hzcf.operation.service;


import com.hzcf.operation.gen.entity.SystemMenu;
import com.hzcf.operation.gen.entity.SystemMenuExample;

import java.util.List;

public interface SystemMenuService {

	  int addSystemMenu(SystemMenu systemMenu);

	  int updateSysteMenu(SystemMenu systemMenu);

	  SystemMenu selectByPrimaryKey(int id);

	  List<SystemMenu> selectByExample(SystemMenuExample example);

}
