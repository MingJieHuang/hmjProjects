package com.phone.erp.boss.vo.purchase;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [采购汇总Vo类]
 * @author HMJ
 * @version [版本,2018-7-17]
 * @see 
 */

public class PurchaseCollectVo extends BaseResultVo {
	/**
	 * 数量
	 */
	private Long goodsQuantity;
	/**
	 * 金额
	 */
	private String goodsAmount;
	/**
	 * 均价
	 */
	private String goodsPrice;
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
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
}
