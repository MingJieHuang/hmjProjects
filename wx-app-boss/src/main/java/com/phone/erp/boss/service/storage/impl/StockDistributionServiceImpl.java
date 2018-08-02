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
import com.phone.erp.boss.mapper.storage.StockDistributionMapper;
import com.phone.erp.boss.service.impl.BossCommonServiceImpl;
import com.phone.erp.boss.service.storage.StockDistributionService;
import com.phone.erp.boss.util.BossReportUtil;
import com.phone.erp.boss.vo.common.BossQueryVo;
import com.phone.erp.boss.vo.storage.GoodsSumVo;
import com.phone.erp.boss.vo.storage.SectionGoodsVo;
import com.phone.erp.boss.vo.storage.StockDistributionVo;
import com.phone.erp.boss.vo.storage.StorageGoodsVo;

/**
 * [库存分布业务实现层]
 * @author HMJ
 * @version [版本,2018-7-12]
 * @see 
 */
@Service
@Transactional
public class StockDistributionServiceImpl implements StockDistributionService  {

	@Autowired
	private StockDistributionMapper stockDistributionMapper;
	@Autowired
	private BossCommonServiceImpl bossCommonServiceImpl;

	/**
	 * [获取库存分布主页分页集合]
	 * @author hmj
	 * @version [版本,2018-7-12] 
	 * @throws Exception 
	 */
	@Override
	public Result getStockDistrData(BossQueryVo queryVo) throws Exception {
		Result result = new Result();
		String descStr ="获取库存分布主页分页集合";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		//增加特殊参数进入map,根据特殊查询条件而定
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		try {
			Page<StockDistributionVo> pageInfo = stockDistributionMapper.getStockDistrData(map);
			result.put("dataList",pageInfo.getResult());
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	/**
	 * [获取库存分布详情页分页集合]
	 * @author hmj
	 * @version [版本,2018-7-13] 
	 */
	@Override
	public Result getStockDistrDetailData(BossQueryVo queryVo)throws Exception {
		Result result = new Result();
		String descStr = "获取库存分布详情页分页集合";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		List<SectionGoodsVo> dataList = new ArrayList<SectionGoodsVo>();
		//增加特殊参数进入map,根据特殊查询条件而定
		try {
			//特殊部步骤先获取仓库集合,然后获取部门集合,将仓库集合放入部门集合中
			dataList = getDataList(map,queryVo);
			result.put("dataList", dataList);
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
		List<StorageGoodsVo> storageList = stockDistributionMapper.getStockDistrDetailStorageData(map);
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		List<SectionGoodsVo> dataList = stockDistributionMapper.getStockDistrDetailSectionData(map).getResult();
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

	/**
	 * [获取库存分布详情页总计行对象]
	 * @author HMJ
	 * @version [版本,2018-7-19] 
	 */
	@Override
	public Result getStockDistrDetailTotalVo(BossQueryVo queryVo)
			throws Exception {
		Result result = new Result();
		String descStr = "获取库存分布详情页总计行对象";
		//第一步验证访问权限和查看成本价权限
		bossCommonServiceImpl.authValidate(queryVo, result);
		//第二步加工查询参数
		Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
		try {
			GoodsSumVo totalVo = stockDistributionMapper.getGoodsSumVo(map);
			result.put("totalVo", totalVo);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}


}
