package com.hzcf.operation.controller;


import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.exception.CustomException;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.base.util.StringUtils;
import com.hzcf.operation.gen.entity.*;
import com.hzcf.operation.service.SystemMenuService;
import com.hzcf.operation.service.SystemRoleMenuService;
import com.hzcf.operation.service.SystemUserRoleService;
import com.hzcf.operation.service.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author qinfneg.zheng
 * time 2017年11月29日09:58:21
 * work Menu authTree
 */
@RestController
@RequestMapping(value="/system")
@Api("系统管理")
public class SystemController {

    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private SystemUserRoleService systemUserRoleService;

    @Autowired
    private SystemRoleMenuService roleMenuService;

    @Autowired
    private SystemMenuService menuService;

    /***
     * work:菜单列表
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="菜单列表", notes="系统菜单")
    @RequestMapping(value="/menuList")
    public ResultPage queryRoleInfo(HttpServletRequest request, SystemMenu systemMenu, PageEntity page) {
        ResultPage ret = new ResultPage();
        List<SystemMenu> list = new ArrayList<>();
        PageInfo pageInfo = page.toPageInfo();
        try {
            SystemMenuExample example = BeanUtils.example(systemMenu, SystemMenuExample.class);
            list = menuService.selectByExamplePage(example,pageInfo);

        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
         ret.setPageInfo(pageInfo);
        ret.setData(list);
        return  ret;

    }


    /***
     * work:添加一级菜单
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="菜单添加", notes="添加菜单")
    @RequestMapping(value="/MenuInfo")
    public Result addSysMenu(HttpServletRequest request, @RequestBody SystemMenu systemMenu) {
        Result ret = new Result();

        if (!StringUtils.isNotNull(systemMenu.getModuleTitle())||!StringUtils.isNotNull(systemMenu.getModuleHref())){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"必要参数传输不完整或有误!");
        }
        try {
            Date date = new Date();
            systemMenu.setCreateTime(date);
            systemMenu.setDataStatus(1);
           int result =  menuService.addSystemMenu(systemMenu);
           if (result<1){
               throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
           }

        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }

        return  ret;

    }


    /***
     * work:获取父菜单
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="父菜单", notes="获取所有有二级菜单")
    @RequestMapping(value="/parentmenuInfo")
    public Result parentMenuInfo(HttpServletRequest request) {
        Result ret = new Result();
        List<SystemMenu> list = new ArrayList<>();
        try {
            SystemMenuExample example = new SystemMenuExample();
            example.createCriteria().andDataStatusEqualTo(1).andParentIdIsNull();
            list = menuService.selectByExample(example);

        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        ret.setData(list);
        return  ret;

    }


    /***
     * work:获取所有菜单树
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="菜单树", notes="显示所有菜单树")
    @RequestMapping(value="/menutree")
    public Result menuTree(HttpServletRequest request) {
        Result ret = new Result();
        List<MenuDto> returnList = new ArrayList<>();

        try {
            //获取所有父菜单
            SystemMenuExample example = new SystemMenuExample();
            example.createCriteria().andDataStatusEqualTo(1).andParentIdIsNull();
            List<SystemMenu> list = menuService.selectByExample(example);

            //获取子菜单
            if (list.size()>0){
                for (SystemMenu systemMenu:list){
                    SystemMenuExample ex2 = new SystemMenuExample();
                    ex2.createCriteria().andDataStatusEqualTo(1).andParentIdEqualTo(systemMenu.getId());
                    List<SystemMenu> twoMenuList = new ArrayList<>();
                    twoMenuList  =  menuService.selectByExample(ex2);
                    MenuDto menuDto = new MenuDto();
                    menuDto.setParentMenu(systemMenu);
                    menuDto.setSubMenuList(twoMenuList);
                    returnList.add(menuDto);
                }
            }

        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        ret.setData(returnList);
        return  ret;

    }
}
