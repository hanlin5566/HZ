package com.hzcf.operation.service.impl;

import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.gen.entity.Rules;
import com.hzcf.operation.gen.entity.RulesExample;
import com.hzcf.operation.gen.mapper.DerivedVariableGroupMapper;
import com.hzcf.operation.gen.mapper.RulesMapper;
import com.hzcf.operation.service.DerivedRulesService;
import com.hzcf.operation.service.DerivedVariableGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liqinwen on 2017/11/24.
 */
@Service("derivedRulesService")
public class DerivedRulesServiceImpl implements DerivedRulesService {

    @Autowired
    RulesMapper rulesMapper;

    @Override
    public ResultPage<Rules> getList(Rules rules, PageEntity page)
    {
        ResultPage<Rules> ret = new ResultPage<Rules>();
        RulesExample example = BeanUtils.example(rules,RulesExample.class);
        example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL);
        PageInfo pageInfo = page.toPageInfo();
        List<Rules> rulesList =  rulesMapper.selectByExampleWithRowbounds(example,pageInfo);
        ret.setPageInfo(pageInfo);
        ret.setData(rulesList);
        return ret;
    }


    @Override
    public ResultPage<Rules> getAllList(Rules rules)
    {
        ResultPage<Rules> ret = new ResultPage<Rules>();
        RulesExample example = BeanUtils.example(rules,RulesExample.class);
        example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL);
        List<Rules> rulesList =  rulesMapper.selectByExample(example);
        ret.setData(rulesList);
        return ret;
    }

    @Override
    public List<Rules> isExist(Rules rules)
    {
        RulesExample example = BeanUtils.example(rules,RulesExample.class);
        example.createCriteria().andRuleKeyEqualTo(rules.getRuleKey());
        example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL);
        List<Rules> rulesList =  rulesMapper.selectByExample(example);
        return rulesList;
    }

    @Override
    public Rules getEdit(Integer ruleId)
    {
        return rulesMapper.selectByPrimaryKey(ruleId);
    }

    @Override
    public Integer saveOrUpdate(Rules rules)
    {
        if(rules.getId()!= null){
            return rulesMapper.updateByPrimaryKeyWithBLOBs(rules);
        }else{
            rules.setDataStatus(DataStatus.NORMAL);
            return rulesMapper.insertSelective(rules);
        }
    }
}
