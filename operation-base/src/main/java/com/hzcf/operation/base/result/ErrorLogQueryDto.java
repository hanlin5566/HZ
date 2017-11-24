package com.hzcf.operation.base.result;

import com.hzcf.operation.base.entity.PageEntity;

/**
 * author : qinfeng.zheng
 * time: 2017年11月21日17:12:05
 * work: 查询入参
 */
public class ErrorLogQueryDto extends InterfaceQueryEntity{
    private  String orderNo;

    private String beginTime;

    private  String endTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
