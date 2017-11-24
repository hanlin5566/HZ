package com.hzcf.operation.service;


import com.hzcf.operation.gen.entity.SystemUser;

public interface SystemUserService {

	  int addSystemUserInfo(SystemUser systemUser);

	  int updateSystemUserInfo(SystemUser systemUser);

	  SystemUser selectByPrimarykey(int id);
}
