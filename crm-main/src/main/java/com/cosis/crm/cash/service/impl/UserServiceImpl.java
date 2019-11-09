package com.cosis.crm.cash.service.impl;

import com.cosis.crm.cash.domain.entity.UserInfo;
import com.cosis.crm.cash.mapper.UserMapper;
import com.cosis.crm.cash.service.UserService;
import com.cosis.crm.cash.utils.CheckHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j(topic = "UserServiceImpl")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    CheckHelper checkHelper;

    @Autowired
    UserMapper userMapper;

    public UserInfo query(String usercode, String password){
        log.info(" UserServiceImpl query()");
        return userMapper.getUser_name_password(usercode,password);
    }

}
