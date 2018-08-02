package com.phone.erp.boss.vo.sales;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [我的销量主页Vo对象]
 * @author HMJ
 * @version [版本,2018-7-17]
 * @see 
 */

public class MySalesVo extends BaseResultVo {

	/**
	 * nodeType:对象类型
	 */
	private String nodeType;
	/**
	 * 数量
	 */
	private Long goodsQuantity;
	/**
	 * 金额
	 */
	private String goodsAmount;
	/**
	 * 毛利
	 */
	private String goodsProfitAmount;
	/**
	 * 均毛
	 */
	private String goodsAvgProfitAmount;
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public Long getGoodsQuantity() {
		return goodsQuantity;
	}
	public void setGoodsQuantity(Long goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}
	public String getGoodsAmount() {
		return goodsAmount;
	}
	public void setGoodsAmount(String goodsAmount) {
		this.goodsAmount = goodsAmount;
	}
	public String getGoodsProfitAmount() {
		return goodsProfitAmount;
	}
	public void setGoodsProfitAmount(String goodsProfitAmount) {
		this.goodsProfitAmount = goodsProfitAmount;
	}
	public String getGoodsAvgProfitAmount() {
		return goodsAvgProfitAmount;
	}
	public void setGoodsAvgProfitAmount(String goodsAvgProfitAmount) {
		this.goodsAvgProfitAmount = goodsAvgProfitAmount;
	}
}
