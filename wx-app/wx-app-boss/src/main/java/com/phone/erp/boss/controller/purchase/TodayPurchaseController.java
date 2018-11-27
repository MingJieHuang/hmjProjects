package com.phone.erp.boss.controller.purchase;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.purchase.TodayPurchaseService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [今日采购控制层]
 * @author hmj
 * @create 2018-08-21 17:38
 */
@Controller
@RequestMapping("${project.url.prefix}/report/purchase/todayPurchase")
public class TodayPurchaseController extends ReportBaseController {
    @Autowired
    private TodayPurchaseService todayPurchaseService;

    /**
     * 获取今日采购主页分页集合
     * @param queryVo
     * @return
     * @throws Exception
     */
    @AuthValidate
    @RequestMapping("/getPageData")
    @ResponseBody
    public Result getPageData(BossQueryVo queryVo) throws Exception{
        Assert.notNull(queryVo.getStartDate(), "日期参数不能为空");
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_JRCG");//设置菜单码
        queryVo.setDestStr("获取今日采购主页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        paramMap.put("companyIds",queryVo.getEmployeeVo().getCompanyId());
        return todayPurchaseService.getPageData(queryVo, paramMap, result);
    }

    /**
     * [获取今日采购主页总计行对象]
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
        queryVo.setMenuCode("BOSS_JRCG");//设置菜单码
        queryVo.setDestStr("获取今日采购主页总计行数据");
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        paramMap.put("companyIds",queryVo.getEmployeeVo().getCompanyId());
        return todayPurchaseService.getTotalVo(queryVo, paramMap, result);

    }

}
