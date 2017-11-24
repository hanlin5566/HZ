package com.hzcf.operation.gen.entity;

import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * system_role_menu 
 * @author qinfeng 2017-11-23
 */
public class SystemRoleMenu {
    /**
     * system_user_module 主键Id
     */
    private Integer id;

    /**
     * 主键Id
     */
    private Integer moduleId;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 创建人
     */
    private Integer createUid;

    /**
     * 修改人
     */
    private Integer udpateUid;

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

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     */
    private Integer dataStatus;

    /**
     * system_user_module 主键Id
     * @return id system_user_module 主键Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * system_user_module 主键Id
     * @param id system_user_module 主键Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 主键Id
     * @return module_id 主键Id
     */
    public Integer getModuleId() {
        return moduleId;
    }

    /**
     * 主键Id
     * @param moduleId 主键Id
     */
    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 角色id
     * @return role_id 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 创建人
     * @return create_uid 创建人
     */
    public Integer getCreateUid() {
        return createUid;
    }

    /**
     * 创建人
     * @param createUid 创建人
     */
    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    /**
     * 修改人
     * @return udpate_uid 修改人
     */
    public Integer getUdpateUid() {
        return udpateUid;
    }

    /**
     * 修改人
     * @param udpateUid 修改人
     */
    public void setUdpateUid(Integer udpateUid) {
        this.udpateUid = udpateUid;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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