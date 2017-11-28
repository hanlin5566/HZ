package com.hzcf.operation.service;


import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.gen.entity.SystemUser;
import com.hzcf.operation.gen.entity.SystemUserExample;

import java.util.List;

public interface SystemUserService {

	  int addSystemUserInfo(SystemUser systemUser);

	  int updateSystemUserInfo(SystemUser systemUser);

	  SystemUser selectByPrimarykey(int id);

	  List<SystemUser> getSystemUserByCondition(SystemUserExample examp, PageInfo pageInfo);
}
