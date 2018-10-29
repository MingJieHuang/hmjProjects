package com.phone.erp.boss.controller.storage;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.storage.TurnOverDayRateService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [周转天数分页控制层]
 * @author hmj
 * @create 2018-08-27 17:41
 */
@Controller
@RequestMapping("${project.url.prefix}/report/storage/turnOverDayRate")
public class TurnOverDayRateController extends ReportBaseController {
    @Autowired
    private TurnOverDayRateService turnOverDayRateService;
    /**
     * [获取周转天数分析主页数据]
     * 作者:hmj
     * 创建时间:2018/8/27
     */
    @AuthValidate
    @RequestMapping("/getPageData")
    @ResponseBody
    public Result getPageData(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_ZZTSFX");//设置菜单码
        queryVo.setDestStr("获取周转天数分析主页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return turnOverDayRateService.getPageData(queryVo, paramMap, result);
    }
    
}
