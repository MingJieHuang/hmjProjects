package com.phone.erp.boss.controller.sales;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.sales.WholesaleReportService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [批发战报控制层]
 * @author hmj
 * @create 2018-08-27 15:40
 */
@Controller
@RequestMapping("${project.url.prefix}/report/sales/wholesaleReport")
public class WholesaleReportController extends ReportBaseController {
    @Autowired
    private WholesaleReportService wholesaleReportService;
    /**
     * [获取批发战报分页集合]
     * 作者:hmj
     * 创建时间:2018/8/27
     */
    @AuthValidate
    @RequestMapping("/getPageData")
    @ResponseBody
    public Result getPageData(BossQueryVo queryVo) throws Exception{
        Assert.notNull(queryVo.getGroupField(), "分组参数不能为空!!");
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_PFZB");//设置菜单码
        queryVo.setDestStr("获取批发战报主页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return wholesaleReportService.getPageData(queryVo, paramMap, result);
    }

    /**
     * [获取批发战报主页总计行对象]
     * 作者:hmj
     * 创建时间:2018/8/27
     */
    @AuthValidate
    @RequestMapping("/getTotalVo")
    @ResponseBody
    public Result getTotalVo(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_PFZB");//设置菜单码
        queryVo.setDestStr("获取批发战报主页总计行数据");
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return wholesaleReportService.getTotalVo(queryVo, paramMap, result);
    }
    
}
