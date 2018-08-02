package com.phone.erp.boss.service.storage.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.phone.erp.base.Result;
import com.phone.erp.boss.mapper.storage.CurrentStockMapper;
import com.phone.erp.boss.service.impl.BossCommonServiceImpl;
import com.phone.erp.boss.service.storage.CurrentStockService;
import com.phone.erp.boss.util.BossReportUtil;
import com.phone.erp.boss.vo.common.BossQueryVo;
import com.phone.erp.boss.vo.common.GoodsVo;
import com.phone.erp.boss.vo.storage.CurrentStockVo;
import com.phone.erp.boss.vo.storage.GoodsSumVo;
import com.phone.erp.boss.vo.storage.SectionGoodsVo;
import com.phone.erp.boss.vo.storage.StorageGoodsVo;

/**
 * [实时库存业务实现层]
 * @author HMJ
 * @version [版本,2018-7-12]
 * @see 
 */
@Service
@Transactional
public class CurrentStockServiceImpl implements CurrentStockService  {

	@Autowired
	private CurrentStockMapper currentStockMapper;
	@Autowired
	private BossCommonServiceImpl bossCommonServiceImpl;

	/**
	 * [获取实时库存主页分页集合]
	 * @author hmj
	 * @version [版本,2018-7-12] 
	 * @throws Exception 
	 */
	@Override
	public Result getCurrentStockData(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr = "获取实时库存主页分页集合";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		//增加特殊参数进入map,根据特殊查询条件而定
		//第三步设置分页参数
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		try {
			Page<CurrentStockVo> pageInfo = currentStockMapper.getCurrentStockData(map);
			result.put("dataList",pageInfo.getResult());
			result.put("canSeeAmount", queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	/**
	 * [获取实时库存主页总计行对象]
	 * @author hmj
	 * @version [版本,2018-7-12] 
	 * @throws Exception 
	 * @throws Exception 
	 */
	@Override
	public Result getCurrentStockTotalVo(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr = "获取实时库存主页总计行对象";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		//增加特殊参数进入map,根据特殊查询条件而定
		try {
			CurrentStockVo totalVo = currentStockMapper.getCurrentStockTotal(map);
			result.put("totalVo", totalVo);
			result.put("canSeeAmount",queryVo.getCanSeeAmount());
			
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	/**
	 * [获取实时库存详情页分页集合]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 */
	@Override
	public Result getCurrentStockDetailData(BossQueryVo queryVo)throws Exception {
		Result result = new Result();
		String descStr = "获取实时库存详情页分页集合";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		List<SectionGoodsVo> dataList = new ArrayList<SectionGoodsVo>();
		//增加特殊参数进入map,根据特殊查询条件而定
		try {
			//特殊部步骤先获取仓库集合,然后获取部门集合,将仓库集合放入部门集合中
/*			GoodsSumVo goodsSumVo = currentStockMapper.getGoodsSumVo(map);
			result.put("goodsSumVo", goodsSumVo);*/
			dataList = getDataList(map,queryVo);
			result.put("dataList", dataList);
			result.put("canSeeAmount", queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	/**
	 * [获取实时库存详情页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-7-19] 
	 */
	@Override
	public Result getCurrentStockDetailTotalVo(BossQueryVo queryVo)
			throws Exception {
		Result result = new Result();
		String descStr = "获取实时库存详情页总计行对象";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		try {
			GoodsSumVo totalVo = currentStockMapper.getGoodsSumVo(map);
			result.put("totalVo", totalVo);
			result.put("canSeeAmount", queryVo.getCanSeeAmount());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	
	/**
	 * 获取商品详情对象
	 * @author hmj
	 * @param goodsId 商品id
	 * @version [版本,2018-7-13]
	 */
	@Override
	public Result getGoodsVo(Long goodsId) {
		Result  result = new Result();
		GoodsVo goodsVo = new GoodsVo();
		String descStr = "获取商品详情对象";
		try {
			//获取商品详情对象
			 goodsVo = currentStockMapper.getGoodsVo(goodsId);
			result.put("goodsVo", goodsVo);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}	
	

	/**
	 * [获取含有仓库集合的部门对象集合]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 */
	private List<SectionGoodsVo> getDataList(Map<String, Object> map,BossQueryVo queryVo) {
		List<StorageGoodsVo> storageList = currentStockMapper.getCurrentStockDetailStorageData(map);
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		List<SectionGoodsVo> dataList = currentStockMapper.getCurrentStockDetailSectionData(map).getResult();
		//循环部门和仓库集合,匹配上id就添加入storageList2
		for (SectionGoodsVo sectionVo : dataList) {
			List<StorageGoodsVo> storageList2 = new ArrayList<StorageGoodsVo>();
			for (StorageGoodsVo storageVo : storageList) {
				if (storageVo.getSectionId().toString().equals(sectionVo.getId().toString())) {
					storageList2.add(storageVo);
				}
			}
			sectionVo.setStorageList(storageList2);
		}
		return dataList;
	}




}
