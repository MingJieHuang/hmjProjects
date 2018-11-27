package com.phone.erp.boss.service.sales.impl;

import com.phone.erp.boss.mapper.sales.SalesTrendMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.sales.SalesTrendService;
import com.phone.erp.boss.vo.sales.SalesTrendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [销售走势服务层实现类]
 * @author hmj
 * @create 2018-08-27 14:34
 */
@Service
@Transactional
public class SalesTrendServiceImpl extends ReportBaseServiceImpl<SalesTrendVo,SalesTrendMapper>implements SalesTrendService {
    
    @SuppressWarnings("unused")
    @Autowired
    private SalesTrendMapper salesTrendMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(SalesTrendMapper salesTrendMapper) {
        super.setMapper(salesTrendMapper);
    }
    
}
