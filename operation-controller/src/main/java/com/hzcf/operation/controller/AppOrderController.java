package com.hzcf.operation.controller;

import com.hzcf.operation.base.entity.AppOrderExt;
import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.entity.QueryLogExt;
import com.hzcf.operation.base.result.Result;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.gen.entity.AppOrder;
import com.hzcf.operation.gen.entity.QueryLog;
import com.hzcf.operation.service.AppOrderService;
import com.hzcf.operation.service.QueryLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by liqinwen on 2017/11/25.
 */
@RestController
@RequestMapping(value="/AppOrder")
@Api("数据平台访问日志管理")
public class AppOrderController {

    @Autowired
    private AppOrderService appOrderService;

    @ApiOperation(value="决策列表", notes="根据搜索条件")
    @RequestMapping(value={"/getList"}, method= RequestMethod.GET)
    public ResultPage<AppOrder> getQueryList(AppOrderExt appOrderExt, PageEntity pageEntity) {
        return appOrderService.getOrderList(appOrderExt,pageEntity);
    }

}

