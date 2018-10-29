package com.phone.erp.boss.service.contact.impl;

import com.phone.erp.boss.mapper.contact.MyMoneyMapper;
import com.phone.erp.boss.service.contact.MyMoneyService;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.vo.contact.MyMoneyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [我的资金服务实现类]
 * @author hmj
 * @create 2018-08-18 17:08
 */
@Service
@Transactional
public class MyMoneyServiceImpl extends ReportBaseServiceImpl<MyMoneyVo,MyMoneyMapper> implements MyMoneyService {
 @SuppressWarnings("unused")
 @Autowired
 private MyMoneyMapper myMoneyMapper;
 //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
 @Autowired
 public void setBaseMapper(MyMoneyMapper myMoneyMapper) {
     super.setMapper(myMoneyMapper);
 }
}
