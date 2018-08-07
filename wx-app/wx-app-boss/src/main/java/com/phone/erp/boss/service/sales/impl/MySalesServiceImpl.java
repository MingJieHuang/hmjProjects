package com.phone.erp.boss.service.sales.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.phone.erp.base.Result;
import com.phone.erp.boss.mapper.sales.MySalesMapper;
import com.phone.erp.boss.service.impl.BossCommonServiceImpl;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.sales.MySalesService;
import com.phone.erp.boss.util.BossReportUtil;
import com.phone.erp.boss.vo.common.BossQueryVo;
import com.phone.erp.boss.vo.sales.MySalesVo;

/**
 * [我的销量服务层实现类]
 * @author HMJ
 * @version [版本,2018-7-16]
 * @see 
 */
@Service
@Transactional
@SuppressWarnings("unused")
public class MySalesServiceImpl extends ReportBaseServiceImpl<MySalesVo, MySalesMapper>implements MySalesService{
	@Autowired
	private MySalesMapper mySalesMapper;
	@Autowired
	public void setBaseMapper(MySalesMapper mySalesMapper) {
		super.setMapper(mySalesMapper);
	}	
/*	@Autowired
	private BossCommonServiceImpl bossCommonServiceImpl;*/
/*	*//**
	 * [获取我的销量主页分页集合]
	 * @author hmj
	 * @param keyWord 模糊查询
	 * @param page 当前页码
	 * @param pageSize 每页最大显示数
	 * @param goodsClassId 商品一级分类id
	 * @param goodsBrandId 商品品牌id
	 * @param menuCode 报表菜单码
	 * @param salesType 销售类型  全部:空 ,零售:1,销售:2
	 * @param startDate 查询起始时间
	 * @param endDate 查询截止时间
	 * @version [版本,2018-7-16]
	 * @throws Exception 
	 *//*
	@Override
	public Result getMySalesData(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr = "获取我的销量主页分页集合";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		//增加特殊参数进入map,根据特殊查询条件而定
		//第三步设置分页参数
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		try {
			Page<MySalesVo> pageInfo = mySalesMapper.getMySalesData(map);
			result.put("dataList",pageInfo.getResult());
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	
	*//**
	 * [获取我的销量主页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-7-18] 
	 * @throws Exception 
	 *//*
	@Override
	public Result getMySalesTotalVo(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr = "获取我的销量主页总计行对象";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		try {
			MySalesVo companyTotalVo = mySalesMapper.getMySalesTotalVo(map);
			result.put("totalVo", companyTotalVo);
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}*/
	
	
/*	*//**
	 * [获取我的销量详情页分页集合]
	 * @author HMJ
	 * @version [版本,2018-7-17] 
	 * @throws Exception 
	 *//*
	@Override
	public Result getMySalesDetailData(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr = "获取我的销量详情页分页集合";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		//增加特殊参数进入map,根据特殊查询条件而定
		//第三步设置分页参数
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		try {
			if ("Section".equals(queryVo.getNodeType())) {//当主页点击部门跳转详情页就用sectionId查询
				map.put("sectionIds", map.get("sectionId"));
			}
			Page<MySalesVo> pageInfo = mySalesMapper.getMySalesDetailData(map);
			MySalesVo totalVo = mySalesMapper.getMySalesDetailTotalVo(map);
			result.put("totalVo", totalVo);
			result.put("dataList",pageInfo.getResult());
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	*//**
	 * [获取我的销量详情页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-7-18] 
	 * @throws Exception 
	 *//*
	@Override
	public Result getMySalesDetailTotalVo(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr = "获取我的销量详情页总计行对象";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		try {
			if ("Section".equals(queryVo.getNodeType())) {//当主页点击部门跳转详情页就用sectionId查询
				map.put("sectionIds", map.get("sectionId"));
			}
			MySalesVo totalVo = mySalesMapper.getMySalesDetailTotalVo(map);
			result.put("totalVo", totalVo);
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}*/
}
