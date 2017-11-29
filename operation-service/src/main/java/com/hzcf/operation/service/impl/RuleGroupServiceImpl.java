package com.hzcf.operation.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.entity.RuleGroupExt;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.http.HttpClientInvoker;
import com.hzcf.operation.base.http.HttpClientProvider;
import com.hzcf.operation.base.http.HttpInvokeResult;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.gen.entity.*;
import com.hzcf.operation.gen.mapper.*;
import com.hzcf.operation.service.DerivedRulesService;
import com.hzcf.operation.service.RuleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private RuleGroupDelByGroupIdMapper ruleGroupDelByGroupIdMapper;

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
        int[] ruleIds = rules.getRuleIds();
        if(rules.getId()!= null){
            //删除原有数据
            int delId = ruleGroupDelByGroupIdMapper.deleteByGroupId(rules.getId());
            if(delId>0)
            {
                int updateId = ruleGroupMapper.updateByPrimaryKeySelective(rules);
                if(updateId>0)
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
                return updateId;
            }else{
                return 0;
            }
        }else{
            //ruleGrop的处理
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

    @Override
    public JSONObject RuleGroupTest(RuleGroupExt ruleGroupExt)
    {
        JSONObject ret = new JSONObject();
        JSONObject param =new JSONObject();
        param.put("groupKey",ruleGroupExt.getGroupKey());

        try{
            JSONObject params  = JSONObject.parseObject(ruleGroupExt.getTestDemo());
            param.put("param",params);
        }catch (Exception e)
        {
            ret.put("success",false);
            ret.put("message","参数解析失败"+e.getMessage());
        }
        HttpClientInvoker httpClientInvoker = new HttpClientProvider().provide("","http://192.168.1.121:8020/rule_debug");
        HttpInvokeResult result = httpClientInvoker.invokePostJSON(param.toJSONString());
        if(result.isOK())
        {
            try{
               ret = JSONObject.parseObject(result.getContentString());
               if((boolean)ret.get("success"))
               {
                  return  ret;
               }else{
                   ret.put("success",false);
                   ret.put("message",ret.getString("message"));
               }
            }catch (Exception e)
            {
                ret.put("success",false);
                ret.put("message","回传解析失败"+e.getMessage());
            }
        }else{
            ret.put("success",false);
            ret.put("message","http error:"+result.getReason());
        }
        return ret;
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
