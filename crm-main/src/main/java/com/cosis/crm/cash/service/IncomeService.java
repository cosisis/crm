package com.cosis.crm.cash.service;

import com.cosis.crm.cash.domain.Result;
import com.cosis.crm.cash.domain.entity.IncomeInfo;

public interface IncomeService {

    /**
     * 添加理财
     * @param info
     * @return
     */
    public Result add(IncomeInfo info);


}