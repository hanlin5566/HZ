package com.hzcf.operation.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hzcf.operation.base.entity.DerivedVariableExt;
import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.RuleGroupExt;
import com.hzcf.operation.base.entity.RulesExt;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.enums.DerivedVarStatus;
import com.hzcf.operation.base.exception.CustomException;
import com.hzcf.operation.base.redis.RedisProvider;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.gen.entity.RuleGroup;
import com.hzcf.operation.gen.entity.Rules;
import com.hzcf.operation.gen.mapper.GetInterFacesForRuleGroupMapper;
import com.hzcf.operation.service.DerivedRulesService;
import com.hzcf.operation.service.RuleGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by liqinwen on 2017/11/25.
 */
@RestController
@RequestMapping(value="/ruleGroup")
@Api("规则组管理")
public class RuleGroupController {

    @Autowired
    private RuleGroupService ruleGroupService;

    @Autowired
    private GetInterFacesForRuleGroupMapper getInterFacesForRuleGroupMapper;

    @ApiOperation(value = "获取规则组列表", notes = "根据搜索条件")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public ResultPage<RuleGroup> getDerivedVariableList(RuleGroup rules, PageEntity page) {

        return ruleGroupService.getList(rules, page);
    }

    @ApiOperation(value = "获取规则组", notes = "根据规则组ID获取")
    @RequestMapping(value = {"/{ruleGroupId}"}, method = RequestMethod.GET)
    public Result<RuleGroupExt> getDerivedVariable(@PathVariable Integer ruleGroupId) throws Exception {

        Result<RuleGroupExt> result = new Result<RuleGroupExt>();
        RuleGroupExt rule = ruleGroupService.getEdit(ruleGroupId);
        result.setData(rule);
        return result;
    }

    @ApiOperation(value = "保存或新增规则组", notes = "")
    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public Result<Integer> saveOrUpdate(@RequestBody RuleGroupExt rules, HttpServletRequest request) throws Exception {
        Integer ruleId = ruleGroupService.saveOrUpdate(rules);
        Result<Integer> ret = new Result<Integer>();
        ret.setData(ruleId);
        return ret;
    }

    @ApiOperation(value = "编译传入的文件", notes = "编译传入的文件")
    @RequestMapping(value = {"/compile"}, method = RequestMethod.POST)
    public Result<String> compile(@RequestBody RuleGroupExt rules, HttpServletRequest request) throws Exception {
        Result<String> result = new Result<>();
        Integer ruleId = ruleGroupService.saveOrUpdate(rules);
        if(!(ruleId>0))
        {
            result.setResponseCode(ResponseCode.FAILED);
            result.setMessage("保存失败");
        }
        JSONObject ret = ruleGroupService.RuleGroupTest(rules);

        if((boolean)ret.get("success"))
        {
            result.setData(ret.toJSONString());
           return  result;
        }else{
            result.setResponseCode(ResponseCode.FAILED);
            result.setMessage("编译失败!"+ret.getString("message"));
        }
        return result;
    }

    @ApiOperation(value = "发布规则集策略", notes = "")
    @RequestMapping(value = {"/pub"}, method = RequestMethod.GET)
    public Result<Integer> pub( String groupIdStr ,HttpServletRequest request) throws Exception {
        Result<Integer> result = new Result<Integer>();
        JSONObject param =new JSONObject();
        param.put("product","buddy_help");
        JSONArray steps = new JSONArray();
        String[] groupIds = groupIdStr.split("|");
        for(String groupId:groupIds)
        {
            if(!"|".equals(groupId) &&  !"".equals(groupId) && Integer.valueOf(groupId)>0)
            {
                JSONObject step =new JSONObject();
                RuleGroupExt ruleGroup = ruleGroupService.getEdit(Integer.valueOf(groupId));
                if(ruleGroup.getId()!=null)
                {
                    if(!DerivedVarStatus.PUBLISHED.name().equals(ruleGroup.getState().name()))
                    {
                        result.setResponseCode(ResponseCode.FAILED);
                        result.setMessage("规则组"+ruleGroup.getGroupKey()+"状态为未发布");
                        return result;
                    }else{
                        step.put("ruleGroup",ruleGroup.getGroupKey());

                        List<Map<String,Object>> interfaces =getInterFacesForRuleGroupMapper.getMap(Integer.valueOf(groupId));
                        int len =0;
                        StringBuilder interface_ =new StringBuilder();
                        for(Map<String,Object> inter:interfaces)
                        {
                            len++;
                            if(len<interfaces.size())
                            {
                                interface_.append(inter.get("queryIface")).append(",");
                            }else{
                                interface_.append(inter.get("queryIface"));
                            }
                        }
                        step.put("services",interface_);
                        steps.add(step);//排序问题
                    }
               }else{
                    result.setResponseCode(ResponseCode.FAILED);
                    result.setMessage("规则组不存在");
                    return result;
                }

            }
        }
        param.put("step",steps);
        RedisProvider.set("buddy_help",param.toJSONString());
        result.setMessage("发布成功");
        return result;
    }
}
