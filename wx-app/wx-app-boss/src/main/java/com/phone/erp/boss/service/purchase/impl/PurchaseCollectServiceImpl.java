package com.phone.erp.boss.service.purchase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.erp.boss.mapper.purchase.PurchaseCollectMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.purchase.PurchaseCollectService;
import com.phone.erp.boss.vo.purchase.PurchaseCollectVo;

/**
 * [采购汇总服务实现类]
 * @author HMJ
 * @version [版本,2018-7-17]
 * @see 
 */
@Service
@Transactional
public class PurchaseCollectServiceImpl extends ReportBaseServiceImpl<PurchaseCollectVo,PurchaseCollectMapper> implements PurchaseCollectService {
	@SuppressWarnings("unused")
	@Autowired
	private PurchaseCollectMapper purchaseCollectMapper;
	//Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
	@Autowired
	public void setBaseMapper(PurchaseCollectMapper purchaseCollectMapper) {
		super.setMapper(purchaseCollectMapper);
	}
/*
	@Autowired
	private BossCommonServiceImpl bossCommonServiceImpl;
	

	*//**
	 * [获取采购汇总主页分页集合]
	 * @author HMJ
	 * @version [版本,2018-7-17] 
	 * @throws Exception 
	 *//*
	@Override
	public Result getPurchaseCollectData(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr = "获取采购汇总主页分页集合";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		//增加特殊参数进入map,根据特殊查询条件而定
		//第三步设置分页参数
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		try {
			//Page<PurchaseCollectVo> pageInfo = purchaseCollectMapper.getPurchaseCollectData(map);
			Page<PurchaseCollectVo> pageInfo = purchaseCollectMapper.getPageData(map);
			PurchaseCollectVo totalVo = purchaseCollectMapper.getPurchaseCollectTotalVo(map);
			result.put("totalVo", totalVo);
			result.put("dataList",pageInfo.getResult());
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	*//**
	 * [获取采购汇总总计行对象]
	 * @author HMJ
	 * @version [版本,2018-7-18] 
	 * @throws Exception 
	 *//*
	@Override
	public Result getPurchaseCollectTotalVo(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr = "获取采购汇总总计行对象";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		//增加特殊参数进入map,根据特殊查询条件而定
		try {
			PurchaseCollectVo totalVo = purchaseCollectMapper.getPurchaseCollectTotalVo(map);
			result.put("totalVo", totalVo);
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}*/


}
