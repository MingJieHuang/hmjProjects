package com.phone.erp.boss.vo.contact;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [营业款Vo类]
 * @author hmj
 * @create 2018-08-27 11:52
 */
public class RetailPayVo extends BaseResultVo {
    /**
     * 本日收入
     */
    private String todayIncome;

    /**
     * 本日支出
     */
    private String todayPay;

    /**
     * 前日结余
     */
    private String yestodayBalance;

    /**
     * 未确认金额
     */
    private String unconfirmedAmount;

    /**
     * 应交金额
     */
    private String payAmount;

    /**
     * 今日缴款
     */
    private String todayPayAmount;

    /**
     * 缴款结余
     */
    private String payBalance;

    public String getTodayIncome() {
        return todayIncome;
    }

    public void setTodayIncome(String todayIncome) {
        this.todayIncome = todayIncome;
    }

    public String getTodayPay() {
        return todayPay;
    }

    public void setTodayPay(String todayPay) {
        this.todayPay = todayPay;
    }

    public String getYestodayBalance() {
        return yestodayBalance;
    }

    public void setYestodayBalance(String yestodayBalance) {
        this.yestodayBalance = yestodayBalance;
    }

    public String getUnconfirmedAmount() {
        return unconfirmedAmount;
    }

    public void setUnconfirmedAmount(String unconfirmedAmount) {
        this.unconfirmedAmount = unconfirmedAmount;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getTodayPayAmount() {
        return todayPayAmount;
    }

    public void setTodayPayAmount(String todayPayAmount) {
        this.todayPayAmount = todayPayAmount;
    }

    public String getPayBalance() {
        return payBalance;
    }

    public void setPayBalance(String payBalance) {
        this.payBalance = payBalance;
    }
}
