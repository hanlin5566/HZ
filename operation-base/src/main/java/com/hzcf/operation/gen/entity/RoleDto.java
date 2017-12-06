package com.hzcf.operation.gen.entity;

import java.util.List;

/**
 * system_user 
 * @author qinfeng.zheng 2017-12-23
 */
public class RoleDto extends  SystemRole{

    private  String authMenu;


    public String getAuthMenu() {
        return authMenu;
    }

    public void setAuthMenu(String authMenu) {
        this.authMenu = authMenu;
    }
}