package com.phone.erp.boss.vo.sales;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [销售排行vo类]
 * @author hmj
 * @create 2018-08-18 13:49
 */
public class SalesRankingVo extends BaseResultVo{

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
}
