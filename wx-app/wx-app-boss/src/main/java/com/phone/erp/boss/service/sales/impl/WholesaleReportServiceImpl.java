package com.phone.erp.boss.service.sales.impl;

import com.phone.erp.boss.mapper.sales.WholesaleReportMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.sales.WholesaleReportService;
import com.phone.erp.boss.vo.sales.WholesaleReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [批发战报控制层]
 * @author hmj
 * @create 2018-08-27 15:36
 */
@Service
@Transactional
public class WholesaleReportServiceImpl extends ReportBaseServiceImpl<WholesaleReportVo,WholesaleReportMapper> implements WholesaleReportService {
    
    @SuppressWarnings("unused")
    @Autowired
    private WholesaleReportMapper wholesaleReportMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(WholesaleReportMapper wholesaleReportMapper) {
        super.setMapper(wholesaleReportMapper);
    }
    
}
