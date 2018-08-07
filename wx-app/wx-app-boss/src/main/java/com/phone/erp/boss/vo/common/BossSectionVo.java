package com.phone.erp.boss.vo.common;

import com.phone.erp.base.vo.section.SectionVo;

/**
 * [Boss公司对象]
 * @author HMJ
 * @version [版本,2018-7-11]
 * @see 
 */

public class BossSectionVo extends SectionVo {
	//公司id
	private Long companyId;
	//对象类型
	private String nodeType="Section";
	
	//部门路径[体现层级关系]
	private String sectionPath;
	//父id
	private Long pid;

	public String getSectionPath() {
		return sectionPath;
	}

	public void setSectionPath(String sectionPath) {
		this.sectionPath = sectionPath;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
}
