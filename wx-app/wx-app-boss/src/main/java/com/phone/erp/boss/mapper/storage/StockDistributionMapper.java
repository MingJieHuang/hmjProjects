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
 * [库存分布Mapper]
 * @author HMJ
 * @version [版本,2018-7-12]
 * @see 
 */

@SuppressWarnings("unchecked")
public interface StockDistributionMapper extends ReportBaseMapper{

/*	*//**
	 * [获取库存分布主页数据]
	 * @author hmj
	 * @version [版本,2018-7-12] 
	 *//*
	Page<StockDistributionVo> getStockDistrData(Map<String, Object> map);*/



	/**
	 * [获取库存分布分布详情页(部门)集合(分页)]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 */
	Page<SectionGoodsVo> getStockDistrDetailSectionData(Map<String, Object> map);

	/**
	 * [获取库存分布分布详情页(仓库)集合不分页]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 */
	List<StorageGoodsVo> getStockDistrDetailStorageData(
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
