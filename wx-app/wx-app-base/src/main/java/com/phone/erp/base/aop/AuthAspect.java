package com.phone.erp.base.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.phone.erp.base.Constants;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.aop.base.BaseAspect;
import com.phone.erp.base.config.AppConfig;
import com.phone.erp.base.config.DevModelConfig;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.enums.MiniApp;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.utils.encrypt.JwtUtil;
import com.phone.erp.base.utils.json.JsonUtil;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;

/**
 * [权限切面]
 * 
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@Aspect
@Component
public class AuthAspect extends BaseAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DevModelConfig devModelConfig;

	@Autowired
	private AppConfig appConfig;

	@Pointcut("@annotation(com.phone.erp.base.annotation.AuthValidate) and @annotation(org.springframework.web.bind.annotation.RequestMapping) and execution(public * com.phone.erp..controller..*Controller.*(..))")
	public void authAspect() {

	}

	@Before("authAspect()")
	public void beforeMethod(JoinPoint joinPoint) {
		if (devModelConfig.isDevModel()) {
			// 开发模式无需验证用户登录,小程序编号合法性及用户权限等
			return;
		}
		// 从请求中获取当前登录人信息
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		// 从header中获取token
		String token = request.getHeader(Constants.LOGIN_TOKEN_KEY);
		// 如果header中不存在token，则从参数中获取token
		if (StringUtils.isBlank(token)) {
			token = request.getParameter(Constants.LOGIN_TOKEN_KEY);
		}
		// token为空,未登录,需微信小程序端自动登录
		Assert.notBlank(token, ErrorCode.NOT_LOGGED_IN);
		String currentEmployeeVoJson = JwtUtil.verifyToken(token, Constants.TOKEN_CLAIM_CUR_EMP_KEY);
		String currentMiniAppCode = JwtUtil.verifyToken(token, Constants.TOKEN_CLAIM_CUR_APP_KEY);
		// 验证小程序编号合法性
		MiniApp.getMatchedInstance(currentMiniAppCode);
		// 如果当前调用本代码的项目是公共服务项目,则任何小程序都能通过验证
		if (!appConfig.getMiniAppCode().equals(Constants.COMMON_SERVICE_CODE)) {
			Assert.isTrue(appConfig.getMiniAppCode().equals(currentMiniAppCode), ErrorCode.MINI_APP_CODE_ILLEGAL);
		}
		// 将当前用户JSON串放入请求中
		request.setAttribute(Constants.TOKEN_CLAIM_CUR_EMP_KEY, currentEmployeeVoJson);
		LoginEmployeeVo curEmp = JsonUtil.jsonToBean(currentEmployeeVoJson, LoginEmployeeVo.class);
		// 验证token和小程序编号是否匹配

		Method sourceMethod = getSourceMethod(joinPoint);
		AuthValidate validate = sourceMethod.getAnnotation(AuthValidate.class);
		// TODO 验证权限
		logger.debug(curEmp.toString());
		logger.debug(validate.toString());

	}

}
