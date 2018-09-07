package com.phone.erp.boss.controller.sales;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.sales.MySalesService;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [我的销量控制层]
 * @author HMJ
 * @version [版本,2018-7-16]
 * @see 
 */
@Controller
@RequestMapping("${project.url.prefix}/report/sales/mySales")
public class MySalesController extends ReportBaseController {
	@Autowired
	private MySalesService mySalesService;

	/**
	 * 获取我的销量主页数据
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-16]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getMySalesData")
	@ResponseBody
	public Result getMySalesData(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_WDXL");
		queryVo.setDestStr("获取我的销量主页数据");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return mySalesService.getPageData(queryVo,paramMap,result);
	}
	/**
	 * 获取我的销量主页总计行对象
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-16]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getMySalesTotalVo")
	@ResponseBody
	public Result getMySalesTotalVo(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_WDXL");
		queryVo.setDestStr("获取我的销量主页总计行对象");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return mySalesService.getTotalVo(queryVo,paramMap,result);
	}
	/**
	 * 获取我的销量详情页数据
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-16]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getMySalesDetailData")
	@ResponseBody
	public Result getMySalesDetailData(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		Assert.notNull(queryVo.getNodeType(),"nodeType参数不能为空!!");//对象类型参数不为空
		queryVo.setMenuCode("BOSS_WDXL");
		queryVo.setDestStr("获取我的销量详情页数据");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		//与主页区别参数设置
		if ("Section".equals(queryVo.getNodeType())) {//当主页点击部门跳转详情页就用sectionId查询
			paramMap.put("sectionIds", paramMap.get("sectionId"));
		}	
		return mySalesService.getDetailPageData(queryVo, paramMap, result);
	}
	/**
	 * 获取我的销量详情页总计行对象
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-16]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getMySalesDetailTotalVo")
	@ResponseBody
	public Result getMySalesDetailTotalVo(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		Assert.notNull(queryVo.getNodeType(),"nodeType参数不能为空!!");//对象类型参数不为空
		queryVo.setMenuCode("BOSS_WDXL");
		queryVo.setDestStr("获取我的销量详情页总计行对象");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		//与主页区别参数设置
		if ("Section".equals(queryVo.getNodeType())) {//当主页点击部门跳转详情页就用sectionId查询
			paramMap.put("sectionIds", paramMap.get("sectionId"));
		}	
		return mySalesService.getDetailTotalVo(queryVo, paramMap, result);
	}
}
