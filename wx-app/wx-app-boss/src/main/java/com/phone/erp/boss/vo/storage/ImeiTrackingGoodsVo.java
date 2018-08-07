package com.phone.erp.boss.vo.storage;

/**
 * [串号跟踪流水表商品Vo]
 * @author HMJ
 * @version [版本,2018-7-19]
 * @see 
 */

public class ImeiTrackingGoodsVo {
	/**
	 * 操作时间
	 */
	private String operationTime;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 串号Id
	 */
	private Long imeiId;
	/**
	 * 主串号
	 */
	private String imei;
	/**
	 * 辅助串号
	 */
	private String auxiliaryImei;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品编码
	 */
	private String goodsCode;
	/**
	 * 配置
	 */
	private String goodsConfiguration;
	/**
	 * 状态码
	 */
	private Integer statusCode;
	/**
	 * 串号状态
	 */
	private String nowStatus;
	/**
	 * 最终成本
	 */
	private String goodsCostAmount;
	public String getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getImeiId() {
		return imeiId;
	}
	public void setImeiId(Long imeiId) {
		this.imeiId = imeiId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsConfiguration() {
		return goodsConfiguration;
	}
	public void setGoodsConfiguration(String goodsConfiguration) {
		this.goodsConfiguration = goodsConfiguration;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		if (statusCode==1) {
			setNowStatus("在库中");
		}else if(statusCode==2){
			setNowStatus("在途");
		}else if(statusCode==0){
			setNowStatus("已出库");
		}else if(statusCode==-1){
			setNowStatus("受托、委托");
		}else{
			setNowStatus("");
		}
		this.statusCode = statusCode;
	}
	public String getNowStatus() {
		return nowStatus;
	}
	public void setNowStatus(String nowStatus) {
		this.nowStatus = nowStatus;
	}
	public String getGoodsCostAmount() {
		return goodsCostAmount;
	}
	public void setGoodsCostAmount(String goodsCostAmount) {
		this.goodsCostAmount = goodsCostAmount;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getAuxiliaryImei() {
		return auxiliaryImei;
	}
	public void setAuxiliaryImei(String auxiliaryImei) {
		this.auxiliaryImei = auxiliaryImei;
	}
	
}
