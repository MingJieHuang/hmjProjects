package com.phone.erp.boss.vo.storage;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [周转率分析]
 * @author hmj
 * @create 2018-08-27 16:59
 */
public class TurnOverRateVo extends BaseResultVo {
    /**
    *周转率
    */
    private String turnroundRate;
    
    /**
    *排名
    */
    private Long ranking;

    public String getTurnroundRate() {
        return turnroundRate;
    }

    public void setTurnroundRate(String turnroundRate) {
        this.turnroundRate = turnroundRate;
    }

    public Long getRanking() {
        return ranking;
    }

    public void setRanking(Long ranking) {
        this.ranking = ranking;
    }
}
