package com.phone.erp.boss.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.phone.erp.base.Result;
import com.phone.erp.boss.mapper.ReportBaseMapper;
import com.phone.erp.boss.service.ReportBaseService;
import com.phone.erp.boss.util.BossReportUtil;
import com.phone.erp.boss.vo.common.BossQueryVo;
/**
 * 
 * [报表查询公共服务层实现类]
 * @author HMJ
 * @version [版本,2018-8-6]
 * @see
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class ReportBaseServiceImpl<T,D extends ReportBaseMapper> implements ReportBaseService {
	public D mapper ;
	//子类注入mapper调用父类的setMapper方法完成子类对象指向父类引用的操作
	public void setMapper(D mapper) {
		this.mapper = mapper;
	}
	/**
	 * [获取主页分页集合]
	 * @author HMJ
	 * @version [版本,2018-7-17] 
	 * @throws Exception 
	 */
	@Override
	public Result getPageData(BossQueryVo queryVo, Map<String, Object> paramMap, Result result) throws Exception {
		String descStr = queryVo.getDestStr();
		//设置分页参数
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		try {
			Page<T> pageInfo =mapper.getPageData(paramMap);
			result.put("dataList",pageInfo.getResult());
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	/**
	 * [获取主页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-8-6] 
	 */
	@Override
	public Result getTotalVo(BossQueryVo queryVo,Map<String, Object> paramMap, Result result) throws Exception {
		String descStr = queryVo.getDestStr();
		//增加特殊参数进入map,根据特殊查询条件而定
		try {
			T totalVo = (T) mapper.getTotalVo(paramMap);
			result.put("totalVo", totalVo);
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
//----------------------------------工具方法区------------------------------------------------	


	/**
	 * [获取详情页分页集合]
	 * @author HMJ
	 * @version [版本,2018-8-6] 
	 */
	@Override
	public Result getDetailPageData(BossQueryVo queryVo,Map<String, Object> paramMap, Result result) throws Exception {
		String descStr = queryVo.getDestStr();

		//设置分页参数
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		try {
			Page<T> pageInfo =mapper.getDetailPageData(paramMap);
			result.put("dataList",pageInfo.getResult());
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	/**
	 * [获取详情页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-8-6] 
	 */
	@Override
	public Result getDetailTotalVo(BossQueryVo queryVo,Map<String, Object> paramMap, Result result) throws Exception {
		String descStr = queryVo.getDestStr();
		//增加特殊参数进入map,根据特殊查询条件而定
		try {
			T totalVo = (T) mapper.getDetailTotalVo(paramMap);
			result.put("totalVo", totalVo);
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
}
