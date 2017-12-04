package com.hzcf.operation.base.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.serialize.EnumJsonSerializer;
import com.hzcf.operation.base.util.DateUtils;
import com.hzcf.operation.gen.entity.QueryLog;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class QueryLogExt extends QueryLog{

    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
