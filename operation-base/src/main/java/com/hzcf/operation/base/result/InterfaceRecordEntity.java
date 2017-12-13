package com.hzcf.operation.base.result;

import java.util.Date;
import java.util.Map;

public class InterfaceRecordEntity {
	private String id;
	private String logId;

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	private String userId;
	private String userName;
	//一级接口名称
	private String interfaceParentType;
	//二级接口名称
	private String interfaceType;
	private String idCard;
	private String name;
	private String mobile;
	private String queryHi;
	private String queryHis;
	//查询用时
	private Long timeUsed;
	//流程Id
	private String taskId;
	//规则集Id
	private String ruleId;
	private String companyAddr;

	public String getCompanyAddr() {
		return companyAddr;
	}

	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	//查询时间

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	private Date queryTime;
	//返回时间
	private Date returnTime;
	//查询状态 1=查询异常 2=查询正常且有数据 3=查询正常且无数据  4=历史数据状态
	private String state;
	//查询入参
	private String queryParams;
	//查询回传
	private String results;
	//异常描述
	private String errorReturn;
	private String homeAddr;
	private String email;
	private String company;
	private String ipAddress;
	private Map data;

	public Map getData() {
		return data;
	}

	public void setData(Map data) {
		this.data = data;
	}

	public String getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getErrorReturn() {
		return errorReturn;
	}

	public void setErrorReturn(String errorReturn) {
		this.errorReturn = errorReturn;
	}

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
