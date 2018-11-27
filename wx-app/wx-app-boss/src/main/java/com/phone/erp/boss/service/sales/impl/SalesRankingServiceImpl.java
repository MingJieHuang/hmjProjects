package com.phone.erp.boss.service.sales.impl;

import com.phone.erp.boss.mapper.sales.SalesRankingMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.sales.SalesRankingService;
import com.phone.erp.boss.vo.sales.SalesRankingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [销售]
 * @author hmj
 * @create 2018-08-18 14:20
 */
@Service
@Transactional
public class SalesRankingServiceImpl extends ReportBaseServiceImpl<SalesRankingVo,SalesRankingMapper> implements SalesRankingService {
    @SuppressWarnings("unused")
    @Autowired
    private SalesRankingMapper salesRankingMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(SalesRankingMapper salesRankingMapper) {
        super.setMapper(salesRankingMapper);
    }

}
