package com.hzcf.operation.service;

import com.hzcf.operation.base.entity.AppOrderExt;
import com.hzcf.operation.base.entity.PageEntity;
import com.hzcf.operation.base.result.ResultPage;
import com.hzcf.operation.gen.entity.AppOrder;

/**
 * Created by liqinwen on 2017/12/6.
 */
public interface AppOrderService {

    public ResultPage<AppOrder> getOrderList(AppOrderExt appOrderExt, PageEntity page);
}
