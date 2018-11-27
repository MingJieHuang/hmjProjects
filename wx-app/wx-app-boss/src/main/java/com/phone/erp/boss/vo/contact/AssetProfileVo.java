package com.phone.erp.boss.vo.contact;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [资产概要Vo类]
 * @author hmj
 * @create 2018-08-27 11:11
 */
public class AssetProfileVo {
    /**
    *名称
    */
    private String name;
    
    /**
    *金额
    */
    private String goodsAmount;
    
    /**
    *金额占比
    */
    private String goodsAmountRatio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.replace("a_receivableAmount","应收")
        .replace("b_payableAmount","应付")
        .replace("c_preReceivment","预收")
        .replace("d_prePayment","预付")
        .replace("d_prePayment","预付")
        .replace("e_qtAmount","资金")
        .replace("f_kcAmount","库存成本(含在途)");
    }

    public String getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(String goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public String getGoodsAmountRatio() {
        return goodsAmountRatio;
    }

    public void setGoodsAmountRatio(String goodsAmountRatio) {
        this.goodsAmountRatio = goodsAmountRatio;
    }
}
