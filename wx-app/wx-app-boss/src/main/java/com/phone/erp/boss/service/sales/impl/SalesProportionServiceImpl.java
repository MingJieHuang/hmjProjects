package com.phone.erp.boss.service.sales.impl;

import com.phone.erp.boss.mapper.sales.SalesProportionMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.sales.SalesProportionService;
import com.phone.erp.boss.vo.sales.SalesProportionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [销售占比服务层实现类]
 * @author hmj
 * @create 2018-08-27 16:42
 */
@Service
@Transactional
public class SalesProportionServiceImpl extends ReportBaseServiceImpl<SalesProportionVo,SalesProportionMapper>implements SalesProportionService {
    
    @SuppressWarnings("unused")
    @Autowired
    private SalesProportionMapper salesProportionMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(SalesProportionMapper salesProportionMapper) {
        super.setMapper(salesProportionMapper);
    }
    
}
