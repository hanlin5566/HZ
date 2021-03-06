package com.hzcf.operation.gen.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.enums.RuleGroupStatus;
import com.hzcf.operation.base.serialize.EnumJsonSerializer;
import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * rule_group_name 规则组
 * @author huhanlin 2017-11-28
 */
public class RuleGroup {
    /**
     * 
     */
    private Integer id;

    /**
     * 规则组英文名
     */
    private String groupKey;

    /**
     * 规则组名称
     */
    private String groupName;

    /**
     * 规则组描述
     */
    private String groupDescribe;

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
     * 数据状态（0.未知，1.正常，-1.删除）
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    private DataStatus dataStatus;

    /**
     * 变量状态(0:未知,1：已保存，2：通过编译，3：已发布）
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    private RuleGroupStatus state;

    /**
     * 执行顺序 降序执行
     */
    private Integer sort;

    /**
     * 测试用例
     */
    private String testDemo;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 规则组英文名
     * @return group_key 规则组英文名
     */
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * 规则组英文名
     * @param groupKey 规则组英文名
     */
    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey == null ? null : groupKey.trim();
    }

    /**
     * 规则组名称
     * @return group_name 规则组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 规则组名称
     * @param groupName 规则组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 规则组描述
     * @return group_describe 规则组描述
     */
    public String getGroupDescribe() {
        return groupDescribe;
    }

    /**
     * 规则组描述
     * @param groupDescribe 规则组描述
     */
    public void setGroupDescribe(String groupDescribe) {
        this.groupDescribe = groupDescribe == null ? null : groupDescribe.trim();
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
     * 变量状态(0:未知,1：已保存，2：通过编译，3：已发布）
     * @return state 变量状态(0:未知,1：已保存，2：通过编译，3：已发布）
     */
    public RuleGroupStatus getState() {
        return state;
    }

    /**
     * 变量状态(0:未知,1：已保存，2：通过编译，3：已发布）
     * @param state 变量状态(0:未知,1：已保存，2：通过编译，3：已发布）
     */
    public void setState(RuleGroupStatus state) {
        this.state = state;
    }

    /**
     * 执行顺序 降序执行
     * @return sort 执行顺序 降序执行
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 执行顺序 降序执行
     * @param sort 执行顺序 降序执行
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 测试用例
     * @return test_demo 测试用例
     */
    public String getTestDemo() {
        return testDemo;
    }

    /**
     * 测试用例
     * @param testDemo 测试用例
     */
    public void setTestDemo(String testDemo) {
        this.testDemo = testDemo == null ? null : testDemo.trim();
    }
}