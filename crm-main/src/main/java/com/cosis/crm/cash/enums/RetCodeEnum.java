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
    COMMON_FIELD_VALUE_INVALID(997, "字符值不在有效范围"),

    COMMON_ERROR_NULL_OPENID(1, "OPENID为空"),
    COMMON_ERROR_VALID_SMS(2, "验证短信验证码失败"),
    COMMON_ERROR_VALID_BANKNO(3, "银行卡号格式有误"),
    COMMON_ERROR_VALID_IDCARDNO(4, "身份证号码格式有误"),
    COMMON_ERROR_VALID_PHONENO(5, "手机号码格式有误"),
    COMMON_ERROR_VALID_BANKCODE(6, "银行编码有误"),
    COMMON_ERROR_NULL_WECHATID(7, "WECHATID为空"),
    COMMON_ERROR_NULL_USERINFO(8, "用户信息为空"),
    COMMON_ERROR_NULL_WEBANK_CARD_INFO(9, "用户微众卡号信息为空"),

    COMMON_ERROR_TIMEOUT(408, "请求超时, 请重试"),
    COMMON_ERROR_CANNOT_CON(503, "链接失败, 请重试"),
    COMMON_ERROR_TRY_AGAIN(500, "后台异常, 请稍后再试"),

    REGISTER_FAILED_NULL_USER(-10, "未获取到用户信息, 拒贷"),
    REGISTER_FAILED_EXISTS_USER(10, "您已注册, 请勿重复提交数据"),

    IDCARD_ERROR_NULL_OCR(21, "未获取到OCR结果识别, 请重新上传身份证"),
    IDCARD_ERROR_PHONE(20, "实名认证手机号和身份证不符, 请重新填写手机号"),
    IDCARD_FAILED_NOT_EQUAL(-20, "身份证号不匹配,拒贷"),
    IDCARD_FAILED_ISBLACK(-21, "黑名单,拒贷"),
    IDCARD_FAILED_NULL_CUSTOMER(-22, "未获取到customer表中用户信息"),

    ACCOUNT_ERROR_PHONE(30, "请重新填写手机号"),
    ACCOUNT_ERROR_UNDER_REVIEW(31, "开户审核中"),
    ACCOUNT_ERROR_REFILL_BANKCARD(32, "请重新填写银行卡"),
    ACCOUNT_FAILED_NULL_USER(-30, "未获取到用户信息"),
    ACCOUNT_FAILED_FIRST_REJECT(-31, "微众同步返回拒绝了开户申请"),
    ACCOUNT_FAILED_SECOND_REJECT(-32, "微众异步审核拒绝了开户申请"),
    ACCOUNT_FAILED_THIRD_REJECT(-33, "微众人工审核拒绝了开户申请"),

    POLL_ERROR_NULL_CARDINFO(40, "未获取到卡号信息, 请重试"),
    POLL_FAILED_NULL_USER(41, "未获取到用户信息"),

    WECARD_ERROR_NULL_SUNLINELIMIT(50,"请求长亮接口获取额度失败,请重试"),
    WECARD_ERROR_NULL_SUNLINEBILL(51,"请求长亮接口获取已出账单失败,请重试"),
    WECARD_ERROR_NULL_SUNLINEUNSETBILL(52,"请求长亮接口获取未出账单失败,请重试"),
    WECARD_ERROR_NULL_SUNLINELIST(53,"请求长亮接口获取账单详情失败,请重试"),
    WECARD_ERROR_NULL_STMTNO(54,"账期为空"),

    //理财类型维护相关
    COMMON_ERROR_NULL_INCOMETYPE_TYPENAME(60,"理财类型名称不能为空!"),
    COMMON_ERROR_NULL_INCOMETYPE_ID(61,"理财类型ID不能为空!"),
    COMMON_ERROR_NULL_INCOMETYPE_ADD(62,"添加失败，请重试!"),
    COMMON_ERROR_NULL_INCOMETYPE_DEL(63,"删除失败，请重试!"),
    COMMON_ERROR_NULL_INCOMETYPE_UPDATE(64,"修改失败，请重试!"),
    COMMON_ERROR_NULL_INCOMETYPE_SAVE(65,"保存失败，理财类型名称不能重复!"),

    //理财信息
    COMMON_ERROR_NULL_INCOMEINFO_ADD(70,"添加失败，请重试!");

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
