package com.hzcf.operation.gen.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.serialize.EnumJsonSerializer;
import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * rule 规则库
 * @author huhanlin 2017-11-25
 */
public class Rules {
    /**
     * 
     */
    private Integer id;

    /**
     * 规则变量
     */
    private String ruleId;

    /**
     * 规则中文名称
     */
    private String ruleName;

    /**
     * 规则描述
     */
    private String ruleDescribe;

    /**
     * 规则类型（1=仅拒绝或2=拒绝加黑）
     */
    private Byte type;

    /**
     * 规则评分
     */
    private Integer score;

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
     * 规则代码
     */
    private byte[] ruleCode;

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
     * 规则变量
     * @return rule_id 规则变量
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * 规则变量
     * @param ruleId 规则变量
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * 规则中文名称
     * @return rule_name 规则中文名称
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * 规则中文名称
     * @param ruleName 规则中文名称
     */
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    /**
     * 规则描述
     * @return rule_describe 规则描述
     */
    public String getRuleDescribe() {
        return ruleDescribe;
    }

    /**
     * 规则描述
     * @param ruleDescribe 规则描述
     */
    public void setRuleDescribe(String ruleDescribe) {
        this.ruleDescribe = ruleDescribe == null ? null : ruleDescribe.trim();
    }

    /**
     * 规则类型（1=仅拒绝或2=拒绝加黑）
     * @return type 规则类型（1=仅拒绝或2=拒绝加黑）
     */
    public Byte getType() {
        return type;
    }

    /**
     * 规则类型（1=仅拒绝或2=拒绝加黑）
     * @param type 规则类型（1=仅拒绝或2=拒绝加黑）
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 规则评分
     * @return score 规则评分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 规则评分
     * @param score 规则评分
     */
    public void setScore(Integer score) {
        this.score = score;
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
     * 规则代码
     * @return rule_code 规则代码
     */
    public byte[] getRuleCode() {
        return ruleCode;
    }

    /**
     * 规则代码
     * @param ruleCode 规则代码
     */
    public void setRuleCode(byte[] ruleCode) {
        this.ruleCode = ruleCode;
    }
}