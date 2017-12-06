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
import com.hzcf.operation.gen.mapper.SystemUserMapper;
import com.hzcf.operation.service.SystemRoleMenuService;
import com.hzcf.operation.service.SystemRoleService;
import com.hzcf.operation.service.SystemUserRoleService;
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

    @Autowired
    private SystemUserRoleService systemUserRoleService;


    @Autowired
    private SystemRoleMenuService roleMenuService;




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
     * @param
     * @return
     */
    @ApiOperation(value="增加用户", notes="添加用户信息")
    @RequestMapping(value="/addUserInfo")
    public Result addUserInfo(HttpServletRequest request,@RequestBody SystemUserDto systemUserDto) {
        Result<Map> ret = new Result<Map>();
       // System.out.println("添加用户所属的角色:"+systemUserDto.getUserRoleId());
        int  roleId = StringUtils.strToInt(systemUserDto.getUserRoleId());
        if (!StringUtils.isNotNull(systemUserDto.getUserName())||roleId<1) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            Date date = new Date();
            systemUserDto.setCreateTime(date);
            systemUserDto.setDataStatus(1);
            //添加用户 获取返回的主键Id
            int result= systemUserService.addSystemUserInfo(systemUserDto);

            System.out.println("返回的主键用户表ID:"+systemUserDto.getId());
            if (systemUserDto.getId()<1){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
            }
            //添加用户所属角色
            SystemUserRole systemUserRole = new SystemUserRole();
            systemUserRole.setUserId(result);
            systemUserRole.setRoleId(roleId);
            systemUserRole.setCreateTime(date);
            systemUserRole.setDataStatus(1);
            int resultReturn = systemUserRoleService.addSystemUserRole(systemUserRole);
            if (resultReturn<1){
                throw new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
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
        SystemUser systemUser = new SystemUser();
        SystemUserDto userDto = new SystemUserDto();
        try {
             systemUser = systemUserService.selectByPrimarykey(userId);
            if (systemUser==null){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
            }
            //获取用户所属角色
            SystemUserRoleExample example = new SystemUserRoleExample();
            example.createCriteria().andUserIdEqualTo(userId);
            List<SystemUserRole> list = systemUserRoleService.selectByExample(example);
            if (list.size()!=1){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"数据异常!");
            }

            userDto.setUserRoleId(Integer.toString(list.get(0).getRoleId()));
            userDto.setUpdateTime(systemUser.getUpdateTime());
            userDto.setUserName(systemUser.getUserName());
            userDto.setUserPhone(systemUser.getUserPhone());
            userDto.setUserEmail(systemUser.getUserEmail());
            userDto.setCreateTime(systemUser.getCreateTime());
            userDto.setApiPwd(systemUser.getApiPwd());
            userDto.setUserPwd(systemUser.getUserPwd());

        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        return  ret.setData(userDto);

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
    @RequestMapping(value="/addRole")
    public Result addUserRole(HttpServletRequest request,@RequestBody RoleDto systemRole) {
        Result<Map> ret = new Result<Map>();
        //String roleName = request.getParameter("roleName");//角色名称
        if (!StringUtils.isNotNull(systemRole.getRoleName())||!StringUtils.isNotNull(systemRole.getAuthMenu())) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        String[] a   = systemRole.getAuthMenu().split("-");

        try {
            //添加角色
            Date date = new Date();
            systemRole.setCreateTime(date);
            systemRole.setDataStatus(1);
            int result = systemRoleService.addSystemRole(systemRole);
            if (result<1){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
            }
            //添加角色对应的菜单权限
            SystemRoleMenu roleMenu = new SystemRoleMenu();
            for (int l=0;l<a.length;l++){
                roleMenu.setRoleId(result);
                roleMenu.setModuleId(StringUtils.strToInt(a[l]));
                roleMenu.setCreateTime(date);
                roleMenu.setDataStatus(1);
                int r = roleMenuService.addRoleMenu(roleMenu);
                if (r<1){
                    throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
                }

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
    @RequestMapping(value="/updateRole")
    public Result updateRole(HttpServletRequest request,@RequestBody RoleDto param) {
        Result<Map> ret = new Result<Map>();
       //必传参数验证
        int roleId = param.getId();
        if (roleId<1||!StringUtils.isNotNull(param.getAuthMenu())) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        String[] a   = param.getAuthMenu().split("-");

        try {
            Date date = new Date();
            SystemRole systemRole = systemRoleService.selectByPrimaryKey(roleId);
            if (StringUtils.isNotNull(param.getRoleName())){
                systemRole.setRoleName(param.getRoleName());
            }
            if (StringUtils.isNotNull(param.getComments())){
                systemRole.setComments(param.getComments());
            }
            systemRole.setUpdateTime(date);
            int result = systemRoleService.updateSysteRole(systemRole);
            if (result<1){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
            }
            //修改角色对应的权限 即删除
            SystemRoleMenuExample example = new SystemRoleMenuExample();
            example.createCriteria().andRoleIdEqualTo(roleId).andDataStatusEqualTo(1);//角色Id
            List<SystemRoleMenu> list = roleMenuService.selectByExample(example);
            //修改用户权限 删除原来权限
            if (list.size()>0){
                for (SystemRoleMenu roleMenu:list){
                    roleMenu.setDataStatus(-1);//已删除状态
                    int retu = roleMenuService.updateRoleMenu(roleMenu);
                    if (retu<1){
                        throw new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
                    }
                }
            }
            //角色重新赋新的权限
            SystemRoleMenu roleMenu = new SystemRoleMenu();
            for (int l=0;l<a.length;l++){
                roleMenu.setRoleId(result);
                roleMenu.setModuleId(StringUtils.strToInt(a[l]));
                roleMenu.setCreateTime(date);
                roleMenu.setDataStatus(1);
                int r = roleMenuService.addRoleMenu(roleMenu);
                if (r<1){
                    throw  new CustomException(ResponseCode.ERROR_PARAM,"数据库操作异常!");
                }

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
    /***
     * 查看角色信息
     * @param request
     * @param
     * @return
     */
    @ApiOperation(value="查看角色信息", notes="查看角色信息")
    //@RequestMapping(value="/role/{roleId}") @RequestMapping(value="/role/{roleId}")
    @RequestMapping(value="/role/{roleId}",method = RequestMethod.GET)
    public Result detailRoleInfo(HttpServletRequest request,@PathVariable String roleId) {
        Result ret = new Result();
        int rolId = StringUtils.strToInt(roleId);//用户Id
        if (rolId<1) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }

        ComReturnDto returnDto = new ComReturnDto();
        try {
            //查看角色信息
            SystemRole systemRole  = systemRoleService.selectByPrimaryKey(rolId);
            if (systemRole==null){
                throw  new CustomException(ResponseCode.ERROR_PARAM,"该角色信息不存在!");
            }
            //获取角色对应的菜单权限(未删除)
            SystemRoleMenuExample example = new SystemRoleMenuExample();
            example.createCriteria().andRoleIdEqualTo(rolId).andDataStatusEqualTo(1);//角色Id
            List<SystemRoleMenu> list = roleMenuService.selectByExample(example);
            returnDto.setSystemRole(systemRole);
            returnDto.setRetuList(list);

        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        return  ret.setData(returnDto);

    }
}
