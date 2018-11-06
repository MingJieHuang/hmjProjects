package com.phone.erp.boss.service.sales.impl;

import com.phone.erp.base.Result;
import com.phone.erp.boss.mapper.sales.SalesContrastMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.sales.SalesContrastService;
import com.phone.erp.boss.util.BossReportUtil;
import com.phone.erp.boss.vo.common.BossQueryVo;
import com.phone.erp.boss.vo.sales.SalesContrastVo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * [销售对比服务层实现类]
 * @author hmj
 * @create 2018-08-27 16:13
 */
@Service
@Transactional
public class SalesContrastServiceImpl extends ReportBaseServiceImpl<SalesContrastVo,SalesContrastMapper>implements SalesContrastService{
    
    @SuppressWarnings("unused")
    @Autowired
    private SalesContrastMapper salesContrastMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(SalesContrastMapper salesContrastMapper) {
        super.setMapper(salesContrastMapper);
    }
    /**
     * [获取主页集合(不分页)]
     * @author HMJ
     * @version [版本,2018-9-03]
     * @throws Exception
     */
    @Override
    public Result getDataList(BossQueryVo queryVo, Map<String, Object> paramMap, Result result) throws Exception {
        String descStr = queryVo.getDestStr();
        List<SalesContrastVo> dataList = new ArrayList<SalesContrastVo>();
        try {
            //查询date1 ,并设置date
            SalesContrastVo salesContrastVo1 = mapper.getDataList(paramMap).get(0);
            if (null == salesContrastVo1){
                salesContrastVo1 = new SalesContrastVo();
            }
            salesContrastVo1.setBillsDate(queryVo.getStartDate()+" 至 "+queryVo.getEndDate());
            dataList.add(salesContrastVo1);
            //设置data2.并查询
            paramMap.put("startDate",queryVo.getStartDate2());
            paramMap.put("endDate",queryVo.getEndDate2());
            SalesContrastVo salesContrastVo2 = mapper.getDataList(paramMap).get(0);
            if (null == salesContrastVo2){
                salesContrastVo2 = new SalesContrastVo();
            }
            salesContrastVo2.setBillsDate(queryVo.getStartDate2()+" 至 "+queryVo.getEndDate2());
            dataList.add(salesContrastVo2);
            result.put("dataList",dataList);
            result.put("canSeeAmount",queryVo.getCanSeeAmount());
        } catch (Exception e) {
            return BossReportUtil.getFailingResult(result, descStr);
        }
        return BossReportUtil.getSuccessResult(result, descStr);
    }
}
