package com.phone.erp.boss.controller.purchase;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.purchase.PurchaseSalesCompareService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [进销对比控制层]
 * @author hmj
 * @create 2018-08-18 16:53
 */
@Controller
@RequestMapping("${project.url.prefix}/report/purchase/purchaseSalesCompare")
public class PurchaseSalesCompareController extends ReportBaseController {
    @Autowired
    PurchaseSalesCompareService purchaseSalesCompareService;

    /**
     * [进销对比获取主页分页集合]
     * @param queryVo
     * @return
     * @throws Exception
     */
    @AuthValidate
    @RequestMapping("/getPageData")
    @ResponseBody
    public Result getPageData(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_JXDB");//设置菜单码
        queryVo.setDestStr("获取进销对比主页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return purchaseSalesCompareService.getPageData(queryVo, paramMap, result);
    }
    /**
     * [获取进销对比主页总计行对象]
     * 作者:hmj
     * 创建时间:2018/9/6
     */
    @AuthValidate
    @RequestMapping("/getTotalVo")
    @ResponseBody
    public Result getTotalVo(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_JXDB");//设置菜单码
        queryVo.setDestStr("获取进销对比主页总计行数据");
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return purchaseSalesCompareService.getTotalVo(queryVo, paramMap, result);
    }
    
}
