package com.cosis.crm.cash.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class IncomeInfo {

    /**
     * id 主键
     */
    private int id;

    /**
     * 收入类别
     */
    private int income_type;
    /**
     * 收入类别名称
     */
    private String income_name;

    /**
     * 本金
     */
    private BigDecimal principal;

    /**
     * 利率
     */
    private BigDecimal rate;

    /**
     * 收益
     */
    private BigDecimal profit;

    /**
     * 存入日期
     */
    private int begin_date;

    /**
     * 计息日
     */
    private int value_date;

    /**
     * 到期日
     */
    private int end_date;

    /**
     * 投资天数
     */
    private int day_nums;

    /**
     * 创建人
     */
    private String user_id;

    /**
     * 创建时间
     */
    private Date create_time;


}