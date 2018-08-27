package com.phone.erp.boss.controller.sales;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.sales.SalesContrastService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [销售对比控制层]
 * @author hmj
 * @create 2018-08-27 16:16
 */
@Controller
@RequestMapping("${project.url.prefix}/report/sales/salesContrast")
public class SalesContrastController extends ReportBaseController {
    @Autowired
    private SalesContrastService salesContrastService;
    /**
     * [获取销售对比主页分页集合]
     * 作者:hmj
     * 创建时间:2018/8/27
     */
    @AuthValidate
    @RequestMapping("/getPageData")
    @ResponseBody
    public Result getPageData(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_XSDB");//设置菜单码
        queryVo.setDestStr("获取销售对比主页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return salesContrastService.getPageData(queryVo, paramMap, result);
    }
    
}
