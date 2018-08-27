package com.phone.erp.boss.service.storage.impl;

import com.phone.erp.boss.mapper.storage.TurnOverDayRateMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.storage.TurnOverDayRateService;
import com.phone.erp.boss.vo.storage.TurnOverDayRateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [周转天数分析服务层实现类]
 * @author hmj
 * @create 2018-08-27 17:39
 */
@Service
@Transactional
public class TurnOverDayRateServiceImpl extends ReportBaseServiceImpl<TurnOverDayRateVo,TurnOverDayRateMapper>implements TurnOverDayRateService {
    
    @SuppressWarnings("unused")
    @Autowired
    private TurnOverDayRateMapper turnOverDayRateMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(TurnOverDayRateMapper turnOverDayRateMapper) {
        super.setMapper(turnOverDayRateMapper);
    }
    
}
