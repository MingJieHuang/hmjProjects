package com.phone.erp.boss.service.storage.impl;

import com.phone.erp.boss.mapper.storage.TodayAllotMapper;
import com.phone.erp.boss.service.impl.ReportBaseServiceImpl;
import com.phone.erp.boss.service.storage.TodayAllotService;
import com.phone.erp.boss.vo.storage.TodayAllotVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [今日调拨服务层实现类]
 * @author hmj
 * @create 2018-08-27 13:57
 */
@Service
@Transactional
public class TodayAllotServiceImpl extends ReportBaseServiceImpl<TodayAllotVo,TodayAllotMapper>implements TodayAllotService {
    
    @SuppressWarnings("unused")
    @Autowired
    private TodayAllotMapper todayAllotMapper;
    //Autowired不能缺少,强制将子类的mapper传到ReportBaseMapper中使用
    @Autowired
    public void setBaseMapper(TodayAllotMapper todayAllotMapper) {
        super.setMapper(todayAllotMapper);
    }
    
}
