package com.phone.erp.websocket.service;

import com.phone.erp.websocket.vo.retail.PrintParamVo;
import com.phone.erp.websocket.vo.retail.RetailOrderVo;

/**
 * [零售模块服务接口]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public interface RetailService {

    /**
     * [通过零售单id获取零售单信息]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    RetailOrderVo getRetailOrderVoById(Long billsId);

    /**
     * [通过零售单id获取打印参数对象]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    PrintParamVo getPrintParamVoByBillsId(Long billsId);

}
