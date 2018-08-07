package com.phone.erp.boss.vo.storage;

/**
 * [库存分布主页Vo]
 * @author HMJ
 * @version [版本,2018-7-12]
 * @see 
 */

public class StockDistributionVo {
	/**
	 * 商品id用于跳转到实时库存明细页面
	 */
	private Long goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品编码
	 */
	private String goodsCode;
	/**
	 * 商品配置
	 */
	private String goodsConfiguration;
	/**
	 * 商品数量
	 */
	private Long goodsQuantity;

	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
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
	public Long getGoodsQuantity() {
		return goodsQuantity;
	}
	public void setGoodsQuantity(Long goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}	
}
