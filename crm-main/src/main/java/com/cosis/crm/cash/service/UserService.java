package com.cosis.crm.cash.service;

import com.cosis.crm.cash.domain.entity.UserInfo;

public interface UserService {
    /**
     * 查询用户 根据用户名和密码
     * @return
     */
    public UserInfo query(String usercode, String password);
}
