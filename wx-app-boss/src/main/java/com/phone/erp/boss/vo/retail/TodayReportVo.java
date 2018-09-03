package com.phone.erp.boss.vo.retail;

import com.phone.erp.base.vo.BaseResultVo;

import java.util.List;

/**
 * [今日战报vo类]
 * @author hmj
 * @create 2018-08-18 17:36
 */
public class TodayReportVo extends BaseResultVo{
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
    /**
     * 营业员vo集合
     */
    private List<TodayReportSalesmanVo> salesManList;


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

    public List<TodayReportSalesmanVo> getSalesManList() {
        return salesManList;
    }

    public void setSalesManList(List<TodayReportSalesmanVo> salesManList) {
        this.salesManList = salesManList;
    }
}
