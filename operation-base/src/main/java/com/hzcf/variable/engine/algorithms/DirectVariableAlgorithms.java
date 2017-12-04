package com.hzcf.variable.engine.algorithms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Create by hanlin on 2017年12月1日
 **/
public class DirectVariableAlgorithms {
	public Object execute(String param,String varRecName) throws Exception {
		try {
			JSONObject obj = JSON.parseObject(param);
			return obj.get(varRecName);
		} catch (Exception e) {
			throw new Exception("此变量不支持由直接变量算法处理",e);
		}
	}
}
