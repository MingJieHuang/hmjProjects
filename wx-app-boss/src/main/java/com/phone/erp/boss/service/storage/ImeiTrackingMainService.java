package com.phone.erp.boss.service.storage;

import java.util.Map;

import com.phone.erp.base.Result;
import com.phone.erp.boss.service.ReportBaseService;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [串号跟踪服务层]
 * @author HMJ
 * @version [版本,2018-7-19]
 * @see 
 */

public interface ImeiTrackingMainService extends ReportBaseService{

/*	*//**
	 * [获取串号跟踪主页分页集合]
	 * @author HMJ
	 * @version [版本,2018-7-19] 
	 *//*
	Result getImeiTrackingMainData(BossQueryVo queryVo)throws Exception;*/

	/**
	 * [获取串号跟踪流水表集合]
	 * @author HMJ
	 * @version [版本,2018-7-19] 
	 * @param result 
	 * @param paramMap 
	 */
	Result getImeiTrackingDetailData(BossQueryVo queryVo, Map<String, Object> paramMap, Result result)throws Exception;

}
