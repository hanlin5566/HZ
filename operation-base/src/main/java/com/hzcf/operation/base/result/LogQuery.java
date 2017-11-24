package com.hzcf.operation.base.result;

/**
 * Created by liqinwen on 2017/9/14.
 */
public class LogQuery {

    private String _id;
    private InterfaceRecordEntity message;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public InterfaceRecordEntity getInterfaceRecordEntity() {
        return message;
    }

    public void setInterfaceRecordEntity(InterfaceRecordEntity interfaceRecordEntity) {
        this.message = interfaceRecordEntity;
    }
}