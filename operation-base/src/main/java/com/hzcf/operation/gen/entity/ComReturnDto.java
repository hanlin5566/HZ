package com.hzcf.operation.gen.entity;

import java.util.List;

/**
 * system_user 
 * @author qinfeng.zheng 2017-12-23
 */
public class ComReturnDto {

    private SystemRole systemRole;

    public List retuList;


    public SystemRole getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(SystemRole systemRole) {
        this.systemRole = systemRole;
    }

    public List getRetuList() {
        return retuList;
    }

    public void setRetuList(List retuList) {
        this.retuList = retuList;
    }
}