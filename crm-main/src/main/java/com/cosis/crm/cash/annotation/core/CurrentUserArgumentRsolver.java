package com.cosis.crm.cash.annotation.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author cosis
 * 登录校验自定义参数
 * 使用方法参考ForTestController中的testuser
 */
@Slf4j
public class CurrentUserArgumentRsolver implements HandlerMethodArgumentResolver {
	
	@Override
	public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer container, NativeWebRequest req, WebDataBinderFactory factory) throws Exception {
		HttpServletRequest request = req.getNativeRequest(HttpServletRequest.class);

//		String openId = LoginInUtils.getOpenId(request);
//		String wechatId = LoginInUtils.getWechatId(request);
//
//		if(openId==null || wechatId==null) {
//			log.info(">>> CurrentUserArgumentRsolver error, params is null");
//			return null;
//		}
//
//		LoginService loginService = SpringContextHolder.getBean("loginService");
//		return loginService.queryCustomerByOpenIdAndWechatId(openId, wechatId);
		return null;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return true;
	}

}
