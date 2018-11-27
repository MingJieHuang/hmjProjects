package com.phone.erp.boss.controller.contact;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.contact.MyContactUnitService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [我的往来控制层]
 * @author HMJ
 * @version [版本,2018-8-15]
 * @see 
 */
@Controller
@RequestMapping("${project.url.prefix}/report/contact/myContactUnit")
public class MyContactUnitController extends ReportBaseController {
	@Autowired
	private MyContactUnitService myContactUnitService;

	/**
	 * [我的往来获取主页分页集合]
	 * @param queryVo
	 * @return
	 * @throws Exception
	 */
	@AuthValidate
	@RequestMapping("/getPageData")
	@ResponseBody
	public Result getPageData(BossQueryVo queryVo) throws Exception{
	    setCurrentEmp(queryVo);
	    queryVo.setMenuCode("BOSS_WDWL");//设置菜单码
	    queryVo.setDestStr("获取我的往来主页分页数据");
	    //这里设置断言和特殊查询参数
	    Result result = new Result();
	    Map<String, Object> paramMap = getParamMap(queryVo,result);
	    return myContactUnitService.getPageData(queryVo, paramMap, result);
	}

	/**
	 * [我的往来获取主页总计行对象]
	 * @param queryVo
	 * @return
	 * @throws Exception
	 */
	@AuthValidate
	@RequestMapping("/getTotalVo")
	@ResponseBody
	public Result getTotalVo(BossQueryVo queryVo) throws Exception{
		setCurrentEmp(queryVo);
		queryVo.setMenuCode("BOSS_WDWL");//设置菜单码
		queryVo.setDestStr("获取我的往来主页总计行数据");
		Result result = new Result();
		Map<String, Object> paramMap = getParamMap(queryVo,result);
		return myContactUnitService.getTotalVo(queryVo, paramMap, result);
	}

}
