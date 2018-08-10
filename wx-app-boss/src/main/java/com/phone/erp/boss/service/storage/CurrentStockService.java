package com.phone.erp.boss.service.storage;

import java.util.Map;

import com.phone.erp.base.Result;
import com.phone.erp.boss.service.ReportBaseService;
import com.phone.erp.boss.vo.common.BossQueryVo;


/**
 * [实时库存业务层]
 * @author HMJ
 * @version [版本,2018-7-12]
 * @see 
 */

public interface CurrentStockService extends ReportBaseService  {

/*	*//**
	 * [获取实时库存主页数据]
	 * @author hmj
	 * @version [版本,2018-7-12] 
	 *//*
	Result getCurrentStockData(BossQueryVo queryVo)throws Exception;

	*//**
	 * [获取实时库存主页总计行对象]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 * @throws Exception 
	 *//*
	Result getCurrentStockTotalVo(BossQueryVo queryVo) throws Exception;*/

	/**
	 * [获取实时库存详情页集合]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 * @param result 
	 * @param paramMap 
	 */
	Result getCurrentStockDetailData(BossQueryVo queryVo, Map<String, Object> paramMap, Result result)throws Exception;

	/**
	 * 获取商品详情对象
	 * @author hmj
	 * @param goodsId 商品id
	 * @version [版本,2018-7-13]
	 */
	Result getGoodsVo(Long goodsId);

	/**
	 * [获取实时库存详情页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-7-19] 
	 * @param result 
	 * @param paramMap 
	 */
	Result getCurrentStockDetailTotalVo(BossQueryVo queryVo, Map<String, Object> paramMap, Result result)throws Exception;

}
