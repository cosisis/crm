package com.cosis.crm.cash.service.impl;

import com.cosis.crm.cash.domain.Result;
import com.cosis.crm.cash.domain.entity.IncomeInfo;
import com.cosis.crm.cash.enums.RetCodeEnum;
import com.cosis.crm.cash.mapper.IncomeInfoMapper;
import com.cosis.crm.cash.service.IncomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j(topic = "IncomeServiceImpl")
@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeInfoMapper infoMapper;

    @Override
    public Result add(IncomeInfo info) {
        log.info("info.getIncome_type:{},info.getPrincipal:{},info.getRate:{},info.getProfit:{},info.getBegin_date:{}",info.getIncome_type(),info.getPrincipal(),info.getRate(),info.getProfit(),info.getBegin_date());
        Result result = new Result();
        result.setRetEnum((infoMapper.add(info) > 0) ? RetCodeEnum.OK : RetCodeEnum.COMMON_ERROR_NULL_INCOMEINFO_ADD) ;
        return result;
    }
}
