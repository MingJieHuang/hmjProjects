package com.phone.erp.boss.service.purchase.impl;

import com.phone.erp.boss.mapper.purchase.PurchaseSalesCompareMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.purchase.PurchaseSalesCompareService;
import com.phone.erp.boss.vo.purchase.PurchaseSalesCompareVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [进销对比服务层实现类]
 * @author hmj
 * @create 2018-08-18 16:47
 */
@Service
@Transactional
public class PurchaseSalesCompareServiceImpl extends ReportBaseServiceImpl<PurchaseSalesCompareVo,PurchaseSalesCompareMapper>implements PurchaseSalesCompareService{
    @SuppressWarnings("unused")
    @Autowired
    private PurchaseSalesCompareMapper purchaseSalesCompareMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(PurchaseSalesCompareMapper purchaseSalesCompareMapper) {
        super.setMapper(purchaseSalesCompareMapper);
    }

}
