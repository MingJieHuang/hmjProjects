package com.phone.erp.boss.vo.common;


/**
 * [商品详情Vo]
 * @author HMJ
 * @version [版本,2018-7-12]
 * @see 
 */

public class GoodsVo {
	/**
	 * 商品Id
	 */
	private Long goodsId;
	/**
	 * 品牌
	 */
	private String goodsBrand;
	/**
	 * 型号
	 */
	private String goodsModel;
	/**
	 * 颜色
	 */
	private String goodsColor;
	/**
	 * 配置
	 */
	private String goodsConfiguration;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品编码
	 */
	private String goodsCode;
	/**
	 * 商品备注
	 */
	private String goodsRemark;
	/**
	 * 一级类别
	 */
	private String firstGoodsClassName;
	/**
	 * 类别路径
	 */
	private String goodsClassPathName;
	public String getGoodsBrand() {
		return goodsBrand;
	}
	public void setGoodsBrand(String goodsBrand) {
		this.goodsBrand = goodsBrand;
	}
	public String getGoodsModel() {
		return goodsModel;
	}
	public void setGoodsModel(String goodsModel) {
		this.goodsModel = goodsModel;
	}
	public String getGoodsColor() {
		return goodsColor;
	}
	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}
	public String getGoodsConfiguration() {
		return goodsConfiguration;
	}
	public void setGoodsConfiguration(String goodsConfiguration) {
		this.goodsConfiguration = goodsConfiguration;
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
	public String getGoodsRemark() {
		return goodsRemark;
	}
	public void setGoodsRemark(String goodsRemark) {
		this.goodsRemark = goodsRemark;
	}
	public String getFirstGoodsClassName() {
		return firstGoodsClassName;
	}
	public void setFirstGoodsClassName(String firstGoodsClassName) {
		this.firstGoodsClassName = firstGoodsClassName;
	}
	public String getGoodsClassPathName() {
		return goodsClassPathName;
	}
	public void setGoodsClassPathName(String goodsClassPathName) {
		this.goodsClassPathName = goodsClassPathName;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	
}
