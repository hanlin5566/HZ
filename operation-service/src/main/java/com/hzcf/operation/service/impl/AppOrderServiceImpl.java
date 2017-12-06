package com.hzcf.operation.service.impl;

import com.hzcf.operation.base.entity.AppOrderExt;
import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.entity.QueryLogExt;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.base.util.StringUtils;
import com.hzcf.operation.gen.entity.AppOrder;
import com.hzcf.operation.gen.entity.AppOrderExample;
import com.hzcf.operation.gen.entity.QueryLog;
import com.hzcf.operation.gen.entity.QueryLogExample;
import com.hzcf.operation.gen.mapper.AppOrderMapper;
import com.hzcf.operation.gen.mapper.QueryLogMapper;
import com.hzcf.operation.gen.mapper.QueryLogsForStaticsMapper;
import com.hzcf.operation.service.AppOrderService;
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
@Service("appOrderService")
public class AppOrderServiceImpl implements AppOrderService {

    @Autowired
    AppOrderMapper appOrderMapper;
    /**
     *
     * @param appOrderExt
     * @param page
     * @return
     */
    @Override
    public ResultPage<AppOrder> getOrderList(AppOrderExt appOrderExt, PageEntity page)
    {
        ResultPage<AppOrder> result = new ResultPage<AppOrder>();
        AppOrderExample example = BeanUtils.example(appOrderExt,AppOrderExample.class);
        example.setOrderByClause("id desc");
        if(StringUtils.isNotNull(appOrderExt.getEndTime()) && StringUtils.isNotNull(appOrderExt.getStartTime()))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date begin = sdf.parse(appOrderExt.getStartTime());
                Date end = sdf.parse(appOrderExt.getEndTime());
                example.createCriteria().andCreateTimeBetween(begin,end);
            } catch (ParseException e) {
                result.setResponseCode(ResponseCode.ERROR_PARAM);
                result.setMessage("开始时间与结束时间格式有误");
                return result;
            }
           }
        PageInfo pageInfo = page.toPageInfo();
        List<AppOrder> queryLogs =  appOrderMapper.selectByExampleWithRowbounds(example,pageInfo);
        result.setPageInfo(pageInfo);
        result.setData(queryLogs);
        return result;
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
