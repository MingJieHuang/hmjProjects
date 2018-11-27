package com.phone.erp.websocket.vo.retail;

/**
 * [零售单据VO]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class RetailOrderVo {
    /**
     * 单据id
     */
    private Long id;
    /**
     * 单据编号
     */
    private String billsCode;
    /**
     * 聚合收款金额
     */
    private Double unionPayAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillsCode() {
        return billsCode;
    }

    public void setBillsCode(String billsCode) {
        this.billsCode = billsCode;
    }

    public void setUnionPayAmount(Double unionPayAmount) {
        this.unionPayAmount = unionPayAmount;
    }

    public Double getUnionPayAmount() {
        return unionPayAmount;
    }
}
