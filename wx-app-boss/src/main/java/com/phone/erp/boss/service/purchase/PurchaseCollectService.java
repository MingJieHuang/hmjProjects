package com.phone.erp.boss.service.purchase;

import com.phone.erp.base.Result;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [采购汇总服务层]
 *
 * @author HMJ
 * @version [版本, 2018-7-17]
 * @see
 */

public interface PurchaseCollectService {

    /**
     * [获取采购汇总主页分页集合]
     *
     * @throws Exception
     * @author HMJ
     * @version [版本, 2018-7-17]
     */
    Result getPurchaseCollectData(BossQueryVo queryVo) throws Exception;

    /**
     * [获取采购汇总总计行对象]
     *
     * @throws Exception
     * @author HMJ
     * @version [版本, 2018-7-18]
     */
    Result getPurchaseCollectTotalVo(BossQueryVo queryVo) throws Exception;

}
