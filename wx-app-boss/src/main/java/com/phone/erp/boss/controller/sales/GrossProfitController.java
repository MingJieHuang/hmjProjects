package com.phone.erp.boss.controller.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import com.phone.erp.boss.controller.BossCommonController;
import com.phone.erp.boss.service.sales.GrossProfitService;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [毛利战报控制层]
 *
 * @author HMJ
 * @version [版本, 2018-7-18]
 * @see
 */
@Controller
@RequestMapping("${project.url.prefix}/report/sales/grossProfit")
public class GrossProfitController extends BossCommonController {

    @Autowired
    private GrossProfitService grossProfitService;

    /**
     * 获取毛利战报主页数据
     *
     * @param keyWord      模糊查询
     * @param page         当前页码
     * @param pageSize     每页最大显示数
     * @param goodsClassId 商品一级分类id
     * @param goodsBrandId 商品品牌id
     * @param menuCode     报表菜单码
     * @param salesType    销售类型  全部:空 ,零售:1,销售:2
     * @param groupField   按分组字段分组
     * @param startDate    查询起始时间
     * @param endDate      查询截止时间
     * @throws Exception
     * @author hmj
     * @version [版本, 2018-7-16]
     */
    @AuthValidate
    @RequestMapping("/getGrossProfitData")
    @ResponseBody
    public Result getGrossProfitData(BossQueryVo queryVo) throws Exception {
        queryVo.setMenuCode("BOSS_MLZB");
        Assert.notNull(queryVo.getGroupField(), "分组字段参数不为空");//分组字段参数不为空
        String groupFields = "goodsClassName,goodsBrandName,sectionName,salesManName,goodsName";
        Assert.isTrue(groupFields.contains(queryVo.getGroupField()), "分组字段不合法!!");
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return grossProfitService.getGrossProfitData(queryVo);
    }

    /**
     * 获取毛利战报主页总计行对象
     *
     * @param keyWord      模糊查询
     * @param goodsClassId 商品一级分类id
     * @param goodsBrandId 商品品牌id
     * @param menuCode     报表菜单码
     * @param salesType    销售类型  全部:空 ,零售:1,销售:2
     * @param startDate    查询起始时间
     * @param endDate      查询截止时间
     * @throws Exception
     * @author hmj
     * @version [版本, 2018-7-16]
     */
    @AuthValidate
    @RequestMapping("/getGrossProfitTotalVo")
    @ResponseBody
    public Result getGrossProfitTotalVo(BossQueryVo queryVo) throws Exception {
        queryVo.setMenuCode("BOSS_MLZB");
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return grossProfitService.getGrossProfitTotalVo(queryVo);
    }

    /**
     * 获取毛利战报明细页数据(分页)
     *
     * @param keyWord      模糊查询
     * @param page         当前页码
     * @param pageSize     每页最大显示数
     * @param goodsClassId 商品一级分类id
     * @param goodsBrandId 商品品牌id
     * @param menuCode     报表菜单码
     * @param salesType    销售类型  全部:空 ,零售:1,销售:2
     * @param groupField   按分组字段分组
     * @param startDate    查询起始时间
     * @param endDate      查询截止时间
     * @param nodeName     点击节点的name
     * @param nodeId       点击节点的id
     * @throws Exception
     * @author hmj
     * @version [版本, 2018-7-18]
     */
    @AuthValidate
    @RequestMapping("/getGrossProfitDetailData")
    @ResponseBody
    public Result getGrossProfitDetailData(BossQueryVo queryVo, String nodeName, Long nodeId) throws Exception {
        queryVo.setMenuCode("BOSS_MLZB");
        Assert.notNull(nodeId, "节点id不能为空!!");//节点id不为空
        String groupFields = "goodsClassName,goodsBrandName,sectionName,salesManName,goodsName";
        Assert.isTrue(groupFields.contains(queryVo.getGroupField()), "分组字段不合法!!");
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return grossProfitService.getGrossProfitDetailData(queryVo, nodeName, nodeId);
    }

    /**
     * 获取毛利战报详情页总计行对象
     *
     * @param keyWord      模糊查询
     * @param goodsClassId 商品一级分类id
     * @param goodsBrandId 商品品牌id
     * @param menuCode     报表菜单码
     * @param salesType    销售类型  全部:空 ,零售:1,销售:2
     * @param groupField   按分组字段分组
     * @param startDate    查询起始时间
     * @param endDate      查询截止时间
     * @param nodeName     点击节点的name
     * @param nodeId       点击节点的id
     * @throws Exception
     * @author hmj
     * @version [版本, 2018-7-18]
     */
    @AuthValidate
    @RequestMapping("/getGrossProfitDetailTotalVo")
    @ResponseBody
    public Result getGrossProfitDetailTotalVo(BossQueryVo queryVo, String nodeName, Long nodeId) throws Exception {
        queryVo.setMenuCode("BOSS_MLZB");
        Assert.notNull(nodeId, "节点id不能为空!!");//节点id不为空
        String groupFields = "goodsClassName,goodsBrandName,sectionName,salesManName,goodsName";
        Assert.isTrue(groupFields.contains(queryVo.getGroupField()), "分组字段不合法!!");
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return grossProfitService.getGrossProfitDetailTotalVo(queryVo, nodeName, nodeId);
    }
}
