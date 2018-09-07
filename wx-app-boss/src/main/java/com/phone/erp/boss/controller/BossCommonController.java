package com.phone.erp.boss.controller;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.controller.BaseController;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.vo.company.CompanyVo;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import com.phone.erp.boss.service.BossCommonService;
import com.phone.erp.boss.util.BossReportUtil;
import com.phone.erp.boss.vo.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


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
	 * 获取公司集合
	 * @author hmj
	 * @version [版本,2018-9-07]
	 */
	@AuthValidate
	@RequestMapping("/getCompanyList")
	@ResponseBody
	public Result getCompanyList(String menuCode){
		LoginEmployeeVo employeeVo = super.getCurrentEmployeeVo();
		Assert.notNull(employeeVo, ErrorCode.NOT_LOGGED_IN);
		Result result = new Result();
		String descStr = "获取公司部门集合";
		List<BossCompanyVo> dataList = new ArrayList<BossCompanyVo>();
		try {
			dataList = bossCommonService.getCompanyList(employeeVo,menuCode);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	/**
	 * 获取用户可使用公司下往来单位(供应商、客户)分页集合
	 * @author hmj
	 * @version [版本,2018-7-18]
	 */
	@AuthValidate
	@RequestMapping("/getContactUnitList")
	@ResponseBody
	public Result getContactUnits(BossQueryVo queryVo){
		Assert.notNull(queryVo.getMenuCode(),"权限码参数不能为空");//权限码参数不为空
		setCurrentEmp(queryVo);
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


	/**
	 * 获取运营商名称集合(三大运营商)
	 * @author hmj
	 * @version [版本,2018-8-22]
	 */
	@AuthValidate
	@RequestMapping("/getOperatorList")
	@ResponseBody
	public Result getOperatorList(BossQueryVo queryVo){
		Result result = new Result();
		String descStr = "获取运营商名称集合";
		List<BossConditionVo> dataList = new ArrayList<BossConditionVo>();
		try {
			dataList = bossCommonService.getOperatorList(queryVo);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	/**
	 * 获取运营商单位集合
	 * @author hmj
	 * @version [版本,2018-8-22]
	 */
	@AuthValidate
	@RequestMapping("/getOperatorUnitList")
	@ResponseBody
	public Result getOperatorUnitList(BossQueryVo queryVo){
		Assert.notNull(queryVo.getMenuCode(),"权限码参数不能为空");//权限码参数不为空
		setCurrentEmp(queryVo);
		Result result = new Result();
		String descStr = "获取运营商单位集合";
		List<BossConditionVo> dataList = new ArrayList<BossConditionVo>();
		try {
			dataList = bossCommonService.getOperatorUnitList(queryVo);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	/**
	 * 获取运营商业务名称集合
	 * @author hmj
	 * @version [版本,2018-8-23]
	 */
	@AuthValidate
	@RequestMapping("/getOperatorNameList")
	@ResponseBody
	public Result getOperatorNameList(BossQueryVo queryVo){
		Assert.notNull(queryVo.getMenuCode(),"权限码参数不能为空");//权限码参数不为空
		setCurrentEmp(queryVo);
		Result result = new Result();
		String descStr = "获取运营商业务名称集合";
		List<BossConditionVo> dataList = new ArrayList<BossConditionVo>();
		try {
			dataList = bossCommonService.getOperatorNameList(queryVo);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	/**
	 * 获取抵扣单位集合
	 * @author hmj
	 * @version [版本,2018-8-28]
	 */
	@AuthValidate
	@RequestMapping("/getDeductionUnitsList")
	@ResponseBody
	public Result getDeductionUnitsList(BossQueryVo queryVo){
		Assert.notNull(queryVo.getMenuCode(),"权限码参数不能为空");//权限码参数不为空
		setCurrentEmp(queryVo);
		Result result = new Result();
		String descStr = "获取抵扣单位集合";
		List<BossConditionVo> dataList = new ArrayList<BossConditionVo>();
		try {
			dataList = bossCommonService.getDeductionUnitsList(queryVo);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	/**
	 * 获取抵扣活动集合
	 * @author hmj
	 * @version [版本,2018-8-28]
	 */
	@AuthValidate
	@RequestMapping("/getActivityNamesList")
	@ResponseBody
	public Result getActivityNamesList(BossQueryVo queryVo){
		Assert.notNull(queryVo.getMenuCode(),"权限码参数不能为空");//权限码参数不为空
		setCurrentEmp(queryVo);
		Result result = new Result();
		String descStr = "获取抵扣活动集合";
		List<BossConditionVo> dataList = new ArrayList<BossConditionVo>();
		try {
			dataList = bossCommonService.getActivityNamesList(queryVo);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	/**
	 * 获取分期商名称集合
	 * @author hmj
	 * @version [版本,2018-8-28]
	 */
	@AuthValidate
	@RequestMapping("/getInstallmentfeesList")
	@ResponseBody
	public Result getInstallmentfeesList(BossQueryVo queryVo){
		Assert.notNull(queryVo.getMenuCode(),"权限码参数不能为空");//权限码参数不为空
		setCurrentEmp(queryVo);
		Result result = new Result();
		String descStr = "获取分期商名称集合";
		List<BossConditionVo> dataList = new ArrayList<BossConditionVo>();
		try {
			dataList = bossCommonService.getInstallmentfeesList(queryVo);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	/**
	 * 获取分期业务名称集合
	 * @author hmj
	 * @version [版本,2018-8-28]
	 */
	@AuthValidate
	@RequestMapping("/getInstallmentBusinessList")
	@ResponseBody
	public Result getInstallmentBusinessList(BossQueryVo queryVo){
		Assert.notNull(queryVo.getMenuCode(),"权限码参数不能为空");//权限码参数不为空
		setCurrentEmp(queryVo);
		Result result = new Result();
		String descStr = "获取分期业务名称集合";
		List<InstallmentBusinessVo> dataList = new ArrayList<InstallmentBusinessVo>();
		try {
			dataList = bossCommonService.getInstallmentBusinessList(queryVo);
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}
	/**
	 * 获取资金账户类型集合
	 * @author hmj
	 * @version [版本,2018-8-30]
	 */
	@AuthValidate
	@RequestMapping("/getAccountTypeList")
	@ResponseBody
	public Result getAccountTypeList(){
		Result result = new Result();
		String descStr = "获取资金账户类型集合";
		List<BossConditionVo> dataList = new ArrayList<BossConditionVo>();
		try {
			dataList = bossCommonService.getAccountTypeList();
			result.put("dataList", dataList);
		} catch (Exception e) {
			return BossReportUtil.getFailingResult(result, descStr);
		}
		return BossReportUtil.getSuccessResult(result, descStr);
	}

	//--------------------------工具方法---------------
	protected void setCurrentEmp(BossQueryVo queryVo) {
		LoginEmployeeVo employeeVo = super.getCurrentEmployeeVo();
		Assert.notNull(employeeVo, ErrorCode.NOT_LOGGED_IN);
		queryVo.setEmployeeVo(employeeVo);
	}
}
