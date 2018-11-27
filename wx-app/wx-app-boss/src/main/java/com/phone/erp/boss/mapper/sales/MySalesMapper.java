package com.phone.erp.boss.mapper.sales;

import java.util.Map;

import com.github.pagehelper.Page;
import com.phone.erp.boss.mapper.ReportBaseMapper;
import com.phone.erp.boss.vo.sales.MySalesVo;

/**
 * [我的销量Mapper]
 * @author HMJ
 * @version [版本,2018-7-16]
 * @see 
 */

public interface MySalesMapper extends ReportBaseMapper<MySalesVo>{

/*	*//**
	 * [获取我的销量主页分页集合数据]
	 * @author hmj
	 * @version [版本,2018-7-17] 
	 *//*
	Page<MySalesVo> getMySalesData(Map<String, Object> map);

	*//**
	 * [获取我的销量主页公司总计行对象]
	 * @author hmj
	 * @version [版本,2018-7-17] 
	 *//*
	MySalesVo getMySalesTotalVo(Map<String, Object> map);*/

/*	*//**
	 * [获取我的销量详情页分页集合数据]
	 * @author HMJ
	 * @version [版本,2018-7-17] 
	 *//*
	Page<MySalesVo> getMySalesDetailData(Map<String, Object> map);

	*//**
	 * [获取我的销量详情页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-7-17] 
	 *//*
	MySalesVo getMySalesDetailTotalVo(Map<String, Object> map);*/

}
