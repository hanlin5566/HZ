package com.hzcf.operation.controller;


import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.exception.CustomException;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.base.util.StringUtils;
import com.hzcf.operation.gen.entity.SystemRole;
import com.hzcf.operation.gen.entity.SystemRoleExample;
import com.hzcf.operation.gen.entity.SystemUser;
import com.hzcf.operation.gen.entity.SystemUserExample;
import com.hzcf.operation.service.SystemRoleService;
import com.hzcf.operation.service.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
     * 用户信息
     * @param request
     * @param systemUser
     * @return
     */
    @ApiOperation(value="用户信息", notes="查询用户信息Bycondition")
    @RequestMapping(value="/queryUserInfo")
    public ResultPage queryUserInfo(HttpServletRequest request, SystemUser systemUser, PageEntity page) {
        ResultPage ret = new ResultPage();
        List<SystemUser> list = new ArrayList<>();
        PageInfo pageInfo = page.toPageInfo();
        try {
          /*  System.out.println(systemUser.getUserName());
            SystemUserExample example = new SystemUserExample();
            example.createCriteria().andDataStatusEqualTo(1);//正常数据
            if (systemUser.getUserName()!=null) {
                example.createCriteria().andUserNameLike(systemUser.getUserName());
            }if (systemUser.getUserPhone()!=null){
                example.createCriteria().andUserPhoneEqualTo(systemUser.getUserPhone());
            }if (systemUser.getCreateTime()!=null){
                example.createCriteria().andCreateTimeEqualTo(systemUser.getCreateTime());
            }*/
            SystemUserExample example = BeanUtils.example(systemUser,SystemUserExample.class);
            list = systemUserService.getSystemUserByCondition(example,pageInfo);

        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        ret.setPageInfo(pageInfo);
        ret.setData(list);
        return  ret;

    }


    /***
     * 添加用户
     * @param request
     * @param systemUser
     * @return
     */
    @ApiOperation(value="增加用户", notes="添加用户信息")
    @RequestMapping(value="/addUserInfo")
    public Result addUserInfo(HttpServletRequest request,@RequestBody SystemUser systemUser) {
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
     * 查看用户信息
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="查看用户信息", notes="查看用户信息")
    @RequestMapping(value="/{useId}")
    public Result detailUserInfo(HttpServletRequest request, @PathVariable String useId) {
        Result ret = new Result();
        int userId = StringUtils.strToInt(useId);//用户Id
        if (userId<1) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
       // Map<String, Object> map = new HashMap<String, Object>();
        SystemUser systemUser = new SystemUser();
        try {
             systemUser = systemUserService.selectByPrimarykey(userId);
            if (systemUser==null){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
            }
           // map.put("data",systemUser);
        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        return  ret.setData(systemUser);

    }
    /***
     * 修改用户信息
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="修改用户", notes="修改用户信息")
    @RequestMapping(value="/updateUserInfo")
    public Result updateUserInfo(HttpServletRequest request, @RequestBody SystemUser param) {
        Result<Map> ret = new Result<Map>();

        //获取Id
        int userId = param.getId();
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

    /***
     * 角色信息
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="角色信息", notes="查询角色信息Bycondition")
    @RequestMapping(value="/queryRoleInfo")
    public ResultPage queryRoleInfo(HttpServletRequest request, SystemRole systemRole, PageEntity page) {
        ResultPage ret = new ResultPage();
        List<SystemRole> list = new ArrayList<>();
        PageInfo pageInfo = page.toPageInfo();
        try {
            SystemRoleExample example = BeanUtils.example(systemRole, SystemRoleExample.class);
            list = systemRoleService.selectByExample(example,pageInfo);

        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        ret.setPageInfo(pageInfo);
        ret.setData(list);
        return  ret;

    }

}
