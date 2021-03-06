package com.hzcf.operation.gen.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.enums.RuleGroupStatus;
import com.hzcf.operation.base.serialize.EnumJsonSerializer;
import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * rule_group 规则组成员
 * @author huhanlin 2017-11-28
 */
public class RuleGroupList {
    /**
     * 
     */
    private Integer id;

    /**
     * 规则ID
     */
    private Integer ruleId;

    /**
     * 
     */
    private Integer groupId;

    /**
     * 变量状态(0:未知,1：已保存，2：通过编译，3：已发布）
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    private RuleGroupStatus state;

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
     * 规则ID
     * @return rule_id 规则ID
     */
    public Integer getRuleId() {
        return ruleId;
    }

    /**
     * 规则ID
     * @param ruleId 规则ID
     */
    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 
     * @return group_id 
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 
     * @param groupId 
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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