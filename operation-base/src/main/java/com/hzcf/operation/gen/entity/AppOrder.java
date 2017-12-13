package com.hzcf.operation.gen.entity;

import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * hj_app_order 
 * @author huhanlin 2017-12-13
 */
public class AppOrder {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String logId;

    /**
     * 唯一进件号
     */
    private String taskId;

    /**
     * 
     */
    private Integer applicationType;

    /**
     * 进件时间
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date applicationTime;

    /**
     * 
     */
    private String idCard;

    /**
     * 决策结果类型 0=未知 1=不通过 2=通过 3=异常
     */
    private Byte decisionType;

    /**
     * 决策详情
     */
    private String decisionDesc;

    /**
     * 
     */
    private BigDecimal timeUsed;

    /**
     * 
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date createTime;

    /**
     * 
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date updateTime;

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
     * 
     * @return log_id 
     */
    public String getLogId() {
        return logId;
    }

    /**
     * 
     * @param logId 
     */
    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    /**
     * 唯一进件号
     * @return task_id 唯一进件号
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 唯一进件号
     * @param taskId 唯一进件号
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * 
     * @return application_type 
     */
    public Integer getApplicationType() {
        return applicationType;
    }

    /**
     * 
     * @param applicationType 
     */
    public void setApplicationType(Integer applicationType) {
        this.applicationType = applicationType;
    }

    /**
     * 进件时间
     * @return application_time 进件时间
     */
    public Date getApplicationTime() {
        return applicationTime;
    }

    /**
     * 进件时间
     * @param applicationTime 进件时间
     */
    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    /**
     * 
     * @return id_card 
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 
     * @param idCard 
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 决策结果类型 0=未知 1=不通过 2=通过 3=异常
     * @return decision_type 决策结果类型 0=未知 1=不通过 2=通过 3=异常
     */
    public Byte getDecisionType() {
        return decisionType;
    }

    /**
     * 决策结果类型 0=未知 1=不通过 2=通过 3=异常
     * @param decisionType 决策结果类型 0=未知 1=不通过 2=通过 3=异常
     */
    public void setDecisionType(Byte decisionType) {
        this.decisionType = decisionType;
    }

    /**
     * 决策详情
     * @return decision_desc 决策详情
     */
    public String getDecisionDesc() {
        return decisionDesc;
    }

    /**
     * 决策详情
     * @param decisionDesc 决策详情
     */
    public void setDecisionDesc(String decisionDesc) {
        this.decisionDesc = decisionDesc == null ? null : decisionDesc.trim();
    }

    /**
     * 
     * @return time_used 
     */
    public BigDecimal getTimeUsed() {
        return timeUsed;
    }

    /**
     * 
     * @param timeUsed 
     */
    public void setTimeUsed(BigDecimal timeUsed) {
        this.timeUsed = timeUsed;
    }

    /**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return update_time 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}