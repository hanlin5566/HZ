package com.hzcf.operation.gen.entity;

import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * system_user 
 * @author qinfeng.zheng 2017-12-23
 */
public class SystemUserDto extends  SystemUser{

    /***
     * 用户所属角色ID
     */
    private String userRoleId;

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }
}