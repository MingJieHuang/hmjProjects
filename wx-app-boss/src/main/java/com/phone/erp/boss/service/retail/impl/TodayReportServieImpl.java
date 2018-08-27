package com.phone.erp.boss.service.retail.impl;

import com.phone.erp.boss.mapper.retail.TodayReportMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.retail.TodayReportService;
import com.phone.erp.boss.vo.retail.TodayReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [今日战报服务层实现类]
 * @author hmj
 * @create 2018-08-18 17:39
 */
@Service
@Transactional
public class TodayReportServieImpl extends ReportBaseServiceImpl<TodayReportVo,TodayReportMapper> implements TodayReportService {
    @SuppressWarnings("unused")
    @Autowired
    private TodayReportMapper todayReportMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(TodayReportMapper todayReportMapper) {
        super.setMapper(todayReportMapper);
    }
    
}
