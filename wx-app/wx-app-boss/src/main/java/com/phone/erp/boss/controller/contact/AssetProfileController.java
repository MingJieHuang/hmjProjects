package com.phone.erp.boss.controller.contact;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.vo.BaseResultVo;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.contact.AssetProfileService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [资产概要控制层]
 * @author hmj
 * @create 2018-08-27 11:18
 */
@Controller
@RequestMapping("${project.url.prefix}/report/contact/assetProfile")
public class AssetProfileController extends ReportBaseController {
    @Autowired
    private AssetProfileService assetProfileService;
    /**
     * [获取资产概要主页数据]
     * 作者:hmj
     * 创建时间:2018/8/27
     */
    @AuthValidate
    @RequestMapping("/getDataList")
    @ResponseBody
    public Result getDataList(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_ZCGY");//设置菜单码
        queryVo.setDestStr("获取资产概要主页数据");
        //这里设置断言和特殊查询参数
        Result result= new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return assetProfileService.getDataList(queryVo, paramMap, result);
    }

    /**
     * [获取资产概要总额]
     * 作者:hmj
     * 创建时间:2018/9/6
     */
    @AuthValidate
    @RequestMapping("/getTotalVo")
    @ResponseBody
    public Result getTotalVo(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_ZCGY");//设置菜单码
        queryVo.setDestStr("获取资产概要主页总计行数据");
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return assetProfileService.getTotalVo(queryVo, paramMap, result);
    }

}
