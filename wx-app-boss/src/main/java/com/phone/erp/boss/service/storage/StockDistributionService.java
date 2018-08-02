package com.phone.erp.boss.service.storage;

import com.phone.erp.base.Result;
import com.phone.erp.boss.vo.common.BossQueryVo;


/**
 * [库存分布业务层]
 * @author HMJ
 * @version [版本,2018-7-12]
 * @see 
 */

public interface StockDistributionService  {

	/**
	 * [获取库存分布主页数据]
	 * @author hmj
	 * @version [版本,2018-7-12] 
	 */
	Result getStockDistrData(BossQueryVo queryVo)throws Exception;

	/**
	 * [获取库存分布详情页集合]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 */
	Result getStockDistrDetailData(BossQueryVo queryVo)throws Exception;

	/**
	 * [获取库存分布详情页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-7-19] 
	 */
	Result getStockDistrDetailTotalVo(BossQueryVo queryVo)throws Exception;

}
