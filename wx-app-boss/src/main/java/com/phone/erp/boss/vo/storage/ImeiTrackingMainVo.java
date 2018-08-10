package com.phone.erp.boss.vo.storage;

/**
 * [串号跟踪主表Vo类]
 * @author HMJ
 * @version [版本,2018-7-19]
 * @see 
 */

public class ImeiTrackingMainVo {
	/**
	 * 串号主键
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
	 * 串号状态
	 */
	private String nowStatus;
	/**
	 * 状态码
	 */
	private Integer statusCode;
	public Long getImeiId() {
		return imeiId;
	}
	public void setImeiId(Long imeiId) {
		this.imeiId = imeiId;
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
	public String getNowStatus() {
		return nowStatus;
	}
	public void setNowStatus(String nowStatus) {
		this.nowStatus = nowStatus;
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
}
