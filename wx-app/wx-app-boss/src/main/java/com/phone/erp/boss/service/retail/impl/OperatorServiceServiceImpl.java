package com.phone.erp.boss.service.retail.impl;

import com.phone.erp.boss.mapper.retail.OperatorServiceMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.retail.OperatorServiceService;
import com.phone.erp.boss.vo.retail.OperatorServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [运营商业务战报服务实现类]
 * @author hmj
 * @create 2018-08-18 15:26
 */
@Service
@Transactional
public class OperatorServiceServiceImpl extends ReportBaseServiceImpl<OperatorServiceVo,OperatorServiceMapper> implements OperatorServiceService {
    @SuppressWarnings("unused")
    @Autowired
    private OperatorServiceMapper operatorServiceMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(OperatorServiceMapper operatorServiceMapper) {
        super.setMapper(operatorServiceMapper);
    }

}
