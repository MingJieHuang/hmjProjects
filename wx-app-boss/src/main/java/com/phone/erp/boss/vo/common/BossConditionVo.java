package com.phone.erp.boss.vo.common;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [bass小程序组件vo类]
 * @author hmj
 * @create 2018-08-22 16:09
 */
public class BossConditionVo extends BaseResultVo{
/**
*第三方抵扣单位名称
*/
private String deductionUnitName;

    public String getDeductionUnitName() {
        return deductionUnitName;
    }

    public void setDeductionUnitName(String deductionUnitName) {
        this.deductionUnitName = deductionUnitName;
    }
}
