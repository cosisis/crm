package com.cosis.crm.cash.controller;

import com.cosis.crm.cash.annotation.LoginRequired;
import com.cosis.crm.cash.domain.ReturnVal;
import com.cosis.crm.cash.domain.entity.IncomeInfo;
import com.cosis.crm.cash.service.IncomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;


/**
 * 收入处理
 */
@Slf4j
@Controller
@RequestMapping("/crm/icm")
public class IncomeController {

    @Autowired
    IncomeService service;

        //@LoginRequired
//        @ResponseBody
//        @GetMapping("add")
//        public ReturnVal add(@RequestParam(value="income_type")int incomeType,
//                             @RequestParam(value="income_name")String incomename,
//                             @RequestParam(value="principal")BigDecimal principal,   //本金
//                             @RequestParam(value="rate") BigDecimal rate,             //年率
//                             @RequestParam(value="profit")BigDecimal profit,         //收益
//                             @RequestParam(value="begin_date")int begindate,    //存款日
//                             @RequestParam(value="value_date")int valuedate,    //计息日
//                             @RequestParam(value="day_nums")int daynums  ){       //天数
//
//            IncomeInfo info = new IncomeInfo();
//            info.setIncome_name(incomename);
//            info.setIncome_type(incomeType);
//            info.setPrincipal(principal);
//            info.setRate(rate);
//            info.setDay_nums(daynums);
//            info.setBegin_date(begindate);
//            info.setValue_date(valuedate);
//        }

        //@LoginRequired
//        @GetMapping("list")
//        public String list(){
//
//        }

}