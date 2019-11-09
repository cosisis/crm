package com.cosis.crm.cash.domain.entity;

import lombok.Data;

@Data
public class UserInfo {

    private int id;

    private String usercode;

    private String password;

    private String username;

    /**
     * 薪资日
     */
    private int salary_day;
}