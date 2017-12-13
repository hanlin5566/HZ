package com.hzcf.operation.controller;

import com.alibaba.fastjson.JSONObject;
import com.hzcf.operation.base.entity.RuleGroupExt;
import com.hzcf.operation.base.exception.CustomException;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.util.StringUtils;
import com.hzcf.operation.gen.entity.AntiFraudParam;
import com.hzcf.operation.gen.entity.QueryLog;
import com.hzcf.operation.service.AntiFraudTestService;
import com.hzcf.operation.service.MongoService;
import com.hzcf.operation.service.QueryLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.animation.AnimationTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/***
 * author:qinfeng.zheng
 * time:2017年12月7日15:20:44
 * work:反欺诈进件测试
 */

@RestController
@RequestMapping(value="/antiFraud")
@Api("反欺诈进件")
public class AntiFraudTestController {
    @Autowired
    private AntiFraudTestService antiFraudTestService;

    @Autowired
    private QueryLogService queryLogService;

    @Autowired
    private MongoService mongoService;


    @ApiOperation(value = "反欺诈进件测试", notes = "进件测试")
    @RequestMapping(value = {"/test"}, method = RequestMethod.POST)
    public Result compile(@RequestBody AntiFraudParam param, HttpServletRequest request) throws Exception {
        Result result = new Result<>();
        JSONObject jso = antiFraudTestService.testAntiFraud(param);
        result.setData(jso);
        
        return result;
    }

    @ApiOperation(value = "单接口详情", notes = "决策详情中单接口详情")
    @RequestMapping(value="/intefDetail/{queryLogId}", method = RequestMethod.GET)
    public Result decisiStep(@RequestBody QueryLog queryLog, HttpServletRequest request) throws Exception {
        Result ret = new Result<>();
        //参数验证
        if (queryLog.getId()<1){
            throw new CustomException(ResponseCode.ERROR_PARAM,"参数不完整或有误");
        }
        //验证
        QueryLog returnQueryLog = queryLogService.selectByPrimary(queryLog.getId());
        if (returnQueryLog==null){
            throw new CustomException(ResponseCode.ERROR_PARAM,"查询日志不存在!");
        }
        if (!StringUtils.isNotNull(returnQueryLog.getInterfaceParentType())||!StringUtils.isNotNull(returnQueryLog.getInterfaceParentType()) ||!StringUtils.isNotNull(returnQueryLog.getInterfaceType())){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"查询日志数据异常!");
        }
        //mongoDb 取数
        Map returnMap = mongoService.getDesionMsg(returnQueryLog.getOrderNo(),returnQueryLog.getInterfaceParentType(),returnQueryLog.getInterfaceType());

        return  ret.setData(returnMap);

    }

}
