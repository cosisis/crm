package com.cosis.crm.cash.domain;

import com.cosis.crm.cash.enums.RetCodeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author cosis
 * 返回参数父类
 */
@Slf4j
public class Result  {

    private RetCodeEnum retEnum;

    public RetCodeEnum getRetEnum() {
        return retEnum;
    }

    /**
     * 处理返回值
     * @param retEnum
     */
    public void setRetEnum(RetCodeEnum retEnum) {
        this.retEnum = retEnum;
    }

}
