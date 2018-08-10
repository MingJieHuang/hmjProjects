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
import com.phone.erp.boss.service.storage.CurrentStockService;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [实时库存报表控制层]
 *
 * @author HMJ
 * @version [版本, 2018-7-12]
 * @see
 */
@Controller
@RequestMapping("${project.url.prefix}/report/storage/currentStock")
public class CurrentStockController extends BaseController {
    @Autowired
    private CurrentStockService currentStockService;

    /**
     * 获取实时库存主页数据集合
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
    @RequestMapping("/getCurrentStockData")
    @ResponseBody
    public Result getCurrentStockData(BossQueryVo queryVo) throws Exception {
        queryVo.setMenuCode("BOSS_SSKC");
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return currentStockService.getCurrentStockData(queryVo);
    }

    /**
     * 获取实时库存主页总计行对象
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
    @RequestMapping("/getCurrentStockTotalVo")
    @ResponseBody
    public Result getCurrentStockTotalVo(BossQueryVo queryVo) throws Exception {
        queryVo.setMenuCode("BOSS_SSKC");
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return currentStockService.getCurrentStockTotalVo(queryVo);
    }

    /**
     * 获取实时库存详情页分页集合
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
    @RequestMapping("/getCurrentStockDetailData")
    @ResponseBody
    public Result getCurrentStockDetailData(BossQueryVo queryVo) throws Exception {
        queryVo.setMenuCode("BOSS_SSKC");
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return currentStockService.getCurrentStockDetailData(queryVo);
    }

    /**
     * 获取实时库存详情页总计行对象
     *
     * @param keyWord             模糊查询
     * @param companySectionParam 公司部门参数
     * @param goodsId             商品id
     * @param menuCode            报表菜单码
     * @author hmj
     * @version [版本, 2018-7-13]
     */
    @AuthValidate
    @RequestMapping("/getCurrentStockDetailTotalVo")
    @ResponseBody
    public Result getCurrentStockDetailTotalVo(BossQueryVo queryVo) throws Exception {
        queryVo.setMenuCode("BOSS_SSKC");
        Assert.notNull(queryVo.getGoodsId(), "商品id参数不为空");//商品id参数不为空
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return currentStockService.getCurrentStockDetailTotalVo(queryVo);
    }


    /**
     * 获取商品详情对象
     *
     * @param goodsId 商品id
     * @author hmj
     * @version [版本, 2018-7-13]
     */
    @AuthValidate
    @RequestMapping("/getGoodsDetailVo")
    @ResponseBody
    public Result getGoodsVo(Long goodsId) throws Exception {
        Assert.notNull(goodsId, "商品id参数不为空");//商品id参数不为空
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        return currentStockService.getGoodsVo(goodsId);
    }

}
