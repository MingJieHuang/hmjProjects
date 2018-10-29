package com.phone.erp.boss.controller.sales;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.sales.SalesRankingService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [销售排行控制类]
 * @author hmj
 * @create 2018-08-18 14:32
 */
@Controller
@RequestMapping("${project.url.prefix}/report/sales/salesRanking")
public class SalesRankingController extends ReportBaseController {
    @Autowired
    private  SalesRankingService salesRankingService;


    /**
     * [销售排行获取主页分页集合]
     * @param queryVo
     * @return
     * @throws Exception
     */
  @AuthValidate
  @RequestMapping("/getPageData")
  @ResponseBody
  public Result getPageData(BossQueryVo queryVo) throws Exception{
      Assert.notNull(queryVo.getRankingGist(), "排行依据参数不能为空!!");
      Assert.notNull(queryVo.getGroupField(), "分组参数不能为空!!");
      setCurrentEmp(queryVo);
      queryVo.setMenuCode("BOSS_XSPH");//设置菜单码
      queryVo.setDestStr("获取销售排行主页分页数据");
      //这里设置断言和特殊查询参数
      Result result = new Result();
      Map<String, Object> paramMap = getParamMap(queryVo,result);
      return salesRankingService.getPageData(queryVo, paramMap, result);
  }


}
