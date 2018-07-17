package com.cosis.crm.cash.service;

import com.cosis.crm.cash.controller.IncomeController;
import com.cosis.crm.cash.domain.Result;
import com.cosis.crm.cash.domain.ReturnVal;
import com.cosis.crm.cash.domain.entity.IncomeInfo;
import com.cosis.crm.cash.enums.RetCodeEnum;
import com.cosis.crm.cash.mapper.IncomeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;

@Service
public interface IncomeService {

    /**
     * 添加理财
     * @param info
     * @return
     */
    public Result add (IncomeInfo info);


}