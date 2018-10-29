package com.phone.erp.boss.service.retail.impl;

import com.phone.erp.boss.mapper.retail.ThirdPartyDeductionReportMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.retail.ThirdPartyDeductionReportService;
import com.phone.erp.boss.vo.retail.ThirdPartyDeductionReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [第三方抵扣战报服务层实现类]
 * @author hmj
 * @create 2018-08-24 16:36
 */
@Service
@Transactional
public class ThirdPartyDeductionReportServiceImpl extends ReportBaseServiceImpl<ThirdPartyDeductionReportVo,ThirdPartyDeductionReportMapper> implements ThirdPartyDeductionReportService {
    
    @SuppressWarnings("unused")
    @Autowired
    private ThirdPartyDeductionReportMapper thirdPartyDeductionReportMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(ThirdPartyDeductionReportMapper thirdPartyDeductionReportMapper) {
        super.setMapper(thirdPartyDeductionReportMapper);
    }
    
}
