package com.phone.erp.boss.vo.storage;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [库存占比Vo类]
 * @author hmj
 * @create 2018-08-24 14:17
 */
public class StockRatioVo extends BaseResultVo {
    /**
     * 名称
     */
    private String name;
    //商品数量
    private Long goodsQuantity;
    //金额
    private String goodsAmount;
    //商品占比
    private String goodsQuantityRatio;
    //金额占比
    private String goodsAmountRatio;

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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name.replace("other","其他");
    }
}
