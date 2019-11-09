package com.cosis.crm.cash.controller;

import com.cosis.crm.cash.domain.Result;
import com.cosis.crm.cash.domain.ReturnVal;
import com.cosis.crm.cash.domain.entity.IncomeInfo;
import com.cosis.crm.cash.domain.entity.IncomeType;
import com.cosis.crm.cash.service.IncomeService;
import com.cosis.crm.cash.service.IncomeTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Slf4j(topic = "IncomeController")
@Controller
@RequestMapping("/crm/icm")
public class IncomeController {

    @Resource
    IncomeService service;
    @Resource
    IncomeTypeService typeService;


        /* @LoginRequired
        @GetMapping("list")
        public String list(){

        }*/


    @GetMapping("toAdd")
    String toAdd(Model model){
        List<IncomeType> typeList =  typeService.query();
        model.addAttribute("list",typeList);

        return "incomeType/add";
    }


    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    ReturnVal save(@RequestParam(value = "income_type") int incomeType,// 理财类型
                           @RequestParam(value = "principal") BigDecimal principal,   //本金
                           @RequestParam(value = "rate") BigDecimal rate,             //年率
                           @RequestParam(value = "profit") BigDecimal profit,         //收益
                           @RequestParam(value = "begin_date") int begindate,    //存款日
                           @RequestParam(value = "value_date") int valuedate,    //计息日
                           @RequestParam(value = "user_id") String user_id,    //投资人
                           @RequestParam(value = "day_nums") int daynums){       //天数
        IncomeController.log.info("save income_type : {}, principal: {}" , incomeType, principal);
        //理财信息
        IncomeInfo info = new IncomeInfo();
        info.setIncome_type(incomeType);//理财类型
        info.setPrincipal(principal);//本金
        info.setProfit(profit);//收益
        info.setRate(rate);//利率
        info.setBegin_date(begindate);//存款日
        info.setValue_date(valuedate);//计息日
        info.setDay_nums(daynums);//天数
        info.setCreate_time(new Date());
        info.setUser_id(user_id);
        IncomeController.log.info("info.getIncome_type:{},info.getPrincipal:{},info.getRate:{},info.getProfit:{},info.getBegin_date:{}",info.getIncome_type(),info.getPrincipal(),info.getRate(),info.getProfit(),info.getBegin_date());
        Result result = service.add(info);

        return  ReturnVal.neutralResult(result.getRetEnum(), result.getRetEnum().getText());
    }
}