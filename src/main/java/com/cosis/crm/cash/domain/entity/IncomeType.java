package com.cosis.crm.cash.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author cosis
 * 收入类别
 */
@Data
public class IncomeType {

    private int id;

    private String type_name;

    private String create_name;

    private Date create_time;

}