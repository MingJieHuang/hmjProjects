package com.phone.erp.boss.controller.sales;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.sales.SalesTrendService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [销售走势控制层]
 * @author hmj
 * @create 2018-08-27 14:37
 */
@Controller
@RequestMapping("${project.url.prefix}/report/sales/salesTrend")
public class SalesTrendController extends ReportBaseController {
    @Autowired
    private SalesTrendService salesTrendService;
    /**
     * [获取销售走势主页(不分页)集合]
     * 作者:hmj
     * 创建时间:2018/8/27
     */
    @AuthValidate
    @RequestMapping("/getDataList")
    @ResponseBody
    public Result getDataList(BossQueryVo queryVo) throws Exception{
        Assert.notNull(queryVo.getRankingGist(), "排行依据参数不能为空!!");
        Assert.notNull(queryVo.getGroupField(), "分组参数不能为空!!");
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_XSZS");//设置菜单码
        queryVo.setDestStr("获取销售走势主页(不分页)数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return salesTrendService.getDataList(queryVo, paramMap, result);
    }
}
