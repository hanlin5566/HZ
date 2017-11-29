package com.hzcf.operation.service;

import com.alibaba.fastjson.JSONObject;
import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.RuleGroupExt;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.gen.entity.RuleGroup;
import com.hzcf.operation.gen.entity.Rules;

/**
 * Created by liqinwen on 2017/11/25.
 */
public interface RuleGroupService {

    public ResultPage<RuleGroup> getList(RuleGroup rules, PageEntity page);
    public RuleGroupExt getEdit(Integer ruleId);
    public Integer saveOrUpdate(RuleGroupExt rules);
    public JSONObject RuleGroupTest(RuleGroupExt ruleGroupExt);
}
