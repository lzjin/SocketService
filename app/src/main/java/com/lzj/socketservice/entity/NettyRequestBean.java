package com.lzj.socketservice.entity;

/**
 * Description: 作用描述
 * Author: Lzj
 * CreateDate: 2020/4/22
 */
public class NettyRequestBean {
    /**
     * code : 2
     * msg : 考勤数据
     * machineId : 机器ID
     * cardNo : 这是学号
     */
    public NettyRequestBean(int code, String msg, String machineId, String cardNo) {
        this.code = code;
        this.msg = msg;
        this.machineId = machineId;
        this.cardNo = cardNo;
    }

    public NettyRequestBean(int code, String msg, String machineId) {
        this.code = code;
        this.msg = msg;
        this.machineId = machineId;
    }

    private int code;
    private String msg;
    private String machineId;
    private String cardNo;

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

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
