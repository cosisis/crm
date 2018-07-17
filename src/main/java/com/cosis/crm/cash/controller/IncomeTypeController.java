package com.cosis.crm.cash.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cosis.crm.cash.domain.Result;
import com.cosis.crm.cash.domain.ReturnVal;
import com.cosis.crm.cash.domain.entity.IncomeType;
import com.cosis.crm.cash.domain.entity.UserInfo;
import com.cosis.crm.cash.enums.RetCodeEnum;
import com.cosis.crm.cash.service.IncomeTypeService;
import com.cosis.crm.cash.utils.CheckHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 收入类别处理
 */
@Slf4j(topic = "IncomeTypeController")
@Controller
@RequestMapping("/crm/incomeType")
public class IncomeTypeController {

    @Autowired
    CheckHelper checkHelper;

    @Resource
    IncomeTypeService service;

    @GetMapping("manager")
    String manager(){
        log.info(" manager ");
        return "incomeType/manager";
    }

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    ReturnVal save(Model model, @RequestParam(value="id") String id,  @RequestParam(value="type_name")  String type_name ){

        log.info("save id : {}, typename: {}" , id, type_name);

        if (checkHelper.checkEmpty(type_name)) {
            return ReturnVal.failedResult(RetCodeEnum.COMMON_ERROR_NULL_INCOMETYPE_TYPENAME);
        }

        IncomeType type = new IncomeType();
        if (!checkHelper.checkEmpty(id)) {
            type.setId(Integer.parseInt(id));
        }
        type.setType_name(type_name);
        Result result = service.save(type);
        log.info("result : {}", JSON.toJSONString(result));
        log.info("ReturnVal : {}", JSON.toJSONString(ReturnVal.neutralResult(result.getRetEnum(), result.getRetEnum().getText())));
        return ReturnVal.neutralResult(result.getRetEnum(), result.getRetEnum().getText());
    }

    /**
     * 查询已添加的类型列表
     * @param model
     * @return
     */
    @GetMapping("query")
    String query(Model model){
        log.info("query");
        List<IncomeType> list = service.query();
        model.addAttribute("list",list);
        return "incomeType/list";
    }


    @ResponseBody
    @RequestMapping(value = "del", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    ReturnVal del(Model model, @RequestParam(value="id") String id){
        log.info(" id : {}" , id);

        if (checkHelper.checkEmpty(id)) {
            return ReturnVal.failedResult(RetCodeEnum.COMMON_ERROR_NULL_INCOMETYPE_ID);
        }

        IncomeType type = new IncomeType();
        type.setId(Integer.parseInt(id));
        Result result = service.del(type);
        log.info("result : {}", JSON.toJSONString(result));
        log.info("ReturnVal : {}", JSON.toJSONString(ReturnVal.neutralResult(result.getRetEnum(), result.getRetEnum().getText())));
        return ReturnVal.neutralResult(result.getRetEnum(), result.getRetEnum().getText());
    }
}