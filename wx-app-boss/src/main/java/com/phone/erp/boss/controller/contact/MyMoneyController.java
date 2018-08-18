package com.phone.erp.boss.controller.contact;

import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.boss.controller.ReportBaseController;
import com.phone.erp.boss.service.contact.MyMoneyService;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * [我的资金控制层]
 * @author hmj
 * @create 2018-08-18 17:13
 */
@Controller
@RequestMapping("${project.url.prefix}/report/contact/myMoney")
public class MyMoneyController extends ReportBaseController {
    @Autowired
    private MyMoneyService myMoneyService;

    /**
     * [我的资金获取主页分页结婚]
     * @param queryVo
     * @return
     * @throws Exception
     */
    @AuthValidate
    @RequestMapping("/getPageData")
    @ResponseBody
    public Result getPageData(BossQueryVo queryVo) throws Exception{
        setCurrentEmp(queryVo);
        queryVo.setMenuCode("BOSS_WDZJ");//设置菜单码
        queryVo.setDestStr("获取我的资金主页分页数据");
        //这里设置断言和特殊查询参数
        Result result = new Result();
        Map<String, Object> paramMap = getParamMap(queryVo,result);
        return myMoneyService.getPageData(queryVo, paramMap, result);
    }

}
