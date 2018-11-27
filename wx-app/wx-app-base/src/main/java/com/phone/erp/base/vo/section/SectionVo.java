package com.phone.erp.base.vo.section;

import com.phone.erp.base.vo.BaseResultVo;


/**
 * [部门对象]
 *
 * @author HMJ
 * @version [版本, 2018-7-10]
 * @see
 */

public class SectionVo extends BaseResultVo {
    /**
     * 状态[0:启用,1:禁用,2:删除]
     */
    private Integer status;
    /**
     * 公开库存量[1:公开,0:不公开]
     */
    private Integer kcflag;


    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getKcflag() {
        return kcflag;
    }

    public void setKcflag(Integer kcflag) {
        this.kcflag = kcflag;
    }

}
