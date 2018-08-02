package com.phone.erp.boss.controller.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import com.phone.erp.boss.controller.BossCommonController;
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
public class MySalesController extends BossCommonController {
	@Autowired
	private MySalesService mySalesService;

	/**
	 * 获取我的销量主页数据
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
	 */
	@AuthValidate
	@RequestMapping("/getMySalesData")
	@ResponseBody
	public Result getMySalesData(BossQueryVo queryVo) throws Exception{
		queryVo.setMenuCode("BOSS_WDXL");
		LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
		Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
		queryVo.setEmployeeVo(currentEmployeeVo);
		return mySalesService.getMySalesData(queryVo);
	}
	/**
	 * 获取我的销量主页总计行对象
	 * @author hmj
	 * @param keyWord 模糊查询
	 * @param goodsClassId 商品一级分类id
	 * @param goodsBrandId 商品品牌id
	 * @param menuCode 报表菜单码
	 * @param salesType 销售类型  全部:空 ,零售:1,销售:2
	 * @param startDate 查询起始时间
	 * @param endDate 查询截止时间
	 * @version [版本,2018-7-16]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getMySalesTotalVo")
	@ResponseBody
	public Result getMySalesTotalVo(BossQueryVo queryVo) throws Exception{
		queryVo.setMenuCode("BOSS_WDXL");
		LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
		Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
		queryVo.setEmployeeVo(currentEmployeeVo);
		return mySalesService.getMySalesTotalVo(queryVo);
	}
	/**
	 * 获取我的销量详情页数据
	 * @author hmj
	 * @param nodeType 单击的对象类型:"Company"或者"Section"
	 * @param sectionId 只有当nodeType="Section"时才有值
	 * @param CompanySectionParam 当前选中的公司部门参数
	 * @param keyWord 模糊查询
	 * @param sectionWord 主页模糊查询
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
	 */
	@AuthValidate
	@RequestMapping("/getMySalesDetailData")
	@ResponseBody
	public Result getMySalesDetailData(BossQueryVo queryVo) throws Exception{
		queryVo.setMenuCode("BOSS_WDXL");
		Assert.notNull(queryVo.getNodeType(),"nodeType参数不能为空!!");//对象类型参数不为空
		LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
		Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
		queryVo.setEmployeeVo(currentEmployeeVo);
		return mySalesService.getMySalesDetailData(queryVo);
	}
	/**
	 * 获取我的销量详情页总计行对象
	 * @author hmj
	 * @param nodeType 单击的对象类型:"Company"或者"Section"
	 * @param sectionId 只有当nodeType="Section"时才有值
	 * @param CompanySectionParam 当前选中的公司部门参数
	 * @param keyWord 模糊查询
	 * @param sectionWord 主页模糊查询
	 * @param goodsClassId 商品一级分类id
	 * @param goodsBrandId 商品品牌id
	 * @param menuCode 报表菜单码
	 * @param salesType 销售类型  全部:空 ,零售:1,销售:2
	 * @param startDate 查询起始时间
	 * @param endDate 查询截止时间
	 * @version [版本,2018-7-16]
	 * @throws Exception 
	 */
	@AuthValidate
	@RequestMapping("/getMySalesDetailTotalVo")
	@ResponseBody
	public Result getMySalesDetailTotalVo(BossQueryVo queryVo) throws Exception{
		queryVo.setMenuCode("BOSS_WDXL");
		Assert.notNull(queryVo.getNodeType(),"nodeType参数不能为空!!");//对象类型参数不为空
		LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
		Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
		queryVo.setEmployeeVo(currentEmployeeVo);
		return mySalesService.getMySalesDetailTotalVo(queryVo);
	}
}
