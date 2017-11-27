package com.hzcf.operation.base.result;

import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by qinfeng.zheng
 */
public class LogQuery {

    private String _id;
    private InterfaceRecordEntity message;
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date beginTime;
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date endTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public InterfaceRecordEntity getInterfaceRecordEntity() {
        return message;
    }

    public void setInterfaceRecordEntity(InterfaceRecordEntity interfaceRecordEntity) {
        this.message = interfaceRecordEntity;
    }
}