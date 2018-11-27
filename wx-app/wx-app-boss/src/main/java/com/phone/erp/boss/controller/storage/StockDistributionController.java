package com.phone.erp.boss.controller.storage;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.storage.StockDistributionService;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [库存分布报表控制层]
 * @author HMJ
 * @version [版本,2018-7-16]
 * @see 
 */
@Controller
@RequestMapping("${project.url.prefix}/report/storage/stockDistribution")
public class StockDistributionController extends ReportBaseController {
	@Autowired
	private StockDistributionService stockDistributionService;
	/**
	 * 获取库存分布主页数据集合
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-13]
	 */
	@AuthValidate
	@RequestMapping("/getStockDistrData")
	@ResponseBody
	public Result getStockDistrData(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_KCFB");
		queryVo.setDestStr("获取库存分布主页数据集合");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return stockDistributionService.getPageData(queryVo, paramMap, result);
	}
	
	/**
	 * 获取库存分布详情页分页集合
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-13]
	 */
	@AuthValidate
	@RequestMapping("/getStockDistrDetailData")
	@ResponseBody
	public Result getStockDistrDetailData(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_KCFB");
		queryVo.setDestStr("获取库存分布详情页分页集合");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return stockDistributionService.getStockDistrDetailData(queryVo,paramMap,result);
	}
	/**
	 * 获取库存分布详情页总计行对象
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-13]
	 */
	@AuthValidate
	@RequestMapping("/getStockDistrDetailTotalVo")
	@ResponseBody
	public Result getStockDistrDetailTotalVo(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		Assert.notNull(queryVo.getGoodsId(),"商品id参数不为空");//商品id参数不为空
		queryVo.setMenuCode("BOSS_KCFB");
		queryVo.setDestStr("获取库存分布详情页总计行对象");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return stockDistributionService.getStockDistrDetailTotalVo(queryVo,paramMap,result);
	}

}
