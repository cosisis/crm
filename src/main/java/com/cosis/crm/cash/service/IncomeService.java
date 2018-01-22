package com.cosis.crm.cash.service;

import com.cosis.crm.cash.domain.Result;
import com.cosis.crm.cash.domain.entity.IncomeInfo;
import com.cosis.crm.cash.enums.RetCodeEnum;
import com.cosis.crm.cash.mapper.IncomeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeService {

    @Autowired
    IncomeInfoMapper infoMapper;

    public Result add (IncomeInfo info){
        Result result = new Result();
        result.setRetEnum((infoMapper.add(info) > 0) ? RetCodeEnum.OK : RetCodeEnum.COMMON_ERROR_TRY_AGAIN) ;
        return result;
    }
}