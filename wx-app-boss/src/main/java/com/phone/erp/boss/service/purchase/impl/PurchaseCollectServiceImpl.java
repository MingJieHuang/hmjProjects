package com.phone.erp.boss.service.purchase.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.phone.erp.base.Result;
import com.phone.erp.boss.mapper.purchase.PurchaseCollectMapper;
import com.phone.erp.boss.service.impl.BossCommonServiceImpl;
import com.phone.erp.boss.service.purchase.PurchaseCollectService;
import com.phone.erp.boss.util.BossReportUtil;
import com.phone.erp.boss.vo.common.BossQueryVo;
import com.phone.erp.boss.vo.purchase.PurchaseCollectVo;

/**
 * [采购汇总服务实现类]
 *
 * @author HMJ
 * @version [版本, 2018-7-17]
 * @see
 */
@Service
@Transactional
public class PurchaseCollectServiceImpl implements PurchaseCollectService {
    @Autowired
    private PurchaseCollectMapper purchaseCollectMapper;
    @Autowired
    private BossCommonServiceImpl bossCommonServiceImpl;

    /**
     * [获取采购汇总主页分页集合]
     *
     * @throws Exception
     * @author HMJ
     * @version [版本, 2018-7-17]
     */
    @Override
    public Result getPurchaseCollectData(BossQueryVo queryVo) throws Exception {
        Result result = new Result();
        String descStr = "获取采购汇总主页分页集合";
        //第一步验证访问权限和查看成本价权限
        bossCommonServiceImpl.authValidate(queryVo, result);
        //第二步加工查询参数
        Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
        //增加特殊参数进入map,根据特殊查询条件而定
        //第三步设置分页参数
        PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
        try {
            Page<PurchaseCollectVo> pageInfo = purchaseCollectMapper.getPurchaseCollectData(map);
/*			PurchaseCollectVo totalVo = purchaseCollectMapper.getPurchaseCollectTotalVo(map);
            result.put("totalVo", totalVo);*/
            result.put("dataList", pageInfo.getResult());
            result.put("canSeeAmount", queryVo.getCanSeeAmount());
        } catch (Exception e) {
            return BossReportUtil.getFailingResult(result, descStr);
        }
        return BossReportUtil.getSuccessResult(result, descStr);
    }

    /**
     * [获取采购汇总总计行对象]
     *
     * @throws Exception
     * @author HMJ
     * @version [版本, 2018-7-18]
     */
    @Override
    public Result getPurchaseCollectTotalVo(BossQueryVo queryVo) throws Exception {
        Result result = new Result();
        String descStr = "获取采购汇总总计行对象";
        //第一步验证访问权限和查看成本价权限
        bossCommonServiceImpl.authValidate(queryVo, result);
        //第二步加工查询参数
        Map<String, Object> map = bossCommonServiceImpl.getParamMap(queryVo);
        //增加特殊参数进入map,根据特殊查询条件而定
        try {
            PurchaseCollectVo totalVo = purchaseCollectMapper.getPurchaseCollectTotalVo(map);
            result.put("totalVo", totalVo);
            result.put("canSeeAmount", queryVo.getCanSeeAmount());
        } catch (Exception e) {
            return BossReportUtil.getFailingResult(result, descStr);
        }
        return BossReportUtil.getSuccessResult(result, descStr);
    }
}
