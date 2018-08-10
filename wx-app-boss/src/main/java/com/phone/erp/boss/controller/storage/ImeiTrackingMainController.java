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
import com.phone.erp.boss.service.storage.ImeiTrackingMainService;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [串号跟踪控制层]
 *
 * @author HMJ
 * @version [版本, 2018-7-19]
 * @see
 */
@Controller
@RequestMapping("${project.url.prefix}/report/storage/imeiTrackingMain")
public class ImeiTrackingMainController extends BaseController {
    @Autowired
    private ImeiTrackingMainService imeiTrackingMainService;

    /**
     * 获取串号跟踪主页分页集合
     *
     * @param keyWord  模糊查询
     * @param page     当前页码
     * @param pageSize 每页最大显示数
     * @param menuCode 报表菜单码
     * @author hmj
     * @version [版本, 2018-7-13]
     */
    @AuthValidate
    @RequestMapping("/getImeiTrackingMainData")
    @ResponseBody
    public Result getImeiTrackingMainData(BossQueryVo queryVo) throws Exception {
        queryVo.setMenuCode("BOSS_CHGZ");
        Assert.notNull(queryVo.getKeyWord(), "串号参数不为空");//串号参数不为空
        String imei = queryVo.getKeyWord().trim().toUpperCase().replaceAll("\\s+", "");
        Assert.isTrue(imei.length() >= 5, "串号至少输入5位!");
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setKeyWord(imei);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return imeiTrackingMainService.getImeiTrackingMainData(queryVo);
    }

    /**
     * 获取串号跟踪流水表集合
     *
     * @param imeiId   串号id必填
     * @param menuCode 报表菜单码
     * @author hmj
     * @version [版本, 2018-7-13]
     */
    @AuthValidate
    @RequestMapping("/getImeiTrackingDetailData")
    @ResponseBody
    public Result getImeiTrackingDetailData(BossQueryVo queryVo) throws Exception {
        queryVo.setMenuCode("BOSS_CHGZ");
        Assert.notNull(queryVo.getImeiId(), "串号参数不为空!!");//串号参数不为空
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        Assert.notNull(currentEmployeeVo, ErrorCode.NOT_LOGGED_IN);
        queryVo.setEmployeeVo(currentEmployeeVo);
        return imeiTrackingMainService.getImeiTrackingDetailData(queryVo);
    }
}
