package com.phone.erp.boss.controller.storage;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.storage.StockRatioService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [库存占比控制层]
 * @author hmj
 * @create 2018-08-24 14:29
 */
@Controller
@RequestMapping("${project.url.prefix}/report/storage/stockRatio")
public class StockRatioController extends ReportBaseController {
    @Autowired
    private StockRatioService stockRatioService;
    /**
     * [获取库存占比主页分页数据]
     * 作者:hmj
     * 创建时间:2018-08-24
     */
    @AuthValidate
    @RequestMapping("/getPageData")
    @ResponseBody
    public Result getPageData(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_KCZB");//设置菜单码
        queryVo.setDestStr("获取库存占比主页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return stockRatioService.getPageData(queryVo, paramMap, result);
    }


}
