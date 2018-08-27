package com.phone.erp.boss.service.contact.impl;

import com.phone.erp.boss.mapper.contact.AssetProfileMapper;
import com.phone.erp.boss.service.contact.AssetProfileService;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.vo.contact.AssetProfileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [资产概要服务层实现类]
 * @author hmj
 * @create 2018-08-27 11:14
 */
@Service
@Transactional
public class AssetProfileServiceImpl extends ReportBaseServiceImpl<AssetProfileVo,AssetProfileMapper>implements AssetProfileService {
    
    @SuppressWarnings("unused")
    @Autowired
    private AssetProfileMapper assetProfileMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(AssetProfileMapper assetProfileMapper) {
        super.setMapper(assetProfileMapper);
    }
    
}
