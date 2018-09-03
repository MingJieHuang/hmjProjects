package com.phone.erp.boss.mapper;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;

public interface ReportBaseMapper<T> {

	/**
	 * [获取主页集合(不分页)]
	 * @author HMJ
	 * @version [版本,2018-9-03]
	 */
	List<T> getDataList(Map<String, Object> map);
	/**
	 * 
	 * [获取主页分页结果集]
	 * @author HMJ
	 * @version [版本,2018-8-4]
	 */
	Page<T> getPageData(Map<String, Object> map);
	
	/**
	 * 
	 * [获取主页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-8-4]
	 */
	T getTotalVo(Map<String, Object> map);
	
	/**
	 * 
	 * [获取详情页分页结果集]
	 * @author HMJ
	 * @version [版本,2018-8-4]
	 */
	Page<T> getDetailPageData(Map<String, Object> map);
	
	/**
	 * 
	 * [获取详情页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-8-4]
	 */
	T getDetailTotalVo(Map<String, Object> map);

}
