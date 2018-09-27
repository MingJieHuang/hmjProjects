package com.phone.erp.boss.vo.sales;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [销售占比vo类]
 * @author hmj
 * @create 2018-08-27 16:35
 */
public class SalesProportionVo extends BaseResultVo {
    /**
     * 数量
     */
    private Long goodsQuantity;
    /**
     * 金额
     */
    private String goodsAmount;
    /**
     * 毛利
     */
    private String goodsProfitAmount;
    /**
     * 数量占比
     */
    private String goodsQuantityRatio;
    /**
     * 金额占比
     */
    private String goodsAmountRatio;
    /**
     * 毛利占比
     */
    private String goodsProfitAmountRatio;

    public Long getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(Long goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public String getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(String goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public String getGoodsProfitAmount() {
        return goodsProfitAmount;
    }

    public void setGoodsProfitAmount(String goodsProfitAmount) {
        this.goodsProfitAmount = goodsProfitAmount;
    }

    public String getGoodsQuantityRatio() {
        return goodsQuantityRatio;
    }

    public void setGoodsQuantityRatio(String goodsQuantityRatio) {
        this.goodsQuantityRatio = goodsQuantityRatio;
    }

    public String getGoodsAmountRatio() {
        return goodsAmountRatio;
    }

    public void setGoodsAmountRatio(String goodsAmountRatio) {
        this.goodsAmountRatio = goodsAmountRatio;
    }

    public String getGoodsProfitAmountRatio() {
        return goodsProfitAmountRatio;
    }

    public void setGoodsProfitAmountRatio(String goodsProfitAmountRatio) {
        this.goodsProfitAmountRatio = goodsProfitAmountRatio;
    }
}
