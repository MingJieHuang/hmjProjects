package com.phone.erp.boss.vo.storage;

/**
 * [今日调拨Vo类]
 * @author hmj
 * @create 2018-08-27 13:51
 */
public class TodayAllotVo {

    /**
    *单据编号
    */
    private String billCode;

    /**
    *单据状态
    */
    private String billStatus;

    /**
    *调入部门
    */
    private String inSectionName;

    /**
    *调出部门
    */
    private String outSectionName;
    /**
    *商品名称
    */
    private String goodsName;

    /**
    *操作人姓名
    */
    private String postMan;

    /**
    *操作时间
    */
    private String postTime;
    /**
    *数量
    */
    private Long goodsQuantity;



    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getInSectionName() {
        return inSectionName;
    }

    public void setInSectionName(String inSectionName) {
        this.inSectionName = inSectionName;
    }

    public String getOutSectionName() {
        return outSectionName;
    }

    public void setOutSectionName(String outSectionName) {
        this.outSectionName = outSectionName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPostMan() {
        return postMan;
    }

    public void setPostMan(String postMan) {
        this.postMan = postMan;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Long getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(Long goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }
}
