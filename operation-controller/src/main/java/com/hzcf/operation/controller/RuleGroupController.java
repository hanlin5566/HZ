package com.hzcf.operation.controller;

import com.hzcf.operation.base.entity.DerivedVariableExt;
import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.RuleGroupExt;
import com.hzcf.operation.base.entity.RulesExt;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.gen.entity.RuleGroup;
import com.hzcf.operation.gen.entity.Rules;
import com.hzcf.operation.service.DerivedRulesService;
import com.hzcf.operation.service.RuleGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liqinwen on 2017/11/25.
 */
@RestController
@RequestMapping(value="/ruleGroup")
@Api("规则组管理")
public class RuleGroupController {

    @Autowired
    private RuleGroupService ruleGroupService;

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
    public Result<String> compile(@RequestBody RuleGroup rules, HttpServletRequest request) throws Exception {

        Result<String> result = new Result<>();
        return result;
    }

}
