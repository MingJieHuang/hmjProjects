package com.phone.erp.boss.vo.sales;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [批发战报Vo类]
 * @author hmj
 * @create 2018-08-27 15:32
 */
public class WholesaleReportVo extends BaseResultVo{
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
     * 均毛
     */
    private String goodsAvgProfitAmount;

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

    public String getGoodsAvgProfitAmount() {
        return goodsAvgProfitAmount;
    }

    public void setGoodsAvgProfitAmount(String goodsAvgProfitAmount) {
        this.goodsAvgProfitAmount = goodsAvgProfitAmount;
    }
}
