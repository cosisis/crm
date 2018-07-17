package com.cosis.crm.cash.controller;

import com.cosis.crm.cash.annotation.CosisLog;
import com.cosis.crm.cash.domain.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import java.util.Date;

/**
 * 登录处理
 */
@Controller
@CosisLog(topic = "LoginController")
@RequestMapping("/crm/login")
public class LoginController {

    @GetMapping
    String doLogin(Model model,
                   @ModelAttribute UserInfo info){

        model.addAttribute("user",info);
        return "index";
    }

    @GetMapping("tologin")
    String toLogin(){
        return "login";
    }

}