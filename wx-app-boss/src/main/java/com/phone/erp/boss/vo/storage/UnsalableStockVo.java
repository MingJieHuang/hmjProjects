package com.phone.erp.boss.vo.storage;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [滞销库存vo类]
 * @author hmj
 * @create 2018-08-24 15:07
 */
public class UnsalableStockVo extends BaseResultVo {
    /**
    *配置
    */
    private String goodsConfiguration;
    
    /**
    *串号类型:single和double
    */
    private String imeiType;
    
    /**
    *主串号
    */
    private String imei;
    
    /**
    *辅助串号
    */
    private String auxiliaryImei;
    /**
     * 库龄天数
     */
    private Long stockAge;
    /**
     * 商品数量
     */
    private Long goodsQuantity;
    /**
     * 金额
     */
    private String goodsAmount;

    public String getGoodsConfiguration() {
        return goodsConfiguration;
    }

    public void setGoodsConfiguration(String goodsConfiguration) {
        this.goodsConfiguration = goodsConfiguration;
    }

    public String getImeiType() {
        return imeiType;
    }

    public void setImeiType(String imeiType) {
        this.imeiType = imeiType;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAuxiliaryImei() {
        return auxiliaryImei;
    }

    public void setAuxiliaryImei(String auxiliaryImei) {
        this.auxiliaryImei = auxiliaryImei;
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

    public Long getStockAge() {
        return stockAge;
    }

    public void setStockAge(Long stockAge) {
        this.stockAge = stockAge;
    }
}
