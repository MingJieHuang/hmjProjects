package com.phone.erp.boss.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.phone.erp.base.Result;
import com.phone.erp.base.controller.BaseController;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import com.phone.erp.boss.service.impl.BossCommonServiceImpl;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [Boos小程序Controller的基类,提供公用方法]
 * 
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@Component
public class ReportBaseController extends BaseController {
	@Autowired
	private BossCommonServiceImpl bossCommonServiceImpl;
	
	/**
	 * [获取基本报表条件查询map]
	 * @author HMJ
	 * @version [版本,2018-8-6] 
	 */
	public Map<String, Object> getParamMap(BossQueryVo queryVo, Result result) throws Exception {
		//第一步验证访问权限和设置canSeeAmount(查看成本价权限)
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		return map;		
	}
	/**
	 * 
	 * [获取当前登录员工并设置到BossQueryVo中供报表查询使用]
	 * @author HMJ
	 * @version [版本,2018-8-6]
	 */
	public void  setCurrentEmp(BossQueryVo queryVo){
		LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
		Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
		queryVo.setEmployeeVo(currentEmployeeVo);
	}

}
