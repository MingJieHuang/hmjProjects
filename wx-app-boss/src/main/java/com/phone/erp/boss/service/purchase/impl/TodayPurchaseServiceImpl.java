package com.phone.erp.boss.service.purchase.impl;

import com.phone.erp.boss.mapper.purchase.TodayPurchaseMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.purchase.TodayPurchaseService;
import com.phone.erp.boss.vo.purchase.TodayPurchaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hmj
 * @create 2018-08-21 17:34
 */
@Service
@Transactional
public class TodayPurchaseServiceImpl extends ReportBaseServiceImpl<TodayPurchaseVo,TodayPurchaseMapper> implements TodayPurchaseService {
    @SuppressWarnings("unused")
    @Autowired
    private TodayPurchaseMapper todayPurchaseMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(TodayPurchaseMapper todayPurchaseMapper) {
        super.setMapper(todayPurchaseMapper);
    }
    
}
