package com.hzcf.operation.inter;


import com.hzcf.operation.gen.entity.SystemMenu;

public interface SystemMenuService {

	  int addSystemMenu(SystemMenu systemMenu);

	  int updateSysteMenu(SystemMenu systemMenu);

	  SystemMenu selectByPrimaryKey(int id);

}
