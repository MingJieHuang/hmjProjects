package com.phone.erp.boss.vo.contact;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [我的资金vo类]
 * @author hmj
 * @create 2018-08-18 17:05
 */
public class MyMoneyVo extends BaseResultVo{
    /**
    *资金账户类型
    */
    private String accountType;
    /**
    *今日收入
    */
    private String todayIncomeAmount;
    /**
    *今日支出
    */
    private String todayPayAmount;
    /**
    *余额
    */
    private String balance;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getTodayIncomeAmount() {
        return todayIncomeAmount;
    }

    public void setTodayIncomeAmount(String todayIncomeAmount) {
        this.todayIncomeAmount = todayIncomeAmount;
    }

    public String getTodayPayAmount() {
        return todayPayAmount;
    }

    public void setTodayPayAmount(String todayPayAmount) {
        this.todayPayAmount = todayPayAmount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
