package com.phone.erp.boss.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.controller.BaseController;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import com.phone.erp.boss.service.BossCommonService;
import com.phone.erp.boss.util.BossReportUtil;
import com.phone.erp.boss.vo.common.BossCompanyVo;
import com.phone.erp.boss.vo.common.BossContactUnitVo;
import com.phone.erp.boss.vo.common.BossMenuVo;
import com.phone.erp.boss.vo.common.BossQueryVo;
import com.phone.erp.boss.vo.common.GoodsBrandVo;
import com.phone.erp.boss.vo.common.GoodsClassVo;


/**
 * [Boss小程序公共控制层]
 * @author HMJ
 * @version [版本,2018-7-10]
 * @see 
 */
@Controller
@RequestMapping("${project.url.prefix}/common")
public class BossCommonController extends BaseController {

	@Autowired
	private BossCommonService bossCommonService;
	/**
	 * 获取Boss小程序菜单集合
	 * @author hmj
	 * @version [版本,2018-7-10]
	 */
	
	@AuthValidate
	@RequestMapping("/getBossMenuList")
	@ResponseBody
	public Result getBossAuthValidate(){
		LoginEmployeeVo employeeVo = super.getCurrentEmployeeVo();
		Assert.notNull(employeeVo, ErrorCode.NOT_LOGGED_IN);
		Result result = new Result();
		String descStr = "获取Boss小程序菜单集合";
		List<BossMenuVo> dataList = new ArrayList<BossMenuVo>();
		try {
			dataList = bossCommonService.getBossMenuList(employeeVo);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	
	/**
	 * 获取报表权限
	 * @author hmj
	 * @param menuCode 报表菜单码
	 * @version [版本,2018-7-10]
	 */
	@AuthValidate
	@RequestMapping("/getBossAuthValidate")
	@ResponseBody
	public Result getBossAuthValidate(String menuCode){
		Assert.notNull(menuCode,"菜单码参数不能为空!!!");//权限码参数不为空
		LoginEmployeeVo employeeVo = super.getCurrentEmployeeVo();
		Assert.notNull(employeeVo, ErrorCode.NOT_LOGGED_IN);
		Result result = new Result();
		String descStr ="获取报表权限";
		try {
			result = bossCommonService.getBossAuthValidate(employeeVo,menuCode,result);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	
	/**
	 * 获取商品类别集合
	 * @author hmj
	 * @param onlyQueryOneLevelGoodsclass 为true是一级类别.为false是全部类别
	 * @version [版本,2018-7-10]
	 */
	@AuthValidate
	@RequestMapping("/getGoodsClassList")
	@ResponseBody
	public Result getGoodsClassVoList(@RequestParam(defaultValue="true")Boolean onlyQueryOneLevelGoodsclass){
		LoginEmployeeVo employeeVo = super.getCurrentEmployeeVo();
		Assert.notNull(employeeVo, ErrorCode.NOT_LOGGED_IN);
		Result result = new Result();
		String descStr = "获取商品类别集合";
		List<GoodsClassVo> dataList = new ArrayList<GoodsClassVo>();
		try {
			dataList = bossCommonService.getGoodsClassVoList(employeeVo,onlyQueryOneLevelGoodsclass,result);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	
	/**
	 * 获取商品品牌集合
	 * @author hmj
	 * @param keyWord 模糊查询
	 * @param page 当前页码
	 * @param pageSize 每页最大显示数
	 * @version [版本,2018-7-10]
	 */
	@AuthValidate
	@RequestMapping("/getGoodsBrandList")
	@ResponseBody
	public Result getGoodsBrandList(String keyWord){
		LoginEmployeeVo employeeVo = super.getCurrentEmployeeVo();
		Assert.notNull(employeeVo, ErrorCode.NOT_LOGGED_IN);
		Result result = new Result();
		String descStr = "获取商品品牌集合";
		List<GoodsBrandVo> dataList = new ArrayList<GoodsBrandVo>();
		try {
			dataList = bossCommonService.getGoodsBrandList(employeeVo,keyWord);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	
	/**
	 * 获取公司部门集合
	 * @author hmj
	 * @param keyWord:模糊查询
	 * @param page 当前页码
	 * @param pageSize 每页最大显示数
	 * @version [版本,2018-7-10]
	 */
	@AuthValidate
	@RequestMapping("/getCompanySectionList")
	@ResponseBody
	public Result getCompanySectionList(String menuCode){
		LoginEmployeeVo employeeVo = super.getCurrentEmployeeVo();
		Assert.notNull(employeeVo, ErrorCode.NOT_LOGGED_IN);
		Result result = new Result();
		String descStr = "获取公司部门集合";
		List<BossCompanyVo> dataList = new ArrayList<BossCompanyVo>();
		try {
			dataList = bossCommonService.getMenuCodeCompanyList(employeeVo,menuCode);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	/**
	 * 获取用户可使用公司下往来单位(供应商、客户)分页集合
	 * @author hmj
	 * @param keyWord 模糊查询(供应商编码,供应商名称)
	 * @param menuCode 报表菜单码
	 * @version [版本,2018-7-18]
	 */
	@AuthValidate
	@RequestMapping("/getContactUnitList")
	@ResponseBody
	public Result getContactUnits(BossQueryVo queryVo){
		Assert.notNull(queryVo.getMenuCode(),"权限码参数不能为空");//权限码参数不为空
		LoginEmployeeVo employeeVo = super.getCurrentEmployeeVo();
		Assert.notNull(employeeVo, ErrorCode.NOT_LOGGED_IN);
		queryVo.setEmployeeVo(employeeVo);
		Result result = new Result();
		String descStr = "获取用户可使用公司下往来单位(供应商、客户)分页集合";
		List<BossContactUnitVo> dataList = new ArrayList<BossContactUnitVo>();
		try {
			dataList = bossCommonService.getContactUnits(queryVo);
			result.put("dataList", dataList);
			
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	
}
