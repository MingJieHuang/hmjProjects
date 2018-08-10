package com.phone.erp.boss.controller.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.controller.BaseController;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import com.phone.erp.boss.service.storage.StockDistributionService;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [库存分布报表控制层]
 *
 * @author HMJ
 * @version [版本, 2018-7-16]
 * @see
 */
@Controller
@RequestMapping("${project.url.prefix}/report/storage/stockDistribution")
public class StockDistributionController extends BaseController {
    @Autowired
    private StockDistributionService stockDistributionService;

    /**
     * 获取库存分布主页数据集合
     *
     * @param keyWord      模糊查询
     * @param page         当前页码
     * @param pageSize     每页最大显示数
     * @param goodsClassId 商品一级分类id
     * @param goodsBrandId 商品品牌id
     * @param menuCode     报表菜单码
     * @author hmj
     * @version [版本, 2018-7-13]
     */
    @AuthValidate
    @RequestMapping("/getStockDistrData")
    @ResponseBody
    public Result getStockDistrData(BossQueryVo queryVo) throws Exception {
        queryVo.setMenuCode("BOSS_KCFB");
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return stockDistributionService.getStockDistrData(queryVo);
    }

    /**
     * 获取库存分布详情页分页集合
     *
     * @param keyWord             模糊查询
     * @param page                当前页码
     * @param pageSize            每页最大显示数
     * @param companySectionParam 公司部门参数
     * @param goodsId             商品id
     * @param menuCode            报表菜单码
     * @author hmj
     * @version [版本, 2018-7-13]
     */
    @AuthValidate
    @RequestMapping("/getStockDistrDetailData")
    @ResponseBody
    public Result getStockDistrDetailData(BossQueryVo queryVo) throws Exception {
        queryVo.setMenuCode("BOSS_KCFB");
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return stockDistributionService.getStockDistrDetailData(queryVo);
    }

    /**
     * 获取库存分布详情页总计行对象
     *
     * @param keyWord             模糊查询
     * @param companySectionParam 公司部门参数
     * @param goodsId             商品id
     * @param menuCode            报表菜单码
     * @author hmj
     * @version [版本, 2018-7-13]
     */
    @AuthValidate
    @RequestMapping("/getStockDistrDetailTotalVo")
    @ResponseBody
    public Result getStockDistrDetailTotalVo(BossQueryVo queryVo) throws Exception {
        queryVo.setMenuCode("BOSS_KCFB");
        Assert.notNull(queryVo.getGoodsId(), "商品id参数不为空");//商品id参数不为空
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return stockDistributionService.getStockDistrDetailTotalVo(queryVo);
    }

}
