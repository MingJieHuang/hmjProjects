package com.phone.erp.boss.service.storage.impl;

import com.phone.erp.boss.mapper.storage.UnsalableStockMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.storage.UnsalableStockService;
import com.phone.erp.boss.vo.storage.UnsalableStockVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [滞销库存服务层实现类]
 * @author hmj
 * @create 2018-08-24 15:14
 */
@Service
@Transactional
public class UnsalableStockServiceImpl extends ReportBaseServiceImpl<UnsalableStockVo,UnsalableStockMapper> implements UnsalableStockService {
    
    @SuppressWarnings("unused")
    @Autowired
    private UnsalableStockMapper unsalableStockMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(UnsalableStockMapper unsalableStockMapper) {
        super.setMapper(unsalableStockMapper);
    }
}
