package com.hzcf.operation.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzcf.operation.base.exception.CustomException;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.base.util.StringUtils;
import com.hzcf.operation.gen.entity.SystemMenu;
import com.hzcf.operation.gen.entity.SystemMenuExample;
import com.hzcf.operation.gen.entity.SystemRoleMenu;
import com.hzcf.operation.gen.entity.SystemRoleMenuExample;
import com.hzcf.operation.gen.entity.SystemUser;
import com.hzcf.operation.gen.entity.SystemUserExample;
import com.hzcf.operation.gen.entity.SystemUserRole;
import com.hzcf.operation.gen.entity.SystemUserRoleExample;
import com.hzcf.operation.interceptor.SessionInterceptor;
import com.hzcf.operation.service.SystemMenuService;
import com.hzcf.operation.service.SystemRoleMenuService;
import com.hzcf.operation.service.SystemUserRoleService;
import com.hzcf.operation.service.SystemUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * author qinfneg.zheng
 * time 2017年11月29日09:58:21
 * work login authTree
 */
@RestController
@RequestMapping(value="/platfrom")
@Api("登录")
public class LoginController {

    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private SystemUserRoleService systemUserRoleService;

    @Autowired
    private SystemRoleMenuService roleMenuService;

    @Autowired
    private SystemMenuService menuService;

    /***
     * work:用户登录
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="用户登录", notes="用户登录加载该用户存在的权限")
    @RequestMapping(value="/userlogin")
    public Result queryLogErrorList(HttpServletRequest request, @RequestBody  SystemUser systemUser) {
        Result ret = new Result();
        //参数验证
        if (systemUser.getUserName()==null||systemUser.getUserPwd()==null) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        SystemUserExample example = BeanUtils.example(systemUser, SystemUserExample.class);
        example.createCriteria().andDataStatusEqualTo(1);//数据状态可用
        SystemUser retunResult = new SystemUser();
        //密码没有处理 确认密码之后需要对密码做加密 匹配 TODO:list?
        List<SystemUser> list = systemUserService.getSystemUserByExample(example);
        if (list.size()!=1){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"用户名或密码不正确!");
        }
        try {
            retunResult = list.get(0);
            SessionInterceptor.createAuthToken(retunResult);
        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        /**
         * 获取用户权限
         */
        List<SystemMenu> menuList = new ArrayList<>();
      //获取登录用户对应的角色 可能对应多个角色
        SystemUserRoleExample sysExample = new SystemUserRoleExample();
        sysExample.createCriteria().andUserIdEqualTo(retunResult.getId()).andDataStatusEqualTo(1);
        List<SystemUserRole> userRoleList = systemUserRoleService.selectByExample(sysExample);

        if (userRoleList.size()<1){
            throw new CustomException(ResponseCode.ERROR_PARAM,"请联系系统管理员给您分配对应角色!");
        }

        List roleIdList = new ArrayList();
        for (SystemUserRole userRole : userRoleList) {
            roleIdList.add(userRole.getRoleId());
        }

        //获取角色对应的菜单ID
        SystemRoleMenuExample roleMenuExample = new SystemRoleMenuExample();
        roleMenuExample.createCriteria().andDataStatusEqualTo(1);
        roleMenuExample.createCriteria().andRoleIdIn(roleIdList);
        roleMenuExample.setDistinct(true);//去重 无法根据某一字段去重 因为后面用的是in 所有对于查询出来的结果并无影响
        List<SystemRoleMenu> roleMenuList = roleMenuService.selectByExample(roleMenuExample);

        if (roleMenuList.size()<1){
            throw new CustomException(ResponseCode.ERROR_PARAM,"请联系管理员为该角色开通对应菜单权限!");
        }

        List menuIdList  = new ArrayList();
        for (SystemRoleMenu roleMenu:roleMenuList){
            menuIdList.add(roleMenu.getModuleId());//菜单Id
        }
        //获取菜单名称
        SystemMenuExample menuExample = new SystemMenuExample();
        menuExample.createCriteria().andIdIn(menuIdList).andDataStatusEqualTo(1);
        menuList = menuService.selectByExample(menuExample);
        JSONObject retJson = (JSONObject) JSONObject.toJSON(retunResult);
        retJson.put("sysMenu", JSON.toJSON(menuIdList));
        return  ret.setData(retJson);
    }


    /***
     * work 得到用户的菜单权限
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="用户登录之后查询该用户的菜单权限", notes="根据user_id获取该用户对应角色的菜单权限")
    @RequestMapping(value="/usermenuauth")
    public Result getUserMenuAuth(HttpServletRequest request) {
        Result ret = new Result();
        int userId = StringUtils.strToInt(request.getParameter("userId"));
        List<SystemMenu> menuList = new ArrayList<>();
        //参数验证
        if (userId<1) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }

        try {
            //用户是否存在
            SystemUser systemUser =   systemUserService.selectByPrimarykey(userId);
            if (systemUser==null||systemUser.getDataStatus()!=1){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"该用户不存在!");
            }
            //获取登录用户对应的角色 可能对应多个角色
            SystemUserRoleExample example = new SystemUserRoleExample();
            example.createCriteria().andUserIdEqualTo(userId).andDataStatusEqualTo(1);
            List<SystemUserRole> userRoleList = systemUserRoleService.selectByExample(example);

            if (userRoleList.size()<1){
                throw new CustomException(ResponseCode.ERROR_PARAM,"请联系系统管理员给您分配对应角色!");
            }

            List roleIdList = new ArrayList();
            for (SystemUserRole userRole : userRoleList) {
                roleIdList.add(userRole.getRoleId());
            }

            //获取角色对应的菜单ID
            SystemRoleMenuExample roleMenuExample = new SystemRoleMenuExample();
            roleMenuExample.createCriteria().andDataStatusEqualTo(1);
            roleMenuExample.createCriteria().andRoleIdIn(roleIdList);
            roleMenuExample.setDistinct(true);//去重 无法根据某一字段去重 因为后面用的是in 所有对于查询出来的结果并无影响
            List<SystemRoleMenu> roleMenuList = roleMenuService.selectByExample(roleMenuExample);

            if (roleMenuList.size()<1){
                throw new CustomException(ResponseCode.ERROR_PARAM,"请联系管理员为该角色开通对应菜单权限!");
            }

            List menuIdList  = new ArrayList();
            for (SystemRoleMenu roleMenu:roleMenuList){
                menuIdList.add(roleMenu.getModuleId());//菜单Id
            }
            //获取菜单名称
            SystemMenuExample menuExample = new SystemMenuExample();
            menuExample.createCriteria().andIdIn(menuIdList);
                    //.andDataStatusEqualTo(1);
            menuList = menuService.selectByExample(menuExample);

        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        return  ret.setData(menuList);
    }
}
