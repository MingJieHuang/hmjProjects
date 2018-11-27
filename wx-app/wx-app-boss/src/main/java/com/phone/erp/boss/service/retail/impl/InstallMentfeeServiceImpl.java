package com.phone.erp.boss.service.retail.impl;

import com.phone.erp.boss.mapper.retail.InstallMentfeeMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.retail.InstallMentfeeService;
import com.phone.erp.boss.vo.retail.InstallMentfeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [分期业务战报服务层实现类]
 * @author hmj
 * @create 2018-08-18 16:05
 */
@Service
@Transactional
public class InstallMentfeeServiceImpl extends ReportBaseServiceImpl<InstallMentfeeVo,InstallMentfeeMapper> implements InstallMentfeeService {
    @SuppressWarnings("unused")
    @Autowired
    private InstallMentfeeMapper installMentfeeMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(InstallMentfeeMapper installMentfeeMapper) {
        super.setMapper(installMentfeeMapper);
    }
    
}
