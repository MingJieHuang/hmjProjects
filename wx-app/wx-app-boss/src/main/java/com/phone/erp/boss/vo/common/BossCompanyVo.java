package com.phone.erp.boss.vo.common;

import java.util.List;

import com.phone.erp.base.vo.company.CompanyVo;

/**
 * [Boss部门对象]
 * 
 * @author HMJ
 * @version [版本,2018-7-11]
 * @see
 */

public class BossCompanyVo extends CompanyVo {
	//公司id
	private Long companyId;
	// 对象类型

	private String nodeType = "Company";

	// 公司下部门集合
	private List<BossSectionVo> sectionList;

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public List<BossSectionVo> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<BossSectionVo> sectionList) {
		this.sectionList = sectionList;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	
}
