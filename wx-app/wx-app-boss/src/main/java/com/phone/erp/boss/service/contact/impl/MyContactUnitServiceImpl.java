package com.phone.erp.boss.service.contact.impl;

import com.phone.erp.boss.mapper.contact.MyContactUnitMapper;
import com.phone.erp.boss.service.contact.MyContactUnitService;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.vo.contact.MyContactUnitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * [我的往来服务实现类]
 * @author hmj
 * @create 2018-08-15 11:50
 */
@Service
@Transactional
public class MyContactUnitServiceImpl extends ReportBaseServiceImpl<MyContactUnitVo,MyContactUnitMapper> implements MyContactUnitService{
    		@Autowired
    		private MyContactUnitMapper myContactUnitMapper;
    		//Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    		@Autowired
    		public void setBaseMapper(MyContactUnitMapper myContactUnitMapper) {
    			super.setMapper(myContactUnitMapper);
    		}
    		
}
