package com.phone.erp.boss.controller.retail;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.retail.ValueAddedReportService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [增值服务战报控制层]
 * @author hmj
 * @create 2018-08-27 10:47
 */
@Controller
@RequestMapping("${project.url.prefix}/report/retail/valueAddedReport")
public class ValueAddedReportController extends ReportBaseController {
    @Autowired
    private ValueAddedReportService valueAddedReportService;

    /**
     * [获取增值服务战报主页分页集合]
     * 作者:hmj
     * 创建时间:2018/8/27
     */
    @AuthValidate
    @RequestMapping("/getPageData")
    @ResponseBody
    public Result getPageData(BossQueryVo queryVo) throws Exception {
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_ZZFWZB");//设置菜单码
        queryVo.setDestStr("获取增值服务战报主页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo, result);
        return valueAddedReportService.getPageData(queryVo, paramMap, result);
    }

    /**
     * [获取增值服务战报主页总计行对象]
     * 作者:hmj
     * 创建时间:2018/8/27
     */
    @AuthValidate
    @RequestMapping("/getTotalVo")
    @ResponseBody
    public Result getTotalVo(BossQueryVo queryVo) throws Exception {
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_ZZFWZB");//设置菜单码
        queryVo.setDestStr("获取增值服务战报主页总计行数据");
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo, result);
        return valueAddedReportService.getTotalVo(queryVo, paramMap, result);
    }

}