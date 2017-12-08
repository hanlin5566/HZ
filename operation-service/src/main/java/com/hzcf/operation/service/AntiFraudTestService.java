package com.hzcf.operation.service;


import com.alibaba.fastjson.JSONObject;

import com.hzcf.operation.gen.entity.AntiFraudParam;


public interface AntiFraudTestService {

	public JSONObject testAntiFraud(AntiFraudParam pram);

}
