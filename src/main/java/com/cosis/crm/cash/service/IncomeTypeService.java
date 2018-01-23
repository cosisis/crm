package com.cosis.crm.cash.service;

import com.cosis.crm.cash.domain.Result;
import com.cosis.crm.cash.domain.entity.IncomeInfo;
import com.cosis.crm.cash.domain.entity.IncomeType;
import com.cosis.crm.cash.enums.RetCodeEnum;
import com.cosis.crm.cash.mapper.IncomeTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 理财类型
 * @author lz
 */
@Service
public class IncomeTypeService {

    @Autowired
    IncomeTypeMapper typeMapper;

    /**
     * 添加 理财类型
     * @param incomeType
     * @return
     */
    public Result add (IncomeType incomeType){
        Result result = new Result();
        result.setRetEnum((typeMapper.add(incomeType) > 0) ? RetCodeEnum.OK : RetCodeEnum.COMMON_ERROR_TRY_AGAIN) ;
        return result;
    }

    /**
     * 查询已有的理财类型列表
     * @return
     */
    public List<IncomeType> query(){
        return typeMapper.getAll();
    }
}
