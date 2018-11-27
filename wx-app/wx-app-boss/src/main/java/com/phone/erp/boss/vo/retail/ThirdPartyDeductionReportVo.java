package com.phone.erp.boss.vo.retail;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [第三方抵扣战报vo类]
 * @author hmj
 * @create 2018-08-24 16:28
 */
public class ThirdPartyDeductionReportVo extends BaseResultVo {
    /**
     * 抵扣单位id
     */
    private Long contactunitId;
    /**
     * 抵扣单位编码
     */
    private String contactunitCode;
    /**
     * 抵扣单位名称
     */
    private String contactunitName;
    /**
     * 数量
     */
    private Long goodsQuantity;
    /**
     * 抵扣金额
     */
    private String goodsAmount;
    /**
     * 抵扣均价
     */
    private String goodsPrice;

    public Long getContactunitId() {
        return contactunitId;
    }

    public void setContactunitId(Long contactunitId) {
        this.contactunitId = contactunitId;
    }

    public String getContactunitCode() {
        return contactunitCode;
    }

    public void setContactunitCode(String contactunitCode) {
        this.contactunitCode = contactunitCode;
    }

    public String getContactunitName() {
        return contactunitName;
    }

    public void setContactunitName(String contactunitName) {
        this.contactunitName = contactunitName;
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
