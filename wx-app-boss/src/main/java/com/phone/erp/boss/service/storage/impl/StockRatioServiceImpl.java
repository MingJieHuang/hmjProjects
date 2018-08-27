package com.phone.erp.boss.service.storage.impl;

import com.phone.erp.boss.mapper.storage.StockRatioMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.storage.StockRatioService;
import com.phone.erp.boss.vo.storage.StockRatioVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [库存占比服务层实现类]
 * @author hmj
 * @create 2018-08-24 14:22
 */
@Service
@Transactional
public class StockRatioServiceImpl extends ReportBaseServiceImpl<StockRatioVo,StockRatioMapper> implements StockRatioService {
    @SuppressWarnings("unused")
    @Autowired
    private StockRatioMapper stockRatioMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(StockRatioMapper stockRatioMapper) {
        super.setMapper(stockRatioMapper);
    }
}
