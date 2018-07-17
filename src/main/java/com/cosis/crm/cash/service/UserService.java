package com.cosis.crm.cash.service;

import com.cosis.crm.cash.domain.entity.IncomeType;
import com.cosis.crm.cash.domain.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /**
     * 查询用户 根据用户名和密码
     * @return
     */
    public UserInfo query(String usercode,String password);
}
