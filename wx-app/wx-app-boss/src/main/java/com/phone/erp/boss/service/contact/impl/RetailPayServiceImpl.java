package com.phone.erp.boss.service.contact.impl;

import com.phone.erp.boss.mapper.contact.RetailPayMapper;
import com.phone.erp.boss.service.contact.RetailPayService;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.vo.contact.RetailPayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [营业款服务层实现类]
 * @author hmj
 * @create 2018-08-27 11:55
 */
@Service
@Transactional
public class RetailPayServiceImpl extends ReportBaseServiceImpl<RetailPayVo, RetailPayMapper>implements RetailPayService {
    
    @SuppressWarnings("unused")
    @Autowired
    private  RetailPayMapper retailPayMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper( RetailPayMapper retailPayMapper) {
        super.setMapper(retailPayMapper);
    }
    
}
