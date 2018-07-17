package com.cosis.crm.cash.controller;

import com.cosis.crm.cash.domain.entity.IncomeType;
import com.cosis.crm.cash.domain.entity.UserInfo;
import com.cosis.crm.cash.service.IncomeTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 收入类别处理
 */
@Slf4j
@Controller
@RequestMapping("/crm/incomeType")
public class IncomeTypeController {

    @Autowired
    IncomeTypeService service;

    @GetMapping("save")
    String save(Model model, int id,String type_name ){
        log.info(" id : {}, typename: {}" , id, type_name);

        System.out.println("IncomeTypeController.save");
        IncomeType type = new IncomeType();
        type.setId(id);
        type.setType_name(type_name);
        service.add(type);
        return query(model);
    }

    /**
     * 查询已添加的类型列表
     * @param model
     * @return
     */
    @GetMapping("query")
    String query(Model model){
        List<IncomeType> list = service.query();
        model.addAttribute("list",list);
        return "incomeType/incomeTypeManager";
    }
}