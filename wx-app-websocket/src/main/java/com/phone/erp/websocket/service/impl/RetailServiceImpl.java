package com.phone.erp.websocket.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.erp.websocket.mapper.retail.RetailMapper;
import com.phone.erp.websocket.service.RetailService;
import com.phone.erp.websocket.vo.retail.PrintParamVo;
import com.phone.erp.websocket.vo.retail.RetailOrderVo;

/**
 * [零售模块服务实现类]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@Service
public class RetailServiceImpl implements RetailService {

    @Autowired
    private RetailMapper retailMapper;

    @Override
    public RetailOrderVo getRetailOrderVoById(Long billsId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("billsId", billsId);
        return retailMapper.getRetailOrderVoById(paramMap);
    }

    @Override
    public PrintParamVo getPrintParamVoByBillsId(Long billsId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("billsId", billsId);
        return retailMapper.getPrintParamVoByBillsId(paramMap);
    }

}
