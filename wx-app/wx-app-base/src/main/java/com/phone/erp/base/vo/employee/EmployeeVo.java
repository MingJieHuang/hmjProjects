package com.phone.erp.base.vo.employee;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [员工VO对象]
 *
 * @author Chris li
 * @version [版本, 2017-4-12]
 * @see
 */
public class EmployeeVo extends BaseResultVo {
    /**
     * 集团id
     */
    private Long groupId;
    /**
     * 集团名称
     */
    private String groupName;
    /**
     * 公司id
     */
    private Long companyId;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 部门id
     */
    private Long sectionId;
    /**
     * 部门名称
     */
    private String sectionName;
    /**
     * 状态
     */
    private Integer status;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
