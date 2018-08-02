package com.phone.erp.boss.service.storage.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.phone.erp.base.Result;
import com.phone.erp.boss.mapper.storage.ImeiTrackingMainMapper;
import com.phone.erp.boss.service.BossCommonService;
import com.phone.erp.boss.service.storage.ImeiTrackingMainService;
import com.phone.erp.boss.util.BossReportUtil;
import com.phone.erp.boss.vo.common.BossQueryVo;
import com.phone.erp.boss.vo.storage.ImeiTrackingDetailVo;
import com.phone.erp.boss.vo.storage.ImeiTrackingGoodsVo;
import com.phone.erp.boss.vo.storage.ImeiTrackingMainVo;

/**
 * [串号跟踪服务层实现类]
 * @author HMJ
 * @version [版本,2018-7-19]
 * @see 
 */
@Service
@Transactional
public class ImeiTrackingMainServiceImpl implements ImeiTrackingMainService {
	@Autowired
	private ImeiTrackingMainMapper imeiTrackingMainMapper;
	@Autowired
	private BossCommonService bossCommonServiceImpl;
	/**
	 * [获取串号跟踪主页分页集合]
	 * @author HMJ
	 * @version [版本,2018-7-19] 
	 */
	@Override
	public Result getImeiTrackingMainData(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr = "获取串号跟踪主页分页集合";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		//增加特殊参数进入map,根据特殊查询条件而定
		//第三步设置分页参数
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		try {
			Page<ImeiTrackingMainVo> pageInfo = imeiTrackingMainMapper.getImeiTrackingMainData(map);
			result.put("dataList",pageInfo.getResult());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	/**
	 * [获取串号跟踪流水表集合]
	 * @author HMJ
	 * @version [版本,2018-7-19] 
	 */
	@Override
	public Result getImeiTrackingDetailData(BossQueryVo queryVo)
			throws Exception {
		Result result = new Result();
		String descStr = "获取串号跟踪流水表集合";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		//增加特殊参数进入map,根据特殊查询条件而定
		try {
			List<ImeiTrackingDetailVo> dataList = imeiTrackingMainMapper.getImeiTrackingDetailData(map);
			ImeiTrackingGoodsVo goodsVo = imeiTrackingMainMapper.getImeiTrackingGoodsVo(map);
			result.put("dataList",dataList);
			result.put("goodsVo",goodsVo);
			result.put("canSeeAmount", queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

}
