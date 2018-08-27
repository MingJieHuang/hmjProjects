package com.phone.erp.boss.service.sales.impl;

import com.phone.erp.boss.mapper.sales.SalesContrastMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.sales.SalesContrastService;
import com.phone.erp.boss.vo.sales.SalesContrastVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [销售对比服务层实现类]
 * @author hmj
 * @create 2018-08-27 16:13
 */
@Service
@Transactional
public class SalesContrastServiceImpl extends ReportBaseServiceImpl<SalesContrastVo,SalesContrastMapper>implements SalesContrastService{
    
    @SuppressWarnings("unused")
    @Autowired
    private SalesContrastMapper salesContrastMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(SalesContrastMapper salesContrastMapper) {
        super.setMapper(salesContrastMapper);
    }
    
}
