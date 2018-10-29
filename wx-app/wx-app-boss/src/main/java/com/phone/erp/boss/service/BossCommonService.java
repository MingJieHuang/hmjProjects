package com.phone.erp.boss.service;

import java.util.List;
import java.util.Map;

import com.phone.erp.base.Result;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import com.phone.erp.boss.vo.common.*;

/**
 * [Boos公共业务层]
 * 
 * @author HMJ
 * @version [版本,2018-7-10]
 * @see
 */

public interface BossCommonService {

	/**
	 * [获取报表权限]
	 * 
	 * @author hmj
	 * @version [版本,2018-7-10]
	 */
	public Result getBossAuthValidate(LoginEmployeeVo employeeVo,
			String menuCode, Result result);

	/**
	 * [获取Boss小程序菜单集合(不分页,固定长度)]
	 * 
	 * @author hmj
	 * @version [版本,2018-7-10]
	 */
	public List<BossMenuVo> getBossMenuList(LoginEmployeeVo employeeVo);

	/**
	 * [获取一级类别集合]
	 * 
	 * @author hmj
	 * @param onlyQueryOneLevelGoodsclass
	 *            为true是一级类别.为false是全部类别
	 * @version [版本,2018-7-11]
	 */
	public List<GoodsClassVo> getGoodsClassVoList(LoginEmployeeVo employeeVo,
			Boolean onlyQueryOneLevelGoodsclass, Result result);

	/**
	 * 获取商品品牌集合(分页)
	 * 
	 * @author hmj
	 * @param keyWord
	 *            模糊查询
	 * @version [版本,2018-7-10]
	 */
	public List<GoodsBrandVo> getGoodsBrandList(LoginEmployeeVo employeeVo,String keyWord);
			
	/**
	 * 获取当前登录员工在该下报表有权限的公司集合
	 * 
	 * @author hmj
	 * @param employeeVo 当前登录人
	 * @param menuCode 报表菜单码
	 * @version [版本,2018-7-11]
	 */
	List<BossCompanyVo> getMenuCodeCompanyList(LoginEmployeeVo employeeVo, String menuCode);

	/**
	 * 获取公司部门集合
	 * 
	 * @author hmj
	 * @param dataList
	 *            不含部门的公司集合
	 * @version [版本,2018-7-11]
	 * @param employeeVo 
	 */
	public void putSectionListInCompany(LoginEmployeeVo employeeVo, List<BossCompanyVo> dataList);
			
	/**
	 * [获取用户可使用公司下往来单位(供应商、客户)分页集合]
	 * @author HMJ
	 * @version [版本,2018-7-18] 
	 * @throws Exception 
	 */
	public List<BossContactUnitVo> getContactUnits(BossQueryVo queryVo) throws Exception;

	/**
	 * [权限验证]
	 * @author HMJ
	 * @version [版本,2018-7-18] 
	 */
	public void authValidate(BossQueryVo queryVo, Result result);

	/**
	 * [加工报表查询参数]
	 * @author HMJ
	 * @version [版本,2018-7-18] 
	 * @throws Exception 
	 */
	public Map<String, Object> getParamMap(BossQueryVo queryVo) throws Exception;

	/**
	 * [获取运营商名称集合]
	 * @author HMJ
	 * @version [版本,2018-8-22]
	 * @throws Exception
	 * @param queryVo
	 */
	public List<BossConditionVo> getOperatorList(BossQueryVo queryVo) throws Exception;

	/**
	 * [获取运营商单位集合]
	 * @author HMJ
	 * @version [版本,2018-8-22]
	 * @throws Exception
	 * @param queryVo
	 */
	List<BossConditionVo> getOperatorUnitList(BossQueryVo queryVo) throws Exception;
	/**
	 * [获取运营商业务名称集合]
	 * @author HMJ
	 * @version [版本,2018-8-23]
	 * @throws Exception
	 * @param queryVo
	 */
	List<BossConditionVo> getOperatorNameList(BossQueryVo queryVo) throws Exception;
	/**
	 * 获取抵扣单位集合
	 * @author hmj
	 * @version [版本,2018-8-28]
	 */
    List<BossConditionVo> getDeductionUnitsList(BossQueryVo queryVo) throws Exception;
	/**
	 * 获取抵扣活动集合
	 * @author hmj
	 * @version [版本,2018-8-28]
	 */
	List<BossConditionVo> getActivityNamesList(BossQueryVo queryVo) throws Exception;
	/**
	 * 获取分期商名称集合
	 * @author hmj
	 * @version [版本,2018-8-28]
	 */
	List<BossConditionVo> getInstallmentfeesList(BossQueryVo queryVo) throws Exception;
    /**
     * 获取分期业务名称集合
     * @author hmj
     * @version [版本,2018-8-28]
     */
    List<InstallmentBusinessVo> getInstallmentBusinessList(BossQueryVo queryVo) throws Exception;
	/**
	 * 获取资金账户类型集合
	 * @author hmj
	 * @version [版本,2018-8-30]
	 */
    List<BossConditionVo> getAccountTypeList() throws Exception;
	/**
	 * 获取公司集合
	 * @author hmj
	 * @version [版本,2018-9-07]
	 */
    List<BossCompanyVo> getCompanyList(LoginEmployeeVo employeeVo, String menuCode);
	/**
	 * 获取增值服务名称集合
	 * @author hmj
	 * @version [版本,2018-9-11]
	 * @param queryVo
	 */
    List<BossConditionVo> getAddValueServiceNameList(BossQueryVo queryVo) throws Exception;
}
