package com.hzcf.operation.service.impl;

import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.entity.RuleGroupExt;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.gen.entity.*;
import com.hzcf.operation.gen.mapper.RuleGroupListMapper;
import com.hzcf.operation.gen.mapper.RuleGroupMapper;
import com.hzcf.operation.gen.mapper.RulesJoinGroupMapper;
import com.hzcf.operation.gen.mapper.RulesMapper;
import com.hzcf.operation.service.DerivedRulesService;
import com.hzcf.operation.service.RuleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liqinwen on 2017/11/24.
 * 规则组管理
 */
@Service("RuleGroupService")
public class RuleGroupServiceImpl implements RuleGroupService {

    @Autowired
    private RuleGroupMapper ruleGroupMapper;

    @Autowired
    private RulesJoinGroupMapper rulesJoinGroupMapper;

    @Autowired
    private RuleGroupListMapper ruleGroupListMapper;

    @Override
    public ResultPage<RuleGroup> getList(RuleGroup rules, PageEntity page)
    {
        ResultPage<RuleGroup> ret = new ResultPage<RuleGroup>();
        RuleGroupExample example = BeanUtils.example(rules,RuleGroupExample.class);
        example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL);
        PageInfo pageInfo = page.toPageInfo();
        List<RuleGroup> rulesList =  ruleGroupMapper.selectByExampleWithRowbounds(example,pageInfo);
        ret.setPageInfo(pageInfo);
        ret.setData(rulesList);
        return ret;
    }

    @Override
    public RuleGroupExt getEdit(Integer ruleGroupId)
    {
        RuleGroupExt ruleGroupExt =new RuleGroupExt();
        RuleGroupExample example = new RuleGroupExample();
        example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL).andIdEqualTo(ruleGroupId);
        List<RuleGroup> ruleGroups = ruleGroupMapper.selectByExampleWithBLOBs(example);
        ruleGroupExt =BeanUtils.copyProperties(ruleGroups.get(0),RuleGroupExt.class);
        ruleGroupExt.setRules(getRuleList(ruleGroups.get(0).getId()));
        return ruleGroupExt;
    }

    @Override
    @Transactional
    public Integer saveOrUpdate(RuleGroupExt rules)
    {
        if(rules.getId()!= null){
            return ruleGroupMapper.updateByPrimaryKeySelective(rules);
        }else{
            //ruleGrop的处理
            int[] ruleIds = rules.getRuleIds();
            rules.setDataStatus(DataStatus.NORMAL);
            Integer insertId = ruleGroupMapper.insert(rules);
            if(insertId>0)
            {
                for(int ruleId:ruleIds)
                {
                    RuleGroupList ruleGroupList = new RuleGroupList();
                    ruleGroupList.setGroupId(rules.getId());
                    ruleGroupList.setRuleId(ruleId);
                    ruleGroupList.setDataStatus(DataStatus.NORMAL);
                    ruleGroupListMapper.insertSelective(ruleGroupList);
                }
            }
            return insertId;
        }
    }

    /**
     * 规则组规则信息
     * @return
     */
    private List<Rules> getRuleList(Integer groupId)
    {
        return rulesJoinGroupMapper.selectRulesJoinRuleGroup(groupId);
    }
}
