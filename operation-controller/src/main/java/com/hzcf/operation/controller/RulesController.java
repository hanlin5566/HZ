package com.hzcf.operation.controller;

import com.hzcf.operation.base.entity.DerivedVariableExt;
import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.RulesExt;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.gen.entity.DerivedVariableGroup;
import com.hzcf.operation.gen.entity.Rules;
import com.hzcf.operation.service.DerivedRulesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liqinwen on 2017/11/25.
 */
@RestController
@RequestMapping(value="/Rules")
@Api("规则库管理")
public class RulesController {

    @Autowired
    private DerivedRulesService derivedRulesService;

    @ApiOperation(value="获取规则库列表", notes="根据搜索条件")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public ResultPage<Rules> getDerivedVariableList(Rules rules, PageEntity page) {

        return derivedRulesService.getList(rules,page);
    }

    @ApiOperation(value="获取规则库", notes="根据规则库ID获取")
    @RequestMapping(value={"/{ruleId}"}, method=RequestMethod.GET)
    public Result<RulesExt> getDerivedVariable(@PathVariable Integer ruleId) throws Exception {

        Result<RulesExt> result = new Result<RulesExt>();
        Rules rule =derivedRulesService.getEdit(ruleId);
        RulesExt copyResult = BeanUtils.copyProperties(rule, RulesExt.class);
        copyResult.setContent( new String(rule.getRuleCode()));
        result.setData(copyResult);
        return result;
    }

    @ApiOperation(value="保存或新增规则库", notes="")
    @RequestMapping(value={""}, method=RequestMethod.POST)
    public Result<Integer> saveOrUpdate(@RequestBody RulesExt rules, HttpServletRequest request) throws Exception {
        rules.setRuleCode(rules.getContent().getBytes());
        Integer ruleId = derivedRulesService.saveOrUpdate(rules);
        Result<Integer> ret = new Result<Integer>();
        ret.setData(ruleId);
        return ret;
    }
}
