package com.cosis.crm.cash.controller;

import com.cosis.crm.cash.annotation.CosisLog;
import com.cosis.crm.cash.domain.entity.UserInfo;
import com.cosis.crm.cash.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


/**
 * 登录处理
 */
@Slf4j
@CosisLog(topic = "LoginController")
@Controller
@RequestMapping("/crm/login")
public class LoginController {


    @Resource
    UserService service;


    @GetMapping("doLogin")
    String doLogin(Model model,
                   @ModelAttribute UserInfo info){
        UserInfo user = service.query(info.getUsercode(),info.getPassword());
        log.info("doLogin usercode : {}, password: {}" , info.getUsercode(), info.getPassword());
        if(user!=null) {
            model.addAttribute("user", user);
            return "index";
        }else{
            return "error";
        }
    }

    @GetMapping("tologin")
    String toLogin(){
        return "login";
    }



}