package com.phone.erp.boss.vo.purchase;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [进销对比vo类]
 * @author hmj
 * @create 2018-08-18 16:44
 */
public class PurchaseSalesCompareVo extends BaseResultVo {
    /**
     * 销售数量
     */
    private Long salesQuantity;
    /**
     * 销售u金额
     */
    private String salesAmount;
    /**
     * 采购数量
     */
    private Long purchaseQuantity;
    /**
     * 采购金额
     */
    private String purchaseAmount;

    public Long getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(Long salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public String getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(String salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Long getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Long purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}
