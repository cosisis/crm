package com.cosis.crm.cash.utils;

import com.cosis.crm.cash.domain.Pair;
import org.springframework.stereotype.Component;

/**
 * @author cosis
 * 缓存key生成类
 */
@Component
public class CacheHelper {
    //一分钟毫秒数
    private static final int SECOND = 60 * 1000;

    private static final int LIMIT = -1 ;

    // OCR登录token缓存key
    private static final String OCR_TOKEN_KEY = "hub:crm:OCR_TOKEN_";
    // OCR登录token缓存时间, 110分钟
    private static final int OCR_TOKEN_EXPIRE_TIME = 110 * SECOND;
    // OCR token缓存
    public Pair<String, Integer> getOcrToken(String orderno) {
        return new Pair<>(OCR_TOKEN_KEY + orderno, OCR_TOKEN_EXPIRE_TIME);
    }

    // OCR识别订单号缓存key,防止重复请求
    private static final String OCR_ORDERNO_KEY = "hub:crm:OCR_ORDERNO_";
    // OCR识别订单号缓存时间, 1分钟
    private static final int OCR_ORDERNO_EXPIRE_TIME = 1 * SECOND;
    // OCR token缓存
    public  Pair<String, Integer> getOcrOrderNo(String orderno) {
        return new Pair<>(OCR_ORDERNO_KEY + orderno, OCR_ORDERNO_EXPIRE_TIME);
    }


    // 用户注册流程, 步骤记录
    private static final String CUS_REGISTER_STEP_KEY = "hub:crm:CUS_REG_STEP_";
    // 用户注册流程, 步骤记录key
    public Pair<String, Integer> getCustomerRegisterStep(String wechatid) {
        return new Pair<>(CUS_REGISTER_STEP_KEY + wechatid, LIMIT);
    }


}