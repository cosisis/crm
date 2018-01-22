package com.cosis.crm.cash.domain.entity;

import lombok.Data;

@Data
public class UserInfo {

    private int id;

    private String nick_name;

    private String name;

    private String pwd;

    /**
     * 薪资日
     */
    private int salary_day;
}