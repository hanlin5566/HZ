package com.hzcf.variable.engine.algorithms;

import com.hzcf.variable.engine.DerivedAlgorithms;

import java.util.Map;

/**
 * Create by hanlin on 2017年11月22日
 **/
public abstract class AbstractAlgorithms implements DerivedAlgorithms {
	private String varName;
	Map<String,Object> var;
	public String getVarName() {
		return varName;
	}
	public Map<String, Object> getVar() {
		return var;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public void setVar(Map<String,Object> var) {
		this.var = var;
	}
	
}
