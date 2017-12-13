package com.hzcf.operation.service.impl;

import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.entity.QueryLogExt;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.result.LogQuery;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.base.util.StringUtils;
import com.hzcf.operation.gen.entity.QueryLog;
import com.hzcf.operation.gen.entity.QueryLogExample;
import com.hzcf.operation.gen.entity.Rules;
import com.hzcf.operation.gen.entity.RulesExample;
import com.hzcf.operation.gen.mapper.QueryLogMapper;
import com.hzcf.operation.gen.mapper.QueryLogsForStaticsMapper;
import com.hzcf.operation.service.QueryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liqinwen on 2017/12/3.
 * 访问日志查询 for mysql
 */
@Service("queryLogService")
public class QueryLogServiceImpl implements QueryLogService{

    @Autowired
    QueryLogsForStaticsMapper queryLogsForStaticsMapper;

    @Autowired
    QueryLogMapper queryLogMapper;
    /**
     *
     * @param queryLogExt
     * @param page
     * @return
     */
    @Override
    public ResultPage<QueryLog> getQueryList(QueryLogExt queryLogExt, PageEntity page)
    {
        
        ResultPage<QueryLog> result = new ResultPage<QueryLog>();
        QueryLogExample example = BeanUtils.example(queryLogExt,QueryLogExample.class);
        example.setOrderByClause("id desc");
        if(StringUtils.isNotNull(queryLogExt.getEndTime()) && StringUtils.isNotNull(queryLogExt.getStartTime()))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date begin = sdf.parse(queryLogExt.getStartTime());
                Date end = sdf.parse(queryLogExt.getEndTime());
                example.createCriteria().andQueryTimeBetween(begin,end);
            } catch (ParseException e) {
                result.setResponseCode(ResponseCode.ERROR_PARAM);
                result.setMessage("开始时间与结束时间格式有误");
                return result;
            }
           }
        PageInfo pageInfo = page.toPageInfo();
        List<QueryLog> queryLogs =  queryLogMapper.selectByExampleWithRowbounds(example,pageInfo);
        result.setPageInfo(pageInfo);
        result.setData(queryLogs);
        return result;
    }
    /**
     * 按分钟统计访问量
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public Result<Map<String,Object>> getStaticsByHi(String startTime, String endTime)
    {
        Result<Map<String,Object>> result =new Result<>();
        Map<String,Object> data=new HashMap<String,Object>();
        List<String> xAxis=new ArrayList();
        List<String> series=new ArrayList();
        startTime = validateStartTime(startTime);
        endTime = validateEndTime(endTime);
        if(startTime!=null && endTime!=null)
        {
            QueryLogExt queryLogExt =new QueryLogExt();
            queryLogExt.setStartTime(startTime);
            queryLogExt.setEndTime(endTime);
            List<Map<String,Object>> ret = queryLogsForStaticsMapper.staticByHi(queryLogExt);
            for(Map<String,Object> m:ret)
            {
                xAxis.add(m.get("queryHi").toString());
                series.add(m.get("c").toString());
            }
            data.put("xAxis",xAxis);
            data.put("series",series);
            result.setData(data);
        }else{
            result.setResponseCode(ResponseCode.ERROR_PARAM);
            result.setMessage("开始时间与结束时间格式有误");
        }
        return result;
    }

    @Override
    public Result<Map<String,Object>> staticByTimeUsed(String startTime, String endTime)
    {
        Result<Map<String,Object>> result =new Result<>();
        Map<String,Object> data=new HashMap<String,Object>();
        List<Map<String,Object>> series=new ArrayList();
        startTime = validateStartTime(startTime);
        endTime = validateEndTime(endTime);
        if(startTime!=null && endTime!=null)
        {
            QueryLogExt queryLogExt =new QueryLogExt();
            queryLogExt.setStartTime(startTime);
            queryLogExt.setEndTime(endTime);
            List<Map<String,Object>> ret = queryLogsForStaticsMapper.staticByTimeUsed(queryLogExt);
            for(Map<String,Object> m:ret)
            {
                Map<String,Object> s=new HashMap<String,Object>();
                s.put("value",m.get("c"));
                s.put("name",m.get("u"));
                series.add(s);
            }
            data.put("series",series);
            result.setData(data);
        }else{
            result.setResponseCode(ResponseCode.ERROR_PARAM);
            result.setMessage("开始时间与结束时间格式有误");
        }
        return result;
    }

    @Override
    public Result<Map<String,Object>> staticState(String startTime, String endTime)
    {
        Result<Map<String,Object>> result =new Result<>();
        Map<String,Object> data=new HashMap<String,Object>();
        List<Map<String,Object>> series=new ArrayList();
        startTime = validateStartTime(startTime);
        endTime = validateEndTime(endTime);
        if(startTime!=null && endTime!=null)
        {
            QueryLogExt queryLogExt =new QueryLogExt();
            queryLogExt.setStartTime(startTime);
            queryLogExt.setEndTime(endTime);
            List<Map<String,Object>> ret = queryLogsForStaticsMapper.staticState(queryLogExt);
            for(Map<String,Object> m:ret)
            {
                Map<String,Object> s=new HashMap<String,Object>();
                s.put("value",m.get("c"));
                s.put("name",m.get("s"));
                series.add(s);
            }
            data.put("series",series);
            result.setData(data);
        }else{
            result.setResponseCode(ResponseCode.ERROR_PARAM);
            result.setMessage("开始时间与结束时间格式有误");
        }
        return result;
    }


    @Override
    public QueryLog selectByPrimary(int id){
        return   queryLogMapper.selectByPrimaryKey(id);
    }

    private String validateStartTime(String startTime) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date begin;
        if (StringUtils.isNotNull(startTime)) {
            try {
                begin = sdf.parse(startTime);
            } catch (ParseException e) {
                return null;
            }
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            begin = calendar.getTime();
        }
        return sdf.format(begin);
    }

    private String validateEndTime(String endTime) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date end;
        if (StringUtils.isNotNull(endTime)) {

            try {
                end = sdf.parse(endTime);
            } catch (ParseException e) {
                return null;
            }
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 24);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            end = calendar.getTime();
        }
        return sdf.format(end);
    }

}
