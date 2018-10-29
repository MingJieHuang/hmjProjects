package com.phone.erp.boss.controller.storage;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.storage.UnsalableStockService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [滞销库存控制层]
 * @author hmj
 * @create 2018-08-24 15:23
 */
@Controller
@RequestMapping("${project.url.prefix}/report/storage/unsalableStock")
public class UnsalableStockController extends ReportBaseController {
    @Autowired
    private UnsalableStockService unsalableStockService;
    /**
     * [获取滞销库存主页分页集合]
     * 作者:hmj
     * 创建时间:2018-08-24
     */
    @AuthValidate
    @RequestMapping("/getPageData")
    @ResponseBody
    public Result getPageData(BossQueryVo queryVo) throws Exception{
        Assert.notNull(queryVo.getStockAge(), "库龄天数参数不能为空!!");
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_ZXKC");//设置菜单码
        queryVo.setDestStr("获取滞销库存主页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return unsalableStockService.getPageData(queryVo, paramMap, result);
    }
    
    /**
     * [获取滞销库存主页总计行对象]
     * 作者:hmj
     * 创建时间: 2018-08-24
     */
    @AuthValidate
    @RequestMapping("/getTotalVo")
    @ResponseBody
    public Result getTotalVo(BossQueryVo queryVo) throws Exception{
        Assert.notNull(queryVo.getStockAge(), "库龄天数参数不能为空!!");
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_ZXKC");//设置菜单码
        queryVo.setDestStr("获取滞销库存主页总计行数据");
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return unsalableStockService.getTotalVo(queryVo, paramMap, result);
    }
    /**
     * [获取滞销库存详情页分页数据]
     * 作者:hmj
     * 创建时间:2018/8/24
     */
    @AuthValidate
    @RequestMapping("/getDetailPageData")
    @ResponseBody
    public Result getDetailPageData(BossQueryVo queryVo) throws Exception{
        Assert.notNull(queryVo.getGoodsId(), "商品id参数不能为空!!");
        Assert.notNull(queryVo.getStockAge(), "库龄天数参数不能为空!!");
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_ZXKC");//设置菜单码
        queryVo.setDestStr("获取滞销库存详情页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return unsalableStockService.getDetailPageData(queryVo, paramMap, result);
    }

    /**
     * [获取滞销库存详情页总计行数据]
     * 作者:hmj
     * 创建时间:2018/8/24
     */
    @AuthValidate
    @RequestMapping("/getDetailTotalVo")
    @ResponseBody
    public Result getDetailTotalVo(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_ZXKC");//设置菜单码
        queryVo.setDestStr("获取滞销库存详情页总计行数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return unsalableStockService.getDetailTotalVo(queryVo, paramMap, result);
    }
    
}
