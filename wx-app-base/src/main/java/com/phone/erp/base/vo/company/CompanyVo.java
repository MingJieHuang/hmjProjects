package com.phone.erp.base.vo.company;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [公司VO对象]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class CompanyVo extends BaseResultVo {
    /**
     * 状态
     */
    private Integer status;

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
