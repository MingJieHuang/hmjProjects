package com.phone.erp.boss.service;

import java.util.Map;

import com.phone.erp.base.Result;
import com.phone.erp.boss.vo.common.BossQueryVo;
/**
 * 
 * [报表查询公共服务层接口]
 * @author HMJ
 * @version [版本,2018-8-6]
 * @see
 */
public interface ReportBaseService{
	
	//查询主页分页集合方法
	public Result getPageData(BossQueryVo queryVo, Map<String, Object> paramMap, Result result)throws Exception ;
	
	//查询主页总计行对象方法
	public Result getTotalVo(BossQueryVo queryVo, Map<String, Object> paramMap, Result result)throws Exception ;
	
	//查询详情页分页集合方法
	public Result getDetailPageData(BossQueryVo queryVo, Map<String, Object> paramMap, Result result)throws Exception ;
	
	//查询详情页总计行对象方法
	public Result getDetailTotalVo(BossQueryVo queryVo, Map<String, Object> paramMap, Result result)throws Exception ;
	
	
}
