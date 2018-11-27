package com.phone.erp.boss.vo.storage;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [商品合计Vo]
 * @author HMJ
 * @version [版本,2018-7-13]
 * @see 
 */

public class GoodsSumVo extends BaseResultVo{
	//商品数量
	private Long goodsQuantity;
	//均价
	private String goodsPrice;
	//金额
	private String goodsAmount;
	public Long getGoodsQuantity() {
		return goodsQuantity;
	}
	public void setGoodsQuantity(Long goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsAmount() {
		return goodsAmount;
	}
	public void setGoodsAmount(String goodsAmount) {
		this.goodsAmount = goodsAmount;
	}
}
