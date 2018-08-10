package com.phone.erp.boss.service.sales;

import com.phone.erp.base.Result;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [我的销量服务层]
 *
 * @author HMJ
 * @version [版本, 2018-7-16]
 * @see
 */

public interface MySalesService {

    /**
     * [我的销量主页数据]
     *
     * @author hmj
     * @version [版本, 2018-7-16]
     */
    Result getMySalesData(BossQueryVo queryVo) throws Exception;

    /**
     * [获取我的销量主页总计行对象]
     *
     * @throws Exception
     * @author HMJ
     * @version [版本, 2018-7-18]
     */
    Result getMySalesTotalVo(BossQueryVo queryVo) throws Exception;

    /**
     * [我的销量详情页数据]
     *
     * @throws Exception
     * @author HMJ
     * @version [版本, 2018-7-17]
     */
    Result getMySalesDetailData(BossQueryVo queryVo) throws Exception;

    /**
     * [获取我的销量详情页总计行对象]
     *
     * @throws Exception
     * @author HMJ
     * @version [版本, 2018-7-18]
     */
    Result getMySalesDetailTotalVo(BossQueryVo queryVo) throws Exception;


}
