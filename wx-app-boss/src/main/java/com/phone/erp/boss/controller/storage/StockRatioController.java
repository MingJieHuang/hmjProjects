package com.phone.erp.boss.controller.storage;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.storage.StockRatioService;
import com.phone.erp.boss.util.BossReportUtil;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
     * [获取库存占比(不分页)数据]
     * 作者:hmj
     * 创建时间:2018-09-04
     */
    @AuthValidate
    @RequestMapping("/getDataList")
    @ResponseBody
    public Result getDataList(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_KCZB");//设置菜单码
        queryVo.setDestStr("获取库存占比主页分页数据");
        //这里设置断言和特殊查询参数,设置当前日期
        queryVo.setStartDate(BossReportUtil.getCurDate(null));
        Assert.notNull(queryVo.getGroupField(),"分组字段参数不为空!");
        Assert.notNull(queryVo.getOrderField(),"排序字段参数不为空!");
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        if ("goodsAmount".equals(queryVo.getOrderField())&&!queryVo.getCanSeeAmount()){
            result.setCode("0000");
            result.setDesc("您没有查看成本价权限,请联系公司管理员!!");
            return result;
        }
        return stockRatioService.getDataList(queryVo, paramMap, result);
    }
}
