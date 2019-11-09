package com.cosis.crm.cash.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 支持跨域访问
 * @author cosis
 */
@Slf4j
//@Configuration
public class AccessControlInterceptor extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        log.info(">>> AccessControlInterceptor in <<<<<<<<");

        HandlerInterceptor handlerItp = new HandlerInterceptor(){
            @Override
            public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Exception{
                resp.setHeader("Access-Control-Allow-Origin", "*");
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3, ModelAndView var4) throws Exception{}

            @Override
            public void afterCompletion(HttpServletRequest var1, HttpServletResponse var2, Object var3, Exception var4) throws Exception{}

        };
        //registry.addInterceptor(handlerItp).addPathPatterns("/**");
    }

}