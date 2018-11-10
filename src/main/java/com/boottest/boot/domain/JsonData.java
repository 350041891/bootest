package com.boottest.boot.domain;

import java.io.Serializable;

public class JsonData implements Serializable {
    private Integer code;
    private Object data;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public JsonData() {
    }

    public JsonData(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
