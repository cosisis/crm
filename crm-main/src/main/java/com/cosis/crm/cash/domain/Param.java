package com.cosis.crm.cash.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cosis
 * 请求参数父类
 */
@Data
public class Param implements Serializable {

    private static final long serialVersionUID = 1L;

    private String wechatId;

}