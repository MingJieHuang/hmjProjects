package com.phone.erp.boss.vo.retail;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [增值服务战报Vo类]
 * @author hmj
 * @create 2018-08-24 17:53
 */
public class ValueAddedReportVo extends BaseResultVo {
    /**
     * 数量
     */
    private Long goodsQuantity;
    /**
     * 实际收款
     */
    private String goodsAmount;
    /**
     * 均价
     */
    private String goodsPrice;

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

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
