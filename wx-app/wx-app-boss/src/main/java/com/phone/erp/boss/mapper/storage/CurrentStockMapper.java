package com.phone.erp.boss.mapper.storage;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.phone.erp.boss.mapper.ReportBaseMapper;
import com.phone.erp.boss.vo.common.GoodsVo;
import com.phone.erp.boss.vo.storage.GoodsSumVo;
import com.phone.erp.boss.vo.storage.SectionGoodsVo;
import com.phone.erp.boss.vo.storage.StorageGoodsVo;

/**
 * [实时库存Mapper]
 * @author HMJ
 * @version [版本,2018-7-12]
 * @see 
 */

@SuppressWarnings("unchecked")
public interface CurrentStockMapper extends ReportBaseMapper{

/*	*//**
	 * [获取实时库存主页数据]
	 * @author hmj
	 * @version [版本,2018-7-12] 
	 *//*
	Page<CurrentStockVo> getCurrentStockData(Map<String, Object> map);

	*//**
	 * [获取实时库存主页总计行]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 *//*
	CurrentStockVo getCurrentStockTotal(Map<String, Object> map);*/

	/**
	 * [获取实时库存分布详情页(部门)集合(分页)]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 */
	Page<SectionGoodsVo> getCurrentStockDetailSectionData(Map<String, Object> map);

	/**
	 * [获取实时库存分布详情页(仓库)集合不分页]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 */
	List<StorageGoodsVo> getCurrentStockDetailStorageData(
			Map<String, Object> map);

	/**
	 * [获取商品合计对象]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 */
	GoodsSumVo getGoodsSumVo(Map<String, Object> map);

	/**
	 * [获取商品详情对象]
	 * @author hmj
	 * @version [版本,2018-7-16] 
	 */
	GoodsVo getGoodsVo(Long goodsId);

}
