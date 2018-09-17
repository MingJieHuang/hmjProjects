package com.phone.erp.boss.vo.retail;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [分期业务战报Vo类]
 * @author hmj
 * @create 2018-08-18 16:00
 */
public class InstallMentfeeVo extends BaseResultVo {
    /**
     *分期业务id
     */
    private Long installmentfeesId;

    /**
    *分期业务名称
    */
    private String installmentfeesName;

    /**
     *佣金预估
     */
    private String commissionEstimate;

    /**
     *贷款金额
     */
    private String tallymanLoanAmount;

    /**
     *佣金均价
     */
    private String commissionAvg;

    /**
     *数量
     */
    private Long goodsQuantity;

    public Long getInstallmentfeesId() {
        return installmentfeesId;
    }

    public void setInstallmentfeesId(Long installmentfeesId) {
        this.installmentfeesId = installmentfeesId;
    }

    public String getInstallmentfeesName() {
        return installmentfeesName;
    }

    public void setInstallmentfeesName(String installmentfeesName) {
        this.installmentfeesName = installmentfeesName;
    }

    public String getCommissionEstimate() {
        return commissionEstimate;
    }

    public void setCommissionEstimate(String commissionEstimate) {
        this.commissionEstimate = commissionEstimate;
    }

    public String getTallymanLoanAmount() {
        return tallymanLoanAmount;
    }

    public void setTallymanLoanAmount(String tallymanLoanAmount) {
        this.tallymanLoanAmount = tallymanLoanAmount;
    }

    public String getCommissionAvg() {
        return commissionAvg;
    }

    public void setCommissionAvg(String commissionAvg) {
        this.commissionAvg = commissionAvg;
    }

    public Long getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(Long goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }
}
