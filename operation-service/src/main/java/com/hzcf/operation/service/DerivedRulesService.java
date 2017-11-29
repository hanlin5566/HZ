package com.hzcf.operation.service;

import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.gen.entity.DerivedVariableGroup;
import com.hzcf.operation.gen.entity.Rules;

import java.util.List;

/**
 * Created by liqinwen on 2017/11/25.
 */
public interface DerivedRulesService {

    public ResultPage<Rules> getList(Rules rules, PageEntity page);
    public Rules getEdit(Integer ruleId);
    public Integer saveOrUpdate(Rules rules);
    public ResultPage<Rules> getAllList(Rules rules);
    public List<Rules> isExist(Rules rules);
}
