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
        Map a = new HashMap();
        Map<String,String> map = new HashMap<>();
        param.setIdCard("140502198811102244");
        param.setMobile("13986671110");
        param.setName("王亮");
        param.setTaskId("AP500228199306179610");

        param.setApplicationType(1);
        param.setBirthday("2000-11-10");
        param.setGender("男");
        param.setRace("汉");
        param.setIdCardAddress("江西南昌");
        param.setIdCardValidDate("2001.11.12-2020.11.12");
        param.setIdCardLegality("1");
        param.setThresholdsFace("0.00000889");
        param.setThresholdsIdcard("0.00000889");
        param.setIdAttacked("1");
        param.setEducation("硕士研究生");
        param.setMaritalStatus("已婚无子女");
        param.setDomicile("江西南昌");
        param.setHomeAddr("南昌市红谷滩新区香江路199号房地产交易市场3楼");
        param.setResidenceLength("3年以上");
        param.setIndustry("零售、商贸、企业");
        param.setCompanyAddr("南昌市红谷滩新区香江路199号房地产交易市场3楼");
        param.setWorkingHours("1年-3年");
        param.setCompany("南昌住房公积金管理中心");
        param.setPosition("中层管理人员");
        param.setMonthlyIncome("10000元以上");
        param.setPayrollDay("5");
        param.setRelativeType("配偶");
        param.setRelativeName("王女亮");
        param.setRelativeMobile("13986671119");
        param.setNonRelativeType("朋友");
        param.setNonRelativeName("王友亮");
        param.setNonRelativeMobile("18986671119");
        param.setLoanAmount("2000元");
        param.setLoanTerm("1个月");
        param.setLoanUsage("短期资金周转");
        param.setOtherChannelsInfo("有，已结清");
        param.setBankCard("6220211314567849990");
        param.setIp("112.65.143.245");

        param.setNextDataBacktracking("864000");
        param.setNextDataHistoryDays("100");
        param.setEmayCycle("3");
        param.setEmayPlatform("0");
        String params  = JSONObject.toJSONString(param);
        a.put("account","hjNoNeedAes");
        a.put("signature","rhiaw4uRsU&%JHFhhs53");
        a.put("data",params);
        //System.out.println("转换之后的："+JSONObject.toJSONString(a));


        JSONObject jso = antiFraudTestService.testAntiFraud(param);
        //System.out.println("结果，，，，，"+jso);
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
