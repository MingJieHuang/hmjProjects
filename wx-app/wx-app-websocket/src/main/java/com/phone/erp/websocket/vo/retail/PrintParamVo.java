package com.phone.erp.websocket.vo.retail;

/**
 * [打印参数对象]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class PrintParamVo {
    /**
     * 部门id
     */
    private Long sectionId;
    /**
     * 打印电脑编码(CPU序列号+主硬盘序列号+主网卡MAC地址)
     */
    private String computerCode;
    /**
     * 打印机索引
     */
    private String printerIndex;
    /**
     * 打印机名称
     */
    private String printerName;
    /**
     * 打印纸张模式
     */
    private String paperType;
    /**
     * 状态(0,启用;1,禁用)
     */
    private Integer status;

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getComputerCode() {
        return computerCode;
    }

    public void setComputerCode(String computerCode) {
        this.computerCode = computerCode;
    }

    public String getPrinterIndex() {
        return printerIndex;
    }

    public void setPrinterIndex(String printerIndex) {
        this.printerIndex = printerIndex;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

}
