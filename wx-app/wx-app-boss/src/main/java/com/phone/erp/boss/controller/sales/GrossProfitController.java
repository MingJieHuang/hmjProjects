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
import com.phone.erp.boss.service.sales.GrossProfitService;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [毛利战报控制层]
 * @author HMJ
 * @version [版本,2018-7-18]
 * @see 
 */
@Controller
@RequestMapping("${project.url.prefix}/report/sales/grossProfit")
public class GrossProfitController extends ReportBaseController {

	@Autowired
	private GrossProfitService grossProfitService;
	/**
	 * 获取毛利战报主页数据
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-16]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getGrossProfitData")
	@ResponseBody
	public Result getGrossProfitData(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_MLZB");
		queryVo.setDestStr("获取毛利战报主页数据");
		Assert.notNull(queryVo.getGroupField(),"分组字段参数不为空");//分组字段参数不为空
		String groupFields ="goodsClassName,goodsBrandName,sectionName,salesManName,goodsName";
		Assert.isTrue(groupFields.contains(queryVo.getGroupField()), "分组字段不合法!!");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return grossProfitService.getPageData(queryVo, paramMap, result);
	}	
	
	/**
	 * 获取毛利战报主页总计行对象
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-16]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getGrossProfitTotalVo")
	@ResponseBody
	public Result getGrossProfitTotalVo(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_MLZB");
		queryVo.setDestStr("获取毛利战报主页总计行对象");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return grossProfitService.getTotalVo(queryVo, paramMap, result);
	}	
	
	/**
	 * 获取毛利战报明细页数据(分页)
	 * @author hmj
	 * @param queryVo
	 * @param nodeName 点击节点的name
	 * @param nodeId 点击节点的id
	 * @version [版本,2018-7-18]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getGrossProfitDetailData")
	@ResponseBody
	public Result getGrossProfitDetailData(BossQueryVo queryVo,String nodeName,String nodeId) throws Exception{
		setCurrentEmp(queryVo);
		String groupFields ="goodsClassName,goodsBrandName,sectionName,salesManName,goodsName";
		Assert.isTrue(groupFields.contains(queryVo.getGroupField()), "分组字段不合法!!");
		queryVo.setMenuCode("BOSS_MLZB");
		queryVo.setDestStr("获取毛利战报明细页数据(分页)");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		//根据不同的nodeId和nodeName加工不同的查询参数
		String groupField = queryVo.getGroupField();
		if ("goodsName".equals(groupField)) {
			paramMap.put("goodsId", nodeId);
		}
		else if ("goodsBrandName".equals(groupField)) {
			if ("null".equals(nodeId)){
				paramMap.put("goodsBrandIdIsNull",1);
			}else{
				paramMap.put("goodsBrandId", nodeId);
			}
		}
		else if ("sectionName".equals(groupField)) {
			paramMap.put("sectionIds", nodeId);
		}
		else if ("salesManName".equals(groupField)) {
			paramMap.put("salesManId", nodeId);
		}else{
			paramMap.put("goodsClassId", nodeId);
		}
		return grossProfitService.getDetailPageData(queryVo, paramMap, result);
	}	
	/**
	 * 获取毛利战报详情页总计行对象
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-18]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getGrossProfitDetailTotalVo")
	@ResponseBody
	public Result getGrossProfitDetailTotalVo(BossQueryVo queryVo,String nodeName,String nodeId) throws Exception{
		setCurrentEmp(queryVo);
		String groupFields ="goodsClassName,goodsBrandName,sectionName,salesManName,goodsName";
		Assert.isTrue(groupFields.contains(queryVo.getGroupField()), "分组字段不合法!!");
		queryVo.setMenuCode("BOSS_MLZB");
		queryVo.setDestStr("获取毛利战报详情页总计行对象");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		//根据不同的nodeId加工不同的查询参数
		String groupField = queryVo.getGroupField();
		if ("goodsName".equals(groupField)) {
			paramMap.put("goodsId", nodeId);
		}
		else if ("goodsBrandName".equals(groupField)) {
			if ("null".equals(nodeId)){
				paramMap.put("goodsBrandIdIsNull",1);
			}else{
				paramMap.put("goodsBrandId", nodeId);
			}
		}
		else if ("sectionName".equals(groupField)) {
			paramMap.put("sectionIds", nodeId);
		}
		else if ("salesManName".equals(groupField)) {
			paramMap.put("salesManId", nodeId);
		}else{
			paramMap.put("goodsClassId", nodeId);
		}
		return grossProfitService.getDetailTotalVo(queryVo, paramMap, result);
	}	
}
