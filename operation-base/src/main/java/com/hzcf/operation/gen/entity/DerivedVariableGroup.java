package com.hzcf.operation.gen.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.serialize.EnumJsonSerializer;
import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * derived_var_group 变量分组
 * @author huhanlin 2017-11-24
 */
public class DerivedVariableGroup {
    /**
     * 衍生变量组ID
     */
    private Integer varGroupId;

    /**
     * 衍生变量组名称
     */
    private String groupName;

    /**
     * 衍生变量组描述
     */
    private String description;

    /**
     * 取数接口名称,与规则引擎传入的service一致。
     */
    private String queryIface;

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    private DataStatus dataStatus;

    /**
     * 创建用户
     */
    private Integer createUid;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date createTime;

    /**
     * 修改人
     */
    private Integer updateUid;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date updateTime;

    /**
     * 衍生变量组ID
     * @return var_group_id 衍生变量组ID
     */
    public Integer getVarGroupId() {
        return varGroupId;
    }

    /**
     * 衍生变量组ID
     * @param varGroupId 衍生变量组ID
     */
    public void setVarGroupId(Integer varGroupId) {
        this.varGroupId = varGroupId;
    }

    /**
     * 衍生变量组名称
     * @return group_name 衍生变量组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 衍生变量组名称
     * @param groupName 衍生变量组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 衍生变量组描述
     * @return description 衍生变量组描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 衍生变量组描述
     * @param description 衍生变量组描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 取数接口名称,与规则引擎传入的service一致。
     * @return query_iface 取数接口名称,与规则引擎传入的service一致。
     */
    public String getQueryIface() {
        return queryIface;
    }

    /**
     * 取数接口名称,与规则引擎传入的service一致。
     * @param queryIface 取数接口名称,与规则引擎传入的service一致。
     */
    public void setQueryIface(String queryIface) {
        this.queryIface = queryIface == null ? null : queryIface.trim();
    }

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     * @return data_status 数据状态（0.未知，1.正常，-1.删除）
     */
    public DataStatus getDataStatus() {
        return dataStatus;
    }

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     * @param dataStatus 数据状态（0.未知，1.正常，-1.删除）
     */
    public void setDataStatus(DataStatus dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * 创建用户
     * @return create_uid 创建用户
     */
    public Integer getCreateUid() {
        return createUid;
    }

    /**
     * 创建用户
     * @param createUid 创建用户
     */
    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
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
     * 修改人
     * @return update_uid 修改人
     */
    public Integer getUpdateUid() {
        return updateUid;
    }

    /**
     * 修改人
     * @param updateUid 修改人
     */
    public void setUpdateUid(Integer updateUid) {
        this.updateUid = updateUid;
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
}