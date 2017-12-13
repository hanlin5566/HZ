package com.hzcf.operation.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hzcf.operation.base.http.HttpClientInvoker;
import com.hzcf.operation.base.http.HttpClientProvider;
import com.hzcf.operation.base.http.HttpInvokeResult;
import com.hzcf.operation.gen.entity.AntiFraudParam;
import com.hzcf.operation.service.AntiFraudTestService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/***
 * 进件测试
 */
@Service("antiFraudTestService")
public class AntiFraudTestServiceImpl implements AntiFraudTestService{

    @Override
    public JSONObject testAntiFraud(AntiFraudParam pram){
        JSONObject ret = new JSONObject();
        Map a = new HashMap();
        Map<String,String> map = new HashMap<>();
        a.put("account","hjNoNeedAes");
        a.put("signature","rhiaw4uRsU&%JHFhhs53");
        a.put("data",JSONObject.toJSON(pram));
        HttpClientInvoker httpClientInvoker = new HttpClientProvider().provide("","http://192.168.1.220:8400/public/rule/start");
        HttpInvokeResult result = httpClientInvoker.invokePostJSON(JSONObject.toJSONString(a));
        if(result.isOK())
        {
            try{
                ret = JSONObject.parseObject(result.getContentString());
                if((boolean)ret.get("success"))
                {
                    return  ret;
                }else{
                    ret.put("success",false);
                    ret.put("message",ret.getString("message"));
                }
            }catch (Exception e)
            {
                ret.put("success",false);
                ret.put("message","回传解析失败"+e.getMessage());
            }
        }else{
            ret.put("success",false);
            ret.put("message","http error:"+result.getReason());
        }
        return ret;
    }
}
