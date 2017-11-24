package com.hzcf.operation.controller;

import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.exception.CustomException;
import com.hzcf.operation.base.result.*;
import com.hzcf.operation.base.util.DateUtils;
import com.hzcf.operation.base.util.StringUtils;
import com.hzcf.operation.gen.entity.ErrorLog;
import com.hzcf.operation.service.MongoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Create by qinfeng.zheng 2017年11月20日17:18:31
 * dec:决策树可视化流程接口
 **/
@RestController
@RequestMapping(value="/vicdes")
@Api("决策树可视化流程接口")
public class VisDesController {

    @Autowired
    private MongoService mongoService;


    /***
     * work:数据平台异常监控  查询日期获取平台异常监控信息
     * @param request
     * @param errorLogQueryDto
     * @return
     */
    @ApiOperation(value="数据平台异常监控", notes="根据查询日期获取平台异常监控信息")
    @RequestMapping(value="/queryErrors", method= RequestMethod.POST)
    public Result queryLogErrorList(HttpServletRequest request,ErrorLogQueryDto errorLogQueryDto) {
        Result<List<ErrorLog>> ret = new Result<List<ErrorLog>>();

        if (!StringUtils.isNotNull(errorLogQueryDto.getBeginTime())) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> validate = new HashMap<String, Object>();
        Date begin ;
        Date end;
        try {
             validate   = DateUtils.validate(request, errorLogQueryDto.getBeginTime(), errorLogQueryDto.getEndTime());
             begin = (Date) validate.get("beginTime");
             end = (Date) validate.get("endTime");
        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }

        List<ErrorLog>  errorsList  = mongoService.getErrorLogs(begin,end);
        return  ret.setData(errorsList);
    }


    /***
     * work:数据平台异常监控详情
     * @param request
     * @param orderNo=主键 id
     * @return
     */

    @ApiOperation(value="数据平台异常监控详情", notes="数据异常详情")
    @RequestMapping(value="/getErrorByOrno", method= RequestMethod.POST)
    public Result getErrorByOrderNo(HttpServletRequest request,String orderNo) {
        Result<Map> ret = new Result<Map>();

        if (!StringUtils.isNotNull(orderNo)) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            map  =  mongoService.getError(orderNo);
        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        return  ret.setData(map);

    }


    /***
     * 接口查询详情
     * @param request
     * @param orderNo
     * @return
     */
    @ApiOperation(value="接口查询使用详情", notes="根据主键I")
    @RequestMapping(value="/getErrorDetail", method= RequestMethod.POST)
    public Result getErrorDetail(HttpServletRequest request,String orderNo) {
        Result<Map> ret = new Result<Map>();

        if (!StringUtils.isNotNull(orderNo)) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Map  detailMap = mongoService.getLogDetail(orderNo);
            map.put("message",detailMap.get("message"));
        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        return  ret.setData(map);
    }



    @ApiOperation(value="获取详", notes="")
    @RequestMapping(value="/{module}", method= RequestMethod.POST)
    public Result getErrorLogsByModule(HttpServletRequest request,String orderNo,String beginTime,String endTime,@PathVariable(value = "module") String module) {
        Result<Map> ret = new Result<Map>();

        if (!StringUtils.isNotNull(module)) {
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        Date begin ;
        Date end;
        try {
            Map dateMap   = DateUtils.validate(request, beginTime, endTime);
            begin = (Date) dateMap.get("beginTime");
            end = (Date) dateMap.get("endTime");
            System.out.printf("转换之后的时间:"+begin+end);
            Map reLog = new HashMap();
            switch (module){
                case "queryBySeconds":reLog = mongoService.getPv("queryHis",begin,end);break;
                case "queryTimeUsed":reLog = mongoService.getTimeUsed(begin,end);break;
                case "queryStatus":reLog  = mongoService.getState(begin,end);break;
            }
            map.put("data",reLog);

        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        return  ret.setData(map);
    }



    @ApiOperation(value="获取分页数据", notes="分页")
    @RequestMapping(value="/queryErrorLogs", method= RequestMethod.POST)
    public ResultPage getReponseBody(HttpServletRequest request,ErrorLogQueryDto errorLogQueryDto) {
        ResultPage<LogQuery> ret = new ResultPage<LogQuery>();
        if (!StringUtils.isNotNull(errorLogQueryDto.getBeginTime())||!StringUtils.isNotNull(errorLogQueryDto.getEndTime())) {
            ret.setCode(401);
            throw  new CustomException(ResponseCode.ERROR_PARAM,"请求参数不完整或有误!");
        }
        Map<String, Object> validate = new HashMap<String, Object>();
        List<LogQuery> logs = new ArrayList<>();
        PageInfo page = new PageInfo();
        try {
           // validate   = DateUtils.validate(request, errorLogQueryDto.getBeginTime(), errorLogQueryDto.getEndTime());
            //Date  begin = (Date) validate.get("beginTime");
            //Date  end = (Date) validate.get("endTime");
            logs = mongoService.getLogQuery(errorLogQueryDto);
            page = mongoService.getLogQueryCount(errorLogQueryDto);
        }catch (Exception e){
            throw  new CustomException(ResponseCode.ERROR_PARAM,"系统运行错误!");
        }
        ret.setData(logs);
        ret.setPageInfo(page);
        return  ret;
    }

}
