package com.hzcf.operation.gen.entity;

import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * hj_query_log 新版查询记录
 * @author huhanlin 2017-12-03
 */
public class QueryLog {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String orderNo;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date queryTime;

    /**
     * 
     */
    private String queryHis;

    /**
     * 
     */
    private String queryHi;

    /**
     * 
     */
    private Integer timeUsed;

    /**
     * 
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date returnTime;

    /**
     * 
     */
    private String interfaceParentType;

    /**
     * 
     */
    private String interfaceType;

    /**
     * 
     */
    private Integer state;

    /**
     * 
     */
    private String idCard;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String mobile;

    /**
     * 
     */
    private String ipAddress;

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
     * @return order_no 
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 
     * @param orderNo 
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 
     * @return user_id 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 
     * @return query_time 
     */
    public Date getQueryTime() {
        return queryTime;
    }

    /**
     * 
     * @param queryTime 
     */
    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }

    /**
     * 
     * @return query_his 
     */
    public String getQueryHis() {
        return queryHis;
    }

    /**
     * 
     * @param queryHis 
     */
    public void setQueryHis(String queryHis) {
        this.queryHis = queryHis == null ? null : queryHis.trim();
    }

    /**
     * 
     * @return query_hi 
     */
    public String getQueryHi() {
        return queryHi;
    }

    /**
     * 
     * @param queryHi 
     */
    public void setQueryHi(String queryHi) {
        this.queryHi = queryHi == null ? null : queryHi.trim();
    }

    /**
     * 
     * @return time_used 
     */
    public Integer getTimeUsed() {
        return timeUsed;
    }

    /**
     * 
     * @param timeUsed 
     */
    public void setTimeUsed(Integer timeUsed) {
        this.timeUsed = timeUsed;
    }

    /**
     * 
     * @return return_time 
     */
    public Date getReturnTime() {
        return returnTime;
    }

    /**
     * 
     * @param returnTime 
     */
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    /**
     * 
     * @return interface_parent_type 
     */
    public String getInterfaceParentType() {
        return interfaceParentType;
    }

    /**
     * 
     * @param interfaceParentType 
     */
    public void setInterfaceParentType(String interfaceParentType) {
        this.interfaceParentType = interfaceParentType == null ? null : interfaceParentType.trim();
    }

    /**
     * 
     * @return interface_type 
     */
    public String getInterfaceType() {
        return interfaceType;
    }

    /**
     * 
     * @param interfaceType 
     */
    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType == null ? null : interfaceType.trim();
    }

    /**
     * 
     * @return state 
     */
    public Integer getState() {
        return state;
    }

    /**
     * 
     * @param state 
     */
    public void setState(Integer state) {
        this.state = state;
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
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @return mobile 
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 
     * @param mobile 
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 
     * @return ip_address 
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 
     * @param ipAddress 
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }
}