package com.hzcf.operation.service.impl;

import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.base.util.StringUtils;
import com.hzcf.operation.gen.entity.DerivedVariable;
import com.hzcf.operation.gen.entity.DerivedVariableExample;
import com.hzcf.operation.gen.entity.DerivedVariableGroup;
import com.hzcf.operation.gen.entity.DerivedVariableGroupExample;
import com.hzcf.operation.gen.mapper.DerivedVariableGroupMapper;
import com.hzcf.operation.service.DerivedVariableGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liqinwen on 2017/11/24.
 */
@Service("derivedVariableGroup")
public class DerivedVariableGroupServiceImpl implements DerivedVariableGroupService {

    @Autowired
    DerivedVariableGroupMapper derivedVariableGroupMapper;

    @Override
    public ResultPage<DerivedVariableGroup> getList(DerivedVariableGroup derivedVariableGroup, PageEntity page)
    {
        ResultPage<DerivedVariableGroup> ret = new ResultPage<DerivedVariableGroup>();
        DerivedVariableGroupExample example = BeanUtils.example(derivedVariableGroup,DerivedVariableGroupExample.class);
        example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL);
        PageInfo pageInfo = page.toPageInfo();
        List<DerivedVariableGroup> derivedVariableGroupList =  derivedVariableGroupMapper.selectByExampleWithRowbounds(example,pageInfo);
        ret.setPageInfo(pageInfo);
        ret.setData(derivedVariableGroupList);
        return ret;
    }

    @Override
    public DerivedVariableGroup getEdit(Integer groupId)
    {
        return derivedVariableGroupMapper.selectByPrimaryKey(groupId);
    }

    @Override
    public Integer saveOrUpdate(DerivedVariableGroup derivedVariableGroup)
    {
        if(derivedVariableGroup.getVarGroupId()!= null){
            return derivedVariableGroupMapper.updateByPrimaryKey(derivedVariableGroup);
        }else{
            return derivedVariableGroupMapper.insert(derivedVariableGroup);
        }
    }
}
