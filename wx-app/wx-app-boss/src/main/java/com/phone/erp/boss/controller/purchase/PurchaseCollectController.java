package com.phone.erp.boss.controller.purchase;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.purchase.PurchaseCollectService;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [采购汇总控制层]
 * @author HMJ
 * @version [版本,2018-7-17]
 * @see 
 */
@Controller
@RequestMapping("${project.url.prefix}/report/purchase/purchaseCollect")
public class PurchaseCollectController extends ReportBaseController {
	@Autowired
	private PurchaseCollectService PurchaseCollectService; 
	/**
	 * 获取采购汇总主页数据
	 * @author hmj
	 * @param CompanySectionParam 公司部门参数
	 * @param keyWord 模糊(商品,类别,型号,品牌,条码)查询
	 * @param page 当前页码
	 * @param pageSize 每页最大显示数
	 * @param goodsClassId 商品一级分类id
	 * @param supplierId 供应商id
	 * @param groupField 分组字段 切换 按商品,按部门,按供应商 时分别传goodsName,sectionName,supplierName
	 * @param menuCode 报表菜单码
	 * @param startDate 查询起始时间
	 * @param endDate 查询截止时间
	 * @version [版本,2018-7-16]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getPurchaseCollectData")
	@ResponseBody
	public Result getPurchaseCollectData(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		String groupFields ="goodsName,sectionName,supplierName";
		Assert.isTrue(groupFields.contains(queryVo.getGroupField()), "分组字段不合法!!");
		queryVo.setMenuCode("BOSS_CGHZ");
		queryVo.setDestStr("获取采购汇总主页分页集合");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return PurchaseCollectService.getPageData(queryVo, paramMap, result);
		//return PurchaseCollectService.getPurchaseCollectData(queryVo);
	}
	/**
	 * 获取采购汇总总计行数据
	 * @author hmj
	 * @param CompanySectionParam 公司部门参数
	 * @param keyWord 模糊(商品,类别,型号,品牌,条码)查询
	 * @param goodsClassId 商品一级分类id
	 * @param supplierId 供应商id
	 * @param menuCode 报表菜单码
	 * @param startDate 查询起始时间
	 * @param endDate 查询截止时间
	 * @version [版本,2018-7-16]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getPurchaseCollectTotalVo")
	@ResponseBody
	public Result getPurchaseCollectTotalVo(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_CGHZ");
		queryVo.setDestStr("获取采购汇总总计行数据");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return PurchaseCollectService.getTotalVo(queryVo, paramMap, result);
		//return PurchaseCollectService.getPurchaseCollectTotalVo(queryVo);
	}
}
