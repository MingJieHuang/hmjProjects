package com.phone.erp.boss.vo.retail;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * 今日战报营业员Vo类
 * @author hmj
 * @create 2018-08-31 9:42
 */
public class TodayReportSalesmanVo extends BaseResultVo{
    /**
     * 数量
     */
    private Long salesmanGoodsQuantity;
    /**
     * 金额
     */
    private String salesmanGoodsAmount;
    /**
     * 毛利
     */
    private String salesmanGoodsProfitAmount;
    /**
     * 均毛
     */
    private String salesmanGoodsAvgProfitAmount;

    public Long getSalesmanGoodsQuantity() {
        return salesmanGoodsQuantity;
    }

    public void setSalesmanGoodsQuantity(Long salesmanGoodsQuantity) {
        this.salesmanGoodsQuantity = salesmanGoodsQuantity;
    }

    public String getSalesmanGoodsAmount() {
        return salesmanGoodsAmount;
    }

    public void setSalesmanGoodsAmount(String salesmanGoodsAmount) {
        this.salesmanGoodsAmount = salesmanGoodsAmount;
    }

    public String getSalesmanGoodsProfitAmount() {
        return salesmanGoodsProfitAmount;
    }

    public void setSalesmanGoodsProfitAmount(String salesmanGoodsProfitAmount) {
        this.salesmanGoodsProfitAmount = salesmanGoodsProfitAmount;
    }

    public String getSalesmanGoodsAvgProfitAmount() {
        return salesmanGoodsAvgProfitAmount;
    }

    public void setSalesmanGoodsAvgProfitAmount(String salesmanGoodsAvgProfitAmount) {
        this.salesmanGoodsAvgProfitAmount = salesmanGoodsAvgProfitAmount;
    }
}
