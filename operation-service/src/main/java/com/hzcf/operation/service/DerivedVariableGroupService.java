package com.hzcf.operation.service;

import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.gen.entity.DerivedVariableGroup;

/**
 * Created by liqinwen on 2017/11/24.
 */
public interface DerivedVariableGroupService {

    public ResultPage<DerivedVariableGroup> getList(DerivedVariableGroup derivedVariableGroup, PageEntity page);

    public DerivedVariableGroup getEdit(Integer groupId);

    public Integer saveOrUpdate(DerivedVariableGroup derivedVariableGroup);
}
