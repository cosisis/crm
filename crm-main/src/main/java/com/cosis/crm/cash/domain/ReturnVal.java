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

    public static ReturnVal successResult() {
        return new ReturnVal(RetCodeEnum.OK.intValue(), null, "ok");
    }

    public static ReturnVal successResult(Object data) {
        return new ReturnVal(RetCodeEnum.OK.intValue(), data, "ok");
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
    public static ReturnVal neutralResult(RetCodeEnum retCodeEnum, Object value) {
        return new ReturnVal(retCodeEnum.intValue(), value, retCodeEnum.getText());
    }

    /**
     * 针对重试的情况, code>0
     * @return
     */
    public static ReturnVal tryAgainResult(){
        return new ReturnVal(RetCodeEnum.COMMON_ERROR_TRY_AGAIN.intValue(), null, RetCodeEnum.COMMON_ERROR_TRY_AGAIN.getText());
    }

}

