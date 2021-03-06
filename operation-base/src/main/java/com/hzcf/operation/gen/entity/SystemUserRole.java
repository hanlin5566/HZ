package com.hzcf.operation.gen.entity;

import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * system_user_role 
 * @author huhanlin 2017-11-23
 */
public class SystemUserRole {
    /**
     * system_user_role
     */
    private Integer id;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 角色Id
     */
    private Integer roleId;

    /**
     * 创建人Id
     */
    private Integer createUid;

    /**
     * 修改人Id
     */
    private Integer updateUid;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date createTime;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     */
    private Integer dataStatus;

    /**
     * system_user_role
     * @return id system_user_role
     */
    public Integer getId() {
        return id;
    }

    /**
     * system_user_role
     * @param id system_user_role
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户Id
     * @return user_id 用户Id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户Id
     * @param userId 用户Id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 角色Id
     * @return role_id 角色Id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 角色Id
     * @param roleId 角色Id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 创建人Id
     * @return create_uid 创建人Id
     */
    public Integer getCreateUid() {
        return createUid;
    }

    /**
     * 创建人Id
     * @param createUid 创建人Id
     */
    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    /**
     * 修改人Id
     * @return update_uid 修改人Id
     */
    public Integer getUpdateUid() {
        return updateUid;
    }

    /**
     * 修改人Id
     * @param updateUid 修改人Id
     */
    public void setUpdateUid(Integer updateUid) {
        this.updateUid = updateUid;
    }



    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     * @return data_status 数据状态（0.未知，1.正常，-1.删除）
     */
    public Integer getDataStatus() {
        return dataStatus;
    }

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     * @param dataStatus 数据状态（0.未知，1.正常，-1.删除）
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }
}