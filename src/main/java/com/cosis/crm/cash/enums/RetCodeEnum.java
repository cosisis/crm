package com.cosis.crm.cash.enums;

/**
 * @author cosis
 * 请求结果码
 * ERROR码 > 0, 界面重试
 * FAILED码 < 0, 拒贷
 * 新增类型错误码+10, 号段不同后期好排查问题
 */
public enum RetCodeEnum {

    OK(0, "OK"),
    ERROR(444, "ERROR"),
    SYSTEM_ERROR(999, "系统繁忙稍后再试"),
    COMMON_FIELD_NULL(998, "不可以有空字段"),
    COMMON_FIELD_VALUE_INVALID(997, "字符值不在有效范围");

    private int type;

    private String text;

    RetCodeEnum(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int intValue() {
        return type;
    }
}
