package com.phone.erp.boss.vo.purchase;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [今日采购vo类]
 * @author hmj
 * @create 2018-08-21 17:27
 */
public class TodayPurchaseVo extends BaseResultVo {

    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 数量
     */
    private Long goodsQuantity;
    /**
     * 金额
     */
    private String goodsAmount;
    /**
     * 均价
     */
    private String goodsPrice;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

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
