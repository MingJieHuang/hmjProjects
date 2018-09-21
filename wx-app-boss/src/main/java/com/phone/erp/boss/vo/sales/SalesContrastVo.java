package com.phone.erp.boss.vo.sales;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [销售对比Vo类]
 * @author hmj
 * @create 2018-08-27 16:05
 */
public class SalesContrastVo {
    /**
    *日期
    */
    private String billsDate;

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

    public String getBillsDate() {
        return billsDate;
    }

    public void setBillsDate(String billsDate) {
        this.billsDate = billsDate;
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

    public String getGoodsProfitAmount() {
        return goodsProfitAmount;
    }

    public void setGoodsProfitAmount(String goodsProfitAmount) {
        this.goodsProfitAmount = goodsProfitAmount;
    }
}
