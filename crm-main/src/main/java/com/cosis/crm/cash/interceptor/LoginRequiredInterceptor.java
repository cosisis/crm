package com.cosis.crm.cash.interceptor;


import com.cosis.crm.cash.annotation.LoginRequired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author cosis
 * 校验登录用户拦截
 * 使用方法参考ForTestController中的testuser
 */
@Slf4j
//@Configuration
public class LoginRequiredInterceptor extends WebMvcConfigurerAdapter {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        HandlerInterceptor handlerItp = new HandlerInterceptor(){
            @Override
            public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception{
                if (!(handler instanceof HandlerMethod)) {
                    return true;
                }

                HandlerMethod handlerMethod = (HandlerMethod) handler;
                Method method = handlerMethod.getMethod();

                LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
                //如果没有该注解直接返回
                if(methodAnnotation == null){
                    return true;
                }

               return true;
            }

            @Override
            public void postHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3, ModelAndView var4) throws Exception{}

            @Override
            public void afterCompletion(HttpServletRequest var1, HttpServletResponse var2, Object var3, Exception var4) throws Exception{}

        };
       // registry.addInterceptor(handlerItp).addPathPatterns("/**");
    }
}