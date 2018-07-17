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
public interface IncomeTypeService {


    /**
     * 添加 理财类型
     * @param incomeType
     * @return
     */
    public Result save (IncomeType incomeType);

    /**
     * 删除 理财类型
     * @param incomeType
     * @return
     */
    public Result del (IncomeType incomeType);

    /**
     * 查询已有的理财类型列表
     * @return
     */
    public List<IncomeType> query();
}
