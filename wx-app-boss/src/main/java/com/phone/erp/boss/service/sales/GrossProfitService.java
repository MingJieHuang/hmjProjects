package com.phone.erp.boss.service.sales;

import com.phone.erp.base.Result;
import com.phone.erp.boss.vo.common.BossQueryVo;

/**
 * [毛利战报服务层]
 *
 * @author HMJ
 * @version [版本, 2018-7-18]
 * @see
 */

public interface GrossProfitService {

    /**
     * [获取毛利战报主页数据]
     *
     * @throws Exception
     * @author HMJ
     * @version [版本, 2018-7-18]
     */
    Result getGrossProfitData(BossQueryVo queryVo) throws Exception;

    /**
     * [获取毛利战报主页总计行对象]
     *
     * @author HMJ
     * @version [版本, 2018-7-18]
     */
    Result getGrossProfitTotalVo(BossQueryVo queryVo) throws Exception;

    /**
     * [获取毛利战报明细页数据(分页)]
     *
     * @author HMJ
     * @version [版本, 2018-7-18]
     */
    Result getGrossProfitDetailData(BossQueryVo queryVo, String nodeName, Long nodeId) throws Exception;

    /**
     * [获取毛利战报详情页总计行对象]
     *
     * @author HMJ
     * @version [版本, 2018-7-18]
     */
    Result getGrossProfitDetailTotalVo(BossQueryVo queryVo, String nodeName, Long nodeId) throws Exception;

}
