package com.phone.erp.boss.vo.storage;

/**
 * [串号流水表Vo]
 * @author HMJ
 * @version [版本,2018-7-19]
 * @see 
 */

public class ImeiTrackingDetailVo {

	/**
	 * 单据Id
	 */
	private Long billId;
	/**
	 * 单据类型
	 */
	private String billType;
	/**
	 * 单据类型编码
	 */
	private Integer billTypeCode;
	/**
	 * 单据编码
	 */
	private String billCode;
	/**
	 * 单据日期
	 */
	private String billDate;
	/**
	 * 部门名称
	 */
	private String sectionName;
	/**
	 * 仓库名称
	 */
	private String storageName;
	/**
	 * 操作人
	 */
	private String operatorName;
	/**
	 * 操作时间
	 */
	private String operationTime;
	/**
	 * 串号明细备注
	 */
	private String remark;
	/**
	 * 出入库类型
	 */
	private String inOutStockType;
	/**
	 * 串号id
	 */
	private Long imeiId;
	/**
	 * 金额
	 */
	private String goodsAmount;
	public Long getBillId() {
		return billId;
	}
	public void setBillId(Long billId) {
		this.billId = billId;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public Integer getBillTypeCode() {
		return billTypeCode;
	}
	public void setBillTypeCode(Integer billTypeCode) {
		this.billTypeCode = billTypeCode;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getStorageName() {
		return storageName;
	}
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}


	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getInOutStockType() {
		return inOutStockType;
	}
	public void setInOutStockType(String inOutStockType) {
		this.inOutStockType = inOutStockType;
	}
	public Long getImeiId() {
		return imeiId;
	}
	public void setImeiId(Long imeiId) {
		this.imeiId = imeiId;
	}
	public String getGoodsAmount() {
		return goodsAmount;
	}
	public void setGoodsAmount(String goodsAmount) {
		this.goodsAmount = goodsAmount;
	}
	
}
