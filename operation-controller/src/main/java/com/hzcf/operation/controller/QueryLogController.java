package com.hzcf.operation.controller;

import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.QueryLogExt;
import com.hzcf.operation.base.entity.RulesExt;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.enums.DerivedVarStatus;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.gen.entity.DerivedVariable;
import com.hzcf.operation.gen.entity.DerivedVariableExample;
import com.hzcf.operation.gen.entity.QueryLog;
import com.hzcf.operation.gen.entity.Rules;
import com.hzcf.operation.gen.mapper.DerivedVariableMapper;
import com.hzcf.operation.service.DerivedRulesService;
import com.hzcf.operation.service.QueryLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by liqinwen on 2017/11/25.
 */
@RestController
@RequestMapping(value="/QueryLog")
@Api("数据平台访问日志管理")
public class QueryLogController {

    @Autowired
    private QueryLogService queryLogService;

    @ApiOperation(value="数据平台访问列表", notes="根据搜索条件")
    @RequestMapping(value={"/getQueryList"}, method= RequestMethod.GET)
    public ResultPage<QueryLog> getQueryList(QueryLogExt queryLogExt, PageEntity pageEntity) {
        return queryLogService.getQueryList(queryLogExt,pageEntity);
    }

    @ApiOperation(value="当天访问按分钟统计", notes="根据搜索条件")
    @RequestMapping(value={"/getStaticsByHi"}, method= RequestMethod.POST)
    public Result<Map<String,Object>> getStaticsByHi(String startTime,String endTime) {
        return queryLogService.getStaticsByHi(startTime,endTime);
    }

    @ApiOperation(value="当天访问用时统计", notes="根据搜索条件")
    @RequestMapping(value={"/staticByTimeUsed"}, method= RequestMethod.POST)
    public Result<Map<String,Object>> staticByTimeUsed(String startTime,String endTime) {
        return queryLogService.staticByTimeUsed(startTime,endTime);
    }

    @ApiOperation(value="当天访问状态统计", notes="根据搜索条件")
    @RequestMapping(value={"/staticState"}, method= RequestMethod.POST)
    public Result<Map<String,Object>> staticState(String startTime,String endTime) {
        return queryLogService.staticState(startTime,endTime);
    }
}

