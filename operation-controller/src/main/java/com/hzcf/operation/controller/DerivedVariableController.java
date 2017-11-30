package com.hzcf.operation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hzcf.compile.JavaStringCompiler;
import com.hzcf.operation.base.entity.DerivedVariableExt;
import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.exception.CustomException;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.base.util.BeanUtils;
import com.hzcf.operation.gen.entity.DerivedVariable;
import com.hzcf.operation.gen.entity.DerivedVariableExample;
import com.hzcf.operation.gen.entity.DerivedVariableWithBLOBs;
import com.hzcf.operation.gen.mapper.DerivedVariableMapper;
import com.hzcf.variable.engine.DerivedAlgorithms;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Create by hanlin on 2017年11月6日
 **/
@RestController
@RequestMapping(value="/derived")
@Api("衍生变量")
public class DerivedVariableController {
	@Autowired
	private DerivedVariableMapper derivedVariableMapper;

	
	
	@ApiOperation(value="获取衍生变量列表列表", notes="根据搜索条件查询衍生变量列表")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public ResultPage<DerivedVariable>getDerivedVariableList(DerivedVariable derivedVar,PageEntity page) {
		ResultPage<DerivedVariable> ret = new ResultPage<DerivedVariable>();
		DerivedVariableExample example = BeanUtils.example(derivedVar,DerivedVariableExample.class);
		PageInfo pageInfo = page.toPageInfo();
		List<DerivedVariable> result = derivedVariableMapper.selectByExampleWithRowbounds(example, pageInfo);
		ret.setPageInfo(pageInfo);
		ret.setData(result);
	    return ret;
    }
	
	@ApiOperation(value="获取衍生变量", notes="根据衍生变量ID获取衍生变量信息")
	@RequestMapping(value={"/{varId}"}, method=RequestMethod.GET)
	public Result<DerivedVariableExt>getDerivedVariable(@PathVariable Integer varId) throws Exception {
		Result<DerivedVariableExt> ret = new Result<DerivedVariableExt>();
		DerivedVariableExample example = new DerivedVariableExample();
		example.createCriteria().andVarIdEqualTo(varId);
		List<DerivedVariableWithBLOBs> result = derivedVariableMapper.selectByExampleWithBLOBs(example);
		//读取文件并将内容写入
		DerivedVariableExt copyResult = BeanUtils.copyProperties(result.get(0), DerivedVariableExt.class);
		if(result.get(0).getClazzPath()!=null)
		{
			String content = new String(result.get(0).getClazzPath());
			copyResult.setContent(content);
		}
		ret.setData(copyResult);
		return ret;
	}
	
	@ApiOperation(value="保存或新增衍生变量", notes="根据衍生变量ID，保存或新增衍生变量。获取request仅为了拿到存储文件地址")
    @RequestMapping(value={""}, method=RequestMethod.POST)
	public Result<Integer> saveOrUpdate(@RequestBody DerivedVariableExt derivedVar,HttpServletRequest request) throws Exception {

		derivedVar.setClazzPath(derivedVar.getContent().getBytes());
		if(derivedVar.getVarId()!= null){
			//TODO:优化为，拦截insert，统一插入数据状态与更新时间。
			derivedVariableMapper.updateByPrimaryKeySelective(derivedVar);
		}else{
			//TODO:优化为，拦截insert，统一插入数据状态与时间。
			derivedVar.setDataStatus(DataStatus.NORMAL);
			derivedVariableMapper.insert(derivedVar);
		}
		Result<Integer> ret = new Result<Integer>();
		ret.setData(derivedVar.getVarId());
		return ret;
	}
	
	@ApiOperation(value="编译传入的文件", notes="编译传入的文件")
    @RequestMapping(value={"/compile"}, method=RequestMethod.POST)
	public Result<String> compile(@RequestBody DerivedVariableExt derivedVar,HttpServletRequest request) throws Exception {
		String content = derivedVar.getContent();
		if(StringUtils.isEmpty(content)){
			throw new CustomException(ResponseCode.ERROR_PARAM, "传入文件内容不能为空");
		}
		JavaStringCompiler dynamicEngine =new JavaStringCompiler();
		String packagePath = "com.hzcf.variable.engine.algorithms.";
		String fullClassName =packagePath + derivedVar.getVarRetName();
		final Map<String,byte[]> classBytes =new HashMap<>();
		Object derived = dynamicEngine.compile(derivedVar.getVarRetName(),fullClassName,content,classBytes);
		Result<String> result =  new Result<>();
		if(derived instanceof String)
		{
			result.setResponseCode(ResponseCode.RESULT_SYSTEM_ERROR);
			result.setData(derived.toString());
		}
		else if(derived instanceof DerivedAlgorithms)
		{
			DerivedAlgorithms derivedAlgorithms = (DerivedAlgorithms)derived;
			derivedAlgorithms.setVarName(derivedVar.getVarRetName());
			String ret = derivedAlgorithms.execute(derivedVar.getTestDemo().toString());
			result.setData(derivedVar.getVarRetName()+"="+ret);
			derivedVar.setClazzName(fullClassName);
			derivedVar.setClassFile(classBytes.entrySet().iterator().next().getValue());
			derivedVariableMapper.updateByPrimaryKeySelective(derivedVar);
		}
		return result;
	}
}
