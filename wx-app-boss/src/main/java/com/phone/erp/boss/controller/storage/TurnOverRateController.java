package com.phone.erp.boss.controller.storage;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.storage.TurnOverRateService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [周转率分析控制层]
 * @author hmj
 * @create 2018-08-27 17:09
 */
@Controller
@RequestMapping("${project.url.prefix}/report/storage/turnOverRate")
public class TurnOverRateController extends ReportBaseController {
    @Autowired
    private TurnOverRateService turnOverRateService;
    /**
     * [获取周转率分析主页集合]
     * 作者:hmj
     * 创建时间:2018/8/27
     */
    @AuthValidate
    @RequestMapping("/getDataList")
    @ResponseBody
    public Result getDataList(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        Assert.notNull(queryVo.getGroupField(), "分组参数不能为空!!");
        Assert.notNull(queryVo.getStartDate(), "初始日期参数不能为空!!");
        Assert.notNull(queryVo.getEndDate(), "截止日期参数不能为空!!");
        queryVo.setMenuCode("BOSS_ZZLFX");//设置菜单码
        queryVo.setDestStr("获取周转率分析主页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return turnOverRateService.getDataList(queryVo, paramMap, result);
    }
    
}
