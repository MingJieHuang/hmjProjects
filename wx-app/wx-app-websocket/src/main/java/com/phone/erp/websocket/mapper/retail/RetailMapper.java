package com.phone.erp.websocket.mapper.retail;

import com.phone.erp.websocket.vo.retail.PrintParamVo;
import com.phone.erp.websocket.vo.retail.RetailOrderVo;

import java.util.Map;

/**
 * [零售的mapper]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public interface RetailMapper {

    /**
     * [通过零售单id获取零售单信息]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    RetailOrderVo getRetailOrderVoById(Map<String, Object> paramMap);

    /**
     * [通过零售单id获取打印参数对象]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    PrintParamVo getPrintParamVoByBillsId(Map<String, Object> paramMap);

}
