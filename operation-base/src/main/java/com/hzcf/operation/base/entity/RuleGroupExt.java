package com.hzcf.operation.base.entity;

import com.hzcf.operation.gen.entity.RuleGroup;
import com.hzcf.operation.gen.entity.Rules;

import java.util.List;

/**
 * Created by liqinwen on 2017/11/28.
 */
public class RuleGroupExt extends RuleGroup {
    public List<Rules> getRules() {
        return rules;
    }

    public int[] ruleIds;

    public int[] getRuleIds() {
        return ruleIds;
    }

    public void setRuleIds(int[] ruleIds) {
        this.ruleIds = ruleIds;
    }

    public void setRules(List<Rules> rules) {
        this.rules = rules;
    }

    private List<Rules> rules;

}
