package com.phone.erp.base.vo;

/**
 * [基础查询vo]
 *
 * @author Chris li
 * @version [版本, 2017-4-12]
 * @see
 */
public abstract class BaseQueryVo {
    /**
     * 集团id
     */
    private Long groupId;
    /**
     * 公司id
     */
    private Long companyId;
    /**
     * 查询关键字
     */
    private String queryKey;

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }

    public String getQueryKey() {
        return queryKey;
    }

}
