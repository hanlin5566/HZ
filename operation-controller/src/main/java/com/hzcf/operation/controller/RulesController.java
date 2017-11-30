package com.hzcf.operation.controller;

import com.hzcf.operation.base.entity.DerivedVariableExt;
import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.RulesExt;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.enums.DerivedVarStatus;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.base.util.StringUtils;
import com.hzcf.operation.gen.entity.*;
import com.hzcf.operation.gen.mapper.DerivedVariableMapper;
import com.hzcf.operation.service.DerivedRulesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by liqinwen on 2017/11/25.
 */
@RestController
@RequestMapping(value="/Rules")
@Api("规则库管理")
public class RulesController {

    @Autowired
    private DerivedRulesService derivedRulesService;

    @Autowired
    private DerivedVariableMapper derivedVariableMapper;

    @ApiOperation(value="获取规则库列表", notes="根据搜索条件")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public ResultPage<Rules> getDerivedVariableList(Rules rules, PageEntity page) {

        return derivedRulesService.getList(rules,page);
    }


    @ApiOperation(value="获取所有规则库列表", notes="根据搜索条件")
    @RequestMapping(value={"/all"}, method= RequestMethod.POST)
    public ResultPage<Rules> getAllDerivedVariableList(@RequestBody Rules rules) {

        return derivedRulesService.getAllList(rules);
    }

    @ApiOperation(value="获取规则库", notes="根据规则库ID获取")
    @RequestMapping(value={"/{ruleId}"}, method=RequestMethod.GET)
    public Result<RulesExt> getDerivedVariable(@PathVariable Integer ruleId) throws Exception {

        Result<RulesExt> result = new Result<RulesExt>();
        Rules rule =derivedRulesService.getEdit(ruleId);
        RulesExt copyResult = BeanUtils.copyProperties(rule, RulesExt.class);
        if(rule.getRuleCode()!=null)
        {
            copyResult.setContent( new String(rule.getRuleCode()));
        }
        result.setData(copyResult);
        return result;
    }

    @ApiOperation(value="保存或新增规则库", notes="")
    @RequestMapping(value={""}, method=RequestMethod.POST)
    public Result<Integer> saveOrUpdate(@RequestBody RulesExt rules, HttpServletRequest request) throws Exception {

        Result<Integer> result = new Result<Integer>();
        //变量是否存在并已发布
        DerivedVariable derivedVariable = new DerivedVariable();
        derivedVariable.setVarRetName(rules.getRuleKey());
        DerivedVariableExample example = BeanUtils.example(derivedVariable,DerivedVariableExample.class);
        example.createCriteria().andStateEqualTo(DerivedVarStatus.PUBLISHED);
        List<DerivedVariable>  derivedVariables =  derivedVariableMapper.selectByExample(example);
        if(derivedVariables.size()>0)
        {
            //变量是否已添加规则
            Rules rulesExample = new Rules();
            rulesExample.setRuleKey(rules.getRuleKey());
            rulesExample.setDataStatus(DataStatus.NORMAL);
            List<Rules> rulesList = derivedRulesService.isExist(rulesExample);
            if(rulesList.size()>0 && rules.getId()==null && rules.getRuleKey().equals(rulesList.get(0).getRuleKey()))
            {
                result.setResponseCode(ResponseCode.FAILED);
                result.setMessage(rules.getRuleKey()+" 变量已设置规则");
                return result;
            }
            else {
                rules.setVarGroupId(derivedVariables.get(0).getVarGroupId());
                rules.setRuleCode(rules.getContent().getBytes());
                Integer ruleId = derivedRulesService.saveOrUpdate(rules);
                result.setData(ruleId);
                return result;
            }
        }else{
            result.setResponseCode(ResponseCode.FAILED);
            result.setMessage("变量："+rules.getRuleKey()+"不存在或者未发布");
            return result;
        }



    }
}
