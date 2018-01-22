package com.cosis.crm.cash.domain;

import com.cosis.crm.cash.enums.RetCodeEnum;

public class ReturnVal {

    private int retCode;

    private Object data;

    private String msg;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public ReturnVal() {
    }

    public ReturnVal(int retCode, Object data, String msg) {
        this.retCode = retCode;
        this.data = data;
        this.msg = msg;
    }

    public static ReturnVal failedResult(RetCodeEnum code) {
        return new ReturnVal(code.intValue(), code.getText(), code.getText());
    }

    /**
     * 针对有三种返回情况的返回
     * @param retCodeEnum 0 成功, 小于0失败, 大于0重试
     * @param value
     * @return
     */
    public static ReturnVal successResult(RetCodeEnum retCodeEnum, Object value) {
        return new ReturnVal(retCodeEnum.intValue(), value, retCodeEnum.getText());
    }


}
