package com.phone.erp.boss.mapper.purchase;

import java.util.Map;

import com.github.pagehelper.Page;
import com.phone.erp.boss.vo.purchase.PurchaseCollectVo;

/**
 * [采购汇总Mapper]
 * @author HMJ
 * @version [版本,2018-7-17]
 * @see 
 */

public interface PurchaseCollectMapper {

	/**
	 * [采购汇总主页分页集合]
	 * @author HMJ
	 * @version [版本,2018-7-17] 
	 */
	Page<PurchaseCollectVo> getPurchaseCollectData(Map<String, Object> map);

	/**
	 * [获取采购汇总总计行对象]
	 * @author HMJ
	 * @version [版本,2018-7-17] 
	 */
	PurchaseCollectVo getPurchaseCollectTotalVo(Map<String, Object> map);

}
