package com.phone.erp.boss.controller.storage;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.storage.CurrentStockService;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [实时库存报表控制层]
 * @author HMJ
 * @version [版本,2018-7-12]
 * @see 
 */
@Controller
@RequestMapping("${project.url.prefix}/report/storage/currentStock")
public class CurrentStockController extends ReportBaseController {
	@Autowired
	private CurrentStockService currentStockService;
	/**
	 * 获取实时库存主页数据集合
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-13]
	 */
	@AuthValidate
	@RequestMapping("/getCurrentStockData")
	@ResponseBody
	public Result getCurrentStockData(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_SSKC");
		queryVo.setDestStr("获取实时库存主页数据集合");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return currentStockService.getPageData(queryVo,paramMap,result);
	}
	/**
	 * 获取实时库存主页总计行对象
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-13]
	 */
	@AuthValidate
	@RequestMapping("/getCurrentStockTotalVo")
	@ResponseBody
	public Result getCurrentStockTotalVo(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_SSKC");
		queryVo.setDestStr("获取实时库存主页总计行对象");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return currentStockService.getTotalVo(queryVo,paramMap,result);
	}
	
	/**
	 * 获取实时库存详情页分页集合
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-13]
	 */
	@AuthValidate
	@RequestMapping("/getCurrentStockDetailData")
	@ResponseBody
	public Result getCurrentStockDetailData(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_SSKC");
		queryVo.setDestStr("获取实时库存详情页分页集合");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		
		return currentStockService.getCurrentStockDetailData(queryVo,paramMap,result);
	}
	/**
	 * 获取实时库存详情页总计行对象
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-13]
	 */
	@AuthValidate
	@RequestMapping("/getCurrentStockDetailTotalVo")
	@ResponseBody
	public Result getCurrentStockDetailTotalVo(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_SSKC");
		Assert.notNull(queryVo.getGoodsId(),"商品id参数不为空");//商品id参数不为空
		queryVo.setDestStr("获取实时库存详情页总计行对象");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		
		return currentStockService.getCurrentStockDetailTotalVo(queryVo,paramMap,result);
	}
	
	
	/**
	 * 获取商品详情对象
	 * @author hmj
	 * @param goodsId 商品id
	 * @version [版本,2018-7-13]
	 */
	@AuthValidate
	@RequestMapping("/getGoodsDetailVo")
	@ResponseBody
	public Result getGoodsVo(Long goodsId) throws Exception{
		Assert.notNull(goodsId,"商品id参数不为空");//商品id参数不为空
		LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
		Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
		return currentStockService.getGoodsVo(goodsId);
	}

}
