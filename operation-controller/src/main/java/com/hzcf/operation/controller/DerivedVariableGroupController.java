package com.hzcf.operation.controller;

import com.hzcf.operation.base.entity.DerivedVariableExt;
import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.exception.CustomException;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.base.util.CompileUtils;
import com.hzcf.operation.gen.entity.DerivedVariable;
import com.hzcf.operation.gen.entity.DerivedVariableExample;
import com.hzcf.operation.gen.entity.DerivedVariableGroup;
import com.hzcf.operation.gen.mapper.DerivedVariableMapper;
import com.hzcf.operation.service.DerivedVariableGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.UUID;

/**
 * Create by hanlin on 2017年11月6日
 **/
@RestController
@RequestMapping(value="/derivedGroup")
@Api("变量组管理")
public class DerivedVariableGroupController {
	@Autowired
	private DerivedVariableGroupService derivedVariableGroupService;
	
	
	@ApiOperation(value="获取变量组列表", notes="根据搜索条件")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public ResultPage<DerivedVariableGroup>getDerivedVariableList(DerivedVariableGroup derivedVariableGroup, PageEntity page) {

	    return derivedVariableGroupService.getList(derivedVariableGroup,page);
    }
	
	@ApiOperation(value="获取变量组", notes="根据变量组ID获取")
	@RequestMapping(value={"/{varGroupId}"}, method=RequestMethod.GET)
	public Result<DerivedVariableGroup>getDerivedVariable(@PathVariable Integer varGroupId) throws Exception {

		Result<DerivedVariableGroup> result = new Result<DerivedVariableGroup>();
		DerivedVariableGroup derivedVariableGroup =derivedVariableGroupService.getEdit(varGroupId);
		result.setData(derivedVariableGroup);
		return result;
	}
	
	@ApiOperation(value="保存或新增变量组", notes="")
    @RequestMapping(value={""}, method=RequestMethod.POST)
	public Result<Integer> saveOrUpdate(@RequestBody DerivedVariableGroup derivedVariableGroup,HttpServletRequest request) throws Exception {

		Integer varGroupId = derivedVariableGroupService.saveOrUpdate(derivedVariableGroup);
		Result<Integer> ret = new Result<Integer>();
		ret.setData(varGroupId);
		return ret;
	}

}
