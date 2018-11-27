package com.phone.erp.boss.service.retail.impl;

import com.phone.erp.boss.mapper.retail.ValueAddedReportMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.retail.ValueAddedReportService;
import com.phone.erp.boss.vo.retail.ValueAddedReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [增值服务战报服务层实现类]
 * @author hmj
 * @create 2018-08-27 10:44
 */
@Service
@Transactional
public class ValueAddedReportServiceImpl extends ReportBaseServiceImpl<ValueAddedReportVo,ValueAddedReportMapper> implements ValueAddedReportService {
    
    @SuppressWarnings("unused")
    @Autowired
    private ValueAddedReportMapper valueAddedReportMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(ValueAddedReportMapper valueAddedReportMapper) {
        super.setMapper(valueAddedReportMapper);
    }
    
}
