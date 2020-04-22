package com.lzj.socketservice.entity;

/**
 * Description: 作用描述
 * Author: Lzj
 * CreateDate: 2020/4/22
 */
public class EventBean {
    private int code;
    private String msg;

    public EventBean( String msg) {
        this.msg = msg;
    }

    public EventBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
