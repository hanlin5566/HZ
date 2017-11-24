package com.hzcf.operation.gen.entity;

import java.util.Date;

/**
 * Created by liqinwen on 2017/9/5.
 */
public class ErrorLog {

    private String _id;
    private String message;
    private String timestamp;
    private String fileName;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
