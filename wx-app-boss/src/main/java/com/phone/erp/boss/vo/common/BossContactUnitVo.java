package com.phone.erp.boss.vo.common;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [往来单位(供应商)Vo]
 * @author HMJ
 * @version [版本,2018-7-18]
 * @see 
 */

public class BossContactUnitVo extends BaseResultVo {
	/** 往来单位类别 **/
	private String contactUnitClassName;
	/** 所属公司 **/
	private String companyName;
	/** 所属区域 **/
	private String areaName;
	/** 联系人 **/
	private String linkMan;
	/** 联系方式 **/
	private String telephone;
	public String getContactUnitClassName() {
		return contactUnitClassName;
	}
	public void setContactUnitClassName(String contactUnitClassName) {
		this.contactUnitClassName = contactUnitClassName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
