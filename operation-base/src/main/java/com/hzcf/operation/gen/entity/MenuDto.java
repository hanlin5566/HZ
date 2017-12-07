package com.hzcf.operation.gen.entity;

import java.util.List;

/**
 * system_user 
 * @author qinfeng.zheng 2017-12-23
 */
public class MenuDto {

    private SystemMenu parentMenu;

    private List<SystemMenu> subMenuList;

    public SystemMenu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(SystemMenu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public List<SystemMenu> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<SystemMenu> subMenuList) {
        this.subMenuList = subMenuList;
    }
}