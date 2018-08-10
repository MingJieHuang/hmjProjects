package com.phone.erp.boss.vo.storage;

import com.phone.erp.base.vo.BaseResultVo;

/**
 * [商品仓库库存Vo]
 * @author HMJ
 * @version [版本,2018-7-12]
 * @see 
 */

public class StorageGoodsVo extends BaseResultVo {
	//对象类别
	private String nodeType="Storage";
	//所属部门id
	private Long sectionId;
	//商品数量
	private Long goodsQuantity;
	//均价
	private String goodsPrice;
	//金额
	private String goodsAmount;
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
	public Long getSectionId() {
		return sectionId;
	}
	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}
	
}
