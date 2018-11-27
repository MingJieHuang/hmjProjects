package com.phone.erp.base.controller;

import com.phone.erp.base.Constants;
import com.phone.erp.base.config.DevModelConfig;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.enums.MiniApp;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import org.apache.commons.lang3.StringUtils;
import org.chrisli.utils.json.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * [Controller的基类,提供公用方法]
 * 
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@Component
public class BaseController {

	@Autowired
	private DevModelConfig devModelConfig;

	/**
	 * [获取当前访问接口的小程序]
	 * 
	 * @author Chris li[黎超]
	 * @version [版本, 2017-04-12]
	 */
	protected MiniApp getCurrentMiniApp() {
		if (devModelConfig.isDevModel()) {
			// 开发模式下,直接返回开发模式默认的员工对象
			return MiniApp.getMatchedInstance(devModelConfig.getDevModelEmployeeVo().getLoginMiniAppCode());
		}
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		// 从header中获取miniAppCode
		String miniAppCode = request.getHeader(Constants.MINI_APP_CODE_KEY);
		// 如果header中不存在miniAppCode，则从参数中获取miniAppCode
		if (StringUtils.isBlank(miniAppCode)) {
			miniAppCode = request.getParameter(Constants.MINI_APP_CODE_KEY);
		}
		// miniAppCode为空
		Assert.notBlank(miniAppCode, ErrorCode.MINI_APP_CODE_MISSING);
		return MiniApp.getMatchedInstance(miniAppCode);
	}

	/**
	 * [获取当前登录微信小程序用户的(ERP)账号]
	 * 
	 * @author Chris li[黎超]
	 * @version [版本, 2017-04-12]
	 */
	protected LoginEmployeeVo getCurrentEmployeeVo() {
		if (devModelConfig.isDevModel()) {
			// 开发模式下,直接返回开发模式默认的员工对象
			return devModelConfig.getDevModelEmployeeVo();
		}
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return JsonUtil.jsonToBean(request.getAttribute(Constants.TOKEN_CLAIM_CUR_EMP_KEY).toString(), LoginEmployeeVo.class);
	}
}
