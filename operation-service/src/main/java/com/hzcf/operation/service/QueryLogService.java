package com.hzcf.operation.service;

import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.QueryLogExt;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.gen.entity.QueryLog;

import java.util.List;
import java.util.Map;

/**
 * Created by liqinwen on 2017/12/3.
 */
public interface QueryLogService {
    public Result<Map<String,Object>> getStaticsByHi(String startTime, String endTime);
    public Result<Map<String,Object>> staticByTimeUsed(String startTime, String endTime);
    public Result<Map<String,Object>> staticState(String startTime, String endTime);
    public ResultPage<QueryLog> getQueryList(QueryLogExt queryLogExt, PageEntity page);
    public QueryLog selectByPrimary(int id);
}
