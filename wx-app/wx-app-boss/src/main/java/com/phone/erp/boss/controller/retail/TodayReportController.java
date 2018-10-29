package com.phone.erp.boss.controller.retail;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.retail.TodayReportService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [今日战报控制查]
 * @author hmj
 * @create 2018-08-18 17:42
 */
@Controller
@RequestMapping("${project.url.prefix}/report/retail/todayReport")
public class TodayReportController extends ReportBaseController {
    @Autowired
    private TodayReportService todayReportService;

    /**
     * [今日战报获取主页(不分页)集合]
     * @param queryVo
     * @return
     * @throws Exception
     */
    @AuthValidate
    @RequestMapping("/getDataList")
    @ResponseBody
    public Result getDataList(BossQueryVo queryVo) throws Exception{
        Assert.notNull(queryVo.getStartDate(), "日期参数不能为空");
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_JRZB");//设置菜单码
        queryVo.setDestStr("获取今日战报主页分页数据");
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        //这里设置断言和特殊查询参数(仅查当前登录公司的数据)
        paramMap.put("companyIds",queryVo.getEmployeeVo().getCompanyId());
        return todayReportService.getDataList(queryVo, paramMap, result);
    }

    /**
     * [今日战报获取主页总计行对象]
     * @param queryVo
     * @return
     * @throws Exception
     */
    @AuthValidate
    @RequestMapping("/getTotalVo")
    @ResponseBody
    public Result getTotalVo(BossQueryVo queryVo) throws Exception{
        Assert.notNull(queryVo.getStartDate(), "日期参数不能为空");
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_JRZB");//设置菜单码
        queryVo.setDestStr("获取今日战报主页总计行数据");
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        paramMap.put("companyIds",queryVo.getEmployeeVo().getCompanyId());
        return todayReportService.getTotalVo(queryVo, paramMap, result);
    }

}
