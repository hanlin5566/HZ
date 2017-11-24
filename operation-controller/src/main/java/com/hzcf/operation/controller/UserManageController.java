package com.hzcf.operation.controller;


import com.hzcf.operation.base.exception.CustomException;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.util.StringUtils;
import com.hzcf.operation.gen.entity.SystemRole;
import com.hzcf.operation.gen.entity.SystemUser;
import com.hzcf.operation.inter.SystemRoleService;
import com.hzcf.operation.inter.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/***
 *  work:用户管理
 *  time:2017年11月23日11:49:09
 *  author:qinfeng.zheng
 */
@RestController
@RequestMapping(value="/manageUser")
@Api("用户管理")
public class UserManageController {
    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private SystemRoleService systemRoleService;


    /***
     * 添加用户
     * @param request
     * @param systemUser
     * @return
     */
    @ApiOperation(value="增加用户", notes="添加用户信息")
    @RequestMapping(value="/addUserInfo", method= RequestMethod.POST)
    public Result addUserInfo(HttpServletRequest request,SystemUser systemUser) {
        Result<Map> ret = new Result<Map>();

        if (!StringUtils.isNotNull(systemUser.getUserName())) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            Date date = new Date();
            systemUser.setCreateTime(date);
            int result= systemUserService.addSystemUserInfo(systemUser);
            if (result<1){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
            }
        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        return  ret.setData(map);

    }

    /***
     * 修改用户信息
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="修改用户", notes="修改用户信息")
    @RequestMapping(value="/updateUserInfo", method= RequestMethod.POST)
    public Result updateUserInfo(HttpServletRequest request,SystemUser param) {
        Result<Map> ret = new Result<Map>();

        //获取Id
        int userId = StringUtils.strToInt(request.getParameter("userId"));
        if (userId<1) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            Date date = new Date();
            //查询
            SystemUser systemUser = systemUserService.selectByPrimarykey(userId);
            if (systemUser==null){
                throw new CustomException(ResponseCode.ERROR_PARAM,"用户信息不存在!");
            }
            systemUser.setUpdateTime(date);
            if (StringUtils.isNotNull(param.getUserName())) {
                systemUser.setUserName(param.getUserName());
            }
            if (StringUtils.isNotNull(param.getUserPwd())){
                systemUser.setUserPwd(param.getUserPwd());
            }
            if (StringUtils.isNotNull(param.getUserPhone())){
                systemUser.setUserPhone(param.getUserPhone());
            }
            int result  = systemUserService.updateSystemUserInfo(systemUser);
            if (result<1){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
            }

        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        return  ret.setData(map);

    }


    /***
     * 增加角色
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="增加角色", notes="添加角色信息")
    @RequestMapping(value="/addRole", method= RequestMethod.POST)
    public Result addUserRole(HttpServletRequest request,SystemRole systemRole) {
        Result<Map> ret = new Result<Map>();
        String roleName = request.getParameter("roleName");//角色名称
        if (!StringUtils.isNotNull(roleName)) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            Date date = new Date();
            systemRole.setCreateTime(date);
           // SystemRole systemRole = new SystemRole();
            systemRole.setRoleName(roleName);
            int result = systemRoleService.addSystemRole(systemRole);
            if (result<1){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
            }
        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        return  ret.setData(map);

    }


    /***
     * 修改角色
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="修改角色", notes="修改角色信息")
    @RequestMapping(value="/updateRole", method= RequestMethod.POST)
    public Result updateRole(HttpServletRequest request,SystemRole param) {
        Result<Map> ret = new Result<Map>();
        int roleId = StringUtils.strToInt(request.getParameter("roleId"));//角色名称
        if (roleId<1) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            Date date = new Date();
            SystemRole systemRole = systemRoleService.selectByPrimaryKey(roleId);
            if (StringUtils.isNotNull(param.getRoleName())){
                systemRole.setRoleName(param.getRoleName());
            }
            int result = systemRoleService.updateSysteRole(systemRole);
            if (result<1){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
            }
        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        return  ret.setData(map);

    }



}