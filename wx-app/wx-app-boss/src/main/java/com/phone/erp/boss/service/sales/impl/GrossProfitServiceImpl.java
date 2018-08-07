package com.phone.erp.boss.service.sales.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.erp.boss.mapper.sales.GrossProfitMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.sales.GrossProfitService;
import com.phone.erp.boss.vo.sales.GrossProfitVo;

/**
 * [毛利战报服务实现类]
 * @author HMJ
 * @version [版本,2018-7-18]
 * @see 
 */
@Service
@Transactional
public class GrossProfitServiceImpl extends ReportBaseServiceImpl<GrossProfitVo, GrossProfitMapper> implements GrossProfitService {
	@Autowired
	GrossProfitMapper grossProfitMapper;
	//Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
	@Autowired
	public void setBaseMapper(GrossProfitMapper grossProfitMapper){
		super.setMapper(grossProfitMapper);
	}
/*	@Autowired
	BossCommonService bossCommonService;
	*//**
	 * [获取毛利战报主页分页集合]
	 * @author HMJ
	 * @version [版本,2018-7-18] 
	 * @throws Exception 
	 *//*
	@Override
	public Result getGrossProfitData(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr = "获取毛利战报主页分页集合";
		//第一步验证访问权限和查看成本价权限
		bossCommonService.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonService.getParamMap(queryVo);
		//增加特殊参数进入map,根据特殊查询条件而定
		//第三步设置分页参数
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		try {
			Page<GrossProfitVo> pageInfo = grossProfitMapper.getGrossProfitData(map);
			GrossProfitVo totalVo = grossProfitMapper.getGrossProfitTotalVo(map);
			result.put("totalVo", totalVo);
			result.put("dataList",pageInfo.getResult());
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	*//**
	 * [获取毛利战报主页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-7-18] 
	 *//*
	@Override
	public Result getGrossProfitTotalVo(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr = "获取毛利战报主页总计行对象";
		//第一步验证访问权限和查看成本价权限
		bossCommonService.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonService.getParamMap(queryVo);
		try {
			GrossProfitVo totalVo = grossProfitMapper.getGrossProfitTotalVo(map);
			result.put("totalVo", totalVo);
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	*//**
	 * [获取毛利战报详情页分页集合]
	 * @author HMJ
	 * @version [版本,2018-7-18] 
	 *//*
	@Override
	public Result getGrossProfitDetailData(BossQueryVo queryVo,
			String nodeName, Long nodeId) throws Exception {
		String descStr = "获取毛利战报详情页分页集合";
		Result result = new Result();
		//第一步验证访问权限和查看成本价权限
		bossCommonService.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonService.getParamMap(queryVo);
		//根据不同的nodeId和nodeName加工不同的查询参数
		String groupField = queryVo.getGroupField();
		if ("goodsName".equals(groupField)) {
			map.put("goodsId", nodeId);
		}
		else if ("goodsBrandName".equals(groupField)) {
			map.put("goodsBrandId", nodeId);
		}
		else if ("sectionName".equals(groupField)) {
			map.put("sectionIds", nodeId);
		}
		else if ("salesManName".equals(groupField)) {
			map.put("salesManId", nodeId);
		}else{
			map.put("goodsClassId", nodeId);
		}
		//第三步设置分页参数
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		try {
			Page<GrossProfitVo> pageInfo = grossProfitMapper.getGrossProfitDetailData(map);
			result.put("dataList",pageInfo.getResult());
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	*//**
	 * [获取毛利战报详情页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-7-18] 
	 *//*
	@Override
	public Result getGrossProfitDetailTotalVo(BossQueryVo queryVo,
			String nodeName, Long nodeId) throws Exception {
		String descStr = "获取毛利战报详情页总计行对象";
		Result result = new Result();
		//第一步验证访问权限和查看成本价权限
		bossCommonService.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonService.getParamMap(queryVo);
		//根据不同的nodeId和nodeName加工不同的查询参数
		String groupField = queryVo.getGroupField();
		if ("goodsName".equals(groupField)) {
			map.put("goodsId", nodeId);
		}
		else if ("goodsBrandName".equals(groupField)) {
			map.put("goodsBrandId", nodeId);
		}
		else if ("sectionName".equals(groupField)) {
			map.put("sectionIds", nodeId);
		}
		else if ("salesManName".equals(groupField)) {
			map.put("salesManId", nodeId);
		}else{
			map.put("goodsClassId", nodeId);
		}
		try {
			GrossProfitVo totalVo = grossProfitMapper.getGrossProfitDetailTotalVo(map);
			result.put("totalVo", totalVo);
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
*/
}
