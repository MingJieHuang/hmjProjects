package com.phone.erp.boss.controller.retail;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.retail.InstallMentfeeService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [分期业务战报控制层]
 * @author hmj
 * @create 2018-08-18 16:12
 */
@Controller
@RequestMapping("${project.url.prefix}/report/retail/installMentfee")
public class InstallMentfeeController extends ReportBaseController {
    @Autowired
    private InstallMentfeeService installMentfeeService;

    /**
     * [分期业务战报获取主页分页集合]
     * @param queryVo
     * @return
     * @throws Exception
     */
    @AuthValidate
    @RequestMapping("/getPageData")
    @ResponseBody
    public Result getPageData(BossQueryVo queryVo) throws Exception{
        Assert.notNull(queryVo.getGroupField(), "分组参数不能为空!!");
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_FQYWZB");//设置菜单码
        queryVo.setDestStr("获取分期业务战报主页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return installMentfeeService.getPageData(queryVo, paramMap, result);
    }

    /**
     * [分期业务战报获取分页总计行对象]
     * @param queryVo
     * @return
     * @throws Exception
     */
    @AuthValidate
    @RequestMapping("/getTotalVo")
    @ResponseBody
    public Result getTotalVo(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_FQYWZB");//设置菜单码
        queryVo.setDestStr("获取分期业战报好主页总计行数据");
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return installMentfeeService.getTotalVo(queryVo, paramMap, result);
    }
}
