package com.phone.erp.boss.service.storage.impl;

import com.phone.erp.boss.mapper.storage.TurnOverRateMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.storage.TurnOverRateService;
import com.phone.erp.boss.vo.storage.TurnOverRateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [周转率分析服务层实现类]
 * @author hmj
 * @create 2018-08-27 17:06
 */
@Service
@Transactional
public class TurnOverRateServiceImpl extends ReportBaseServiceImpl<TurnOverRateVo,TurnOverRateMapper>implements TurnOverRateService {
    
    @SuppressWarnings("unused")
    @Autowired
    private TurnOverRateMapper turnOverRateMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(TurnOverRateMapper turnOverRateMapper) {
        super.setMapper(turnOverRateMapper);
    }
    
}
