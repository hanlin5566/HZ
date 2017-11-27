package com.hzcf.operation.base.result;

import java.util.Date;

public class InterfaceRecordEntity {
	private String id;
	private String userId;
	private String userName;
	private String interfaceParentType;
	private String idCard;
	private String name;
	private String mobile;
	private String queryHi;
	private String queryHis;
	private Long timeUsed;
	private String taskId;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getQueryHis() {
		return queryHis;
	}

	public void setQueryHis(String queryHis) {
		this.queryHis = queryHis;
	}

	public Long getTimeUsed() {
		return timeUsed;
	}

	public void setTimeUsed(Long timeUsed) {
		this.timeUsed = timeUsed;
	}

	public String getQueryHi() {
		return queryHi;
	}

	public void setQueryHi(String queryHi) {
		this.queryHi = queryHi;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInterfaceParentType() {
		return interfaceParentType;
	}

	public void setInterfaceParentType(String interfaceParentType) {
		this.interfaceParentType = interfaceParentType;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	private Date queryTime;
	private Date returnTime;
	private String interfaceType;
	private String state;
	private String queryParams;
	private String results;
	private String ipAddress;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(Date queryTime) {
		this.queryTime = queryTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public String getInterfaceType() {
		return interfaceType;
	}
	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getQueryParams() {
		return queryParams;
	}
	public void setQueryParams(String queryParams) {
		this.queryParams = queryParams;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
