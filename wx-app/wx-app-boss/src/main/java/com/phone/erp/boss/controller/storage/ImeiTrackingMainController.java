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
import com.phone.erp.boss.service.storage.ImeiTrackingMainService;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [串号跟踪控制层]
 * @author HMJ
 * @version [版本,2018-7-19]
 * @see 
 */
@Controller
@RequestMapping("${project.url.prefix}/report/storage/imeiTrackingMain")
public class ImeiTrackingMainController extends ReportBaseController {
	@Autowired
	private ImeiTrackingMainService imeiTrackingMainService;
	/**
	 * 获取串号跟踪主页分页集合
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-13]
	 */
	@AuthValidate
	@RequestMapping("/getImeiTrackingMainData")
	@ResponseBody
	public Result getImeiTrackingMainData(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		Assert.notNull(queryVo.getKeyWord(),"串号参数不为空");//串号参数不为空
		String imei = queryVo.getKeyWord().trim().toUpperCase().replaceAll("\\s+", "");
		Assert.isTrue(imei.length() >= 5, "串号至少输入5位!");
		queryVo.setKeyWord(imei);
		queryVo.setMenuCode("BOSS_CHGZ");
		queryVo.setDestStr("获取串号跟踪主页分页集合");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return imeiTrackingMainService.getPageData(queryVo,paramMap,result);
	}
	/**
	 * 获取串号跟踪流水表集合
	 * @author hmj
	 * @param queryVo
	 * @version [版本,2018-7-13]
	 */
	@AuthValidate
	@RequestMapping("/getImeiTrackingDetailData")
	@ResponseBody
	public Result getImeiTrackingDetailData(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		Assert.notNull(queryVo.getImeiId(),"串号参数不为空!!");//串号参数不为空
		queryVo.setMenuCode("BOSS_CHGZ");
		queryVo.setDestStr("获取串号跟踪流水表集合");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return imeiTrackingMainService.getImeiTrackingDetailData(queryVo,paramMap,result);
	}
}
