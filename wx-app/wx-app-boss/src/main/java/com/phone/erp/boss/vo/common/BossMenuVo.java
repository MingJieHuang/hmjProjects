package com.phone.erp.boss.vo.common;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [Boss小程序菜单Vo]
 * @author HMJ
 * @version [版本,2018-7-10]
 * @see 
 */

public class BossMenuVo extends BaseResultVo {
	//状态0:启用,1禁用
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) { 
		this.status = status;
	}
}
