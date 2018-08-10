package com.phone.erp.boss.mapper.storage;

import com.github.pagehelper.Page;
import com.phone.erp.boss.vo.storage.ImeiTrackingDetailVo;
import com.phone.erp.boss.vo.storage.ImeiTrackingGoodsVo;
import com.phone.erp.boss.vo.storage.ImeiTrackingMainVo;

import java.util.List;
import java.util.Map;

/**
 * [串号跟踪Mapper]
 *
 * @author HMJ
 * @version [版本, 2018-7-19]
 * @see
 */

public interface ImeiTrackingMainMapper {

    /**
     * [获取串号跟踪主页分页集合]
     *
     * @author HMJ
     * @version [版本, 2018-7-19]
     */
    Page<ImeiTrackingMainVo> getImeiTrackingMainData(Map<String, Object> map);

    /**
     * [获取串号跟踪流水表集合]
     *
     * @author HMJ
     * @version [版本, 2018-7-19]
     */
    List<ImeiTrackingDetailVo> getImeiTrackingDetailData(Map<String, Object> map);

    /**
     * [获取串号流水表商品Vo]
     *
     * @author HMJ
     * @version [版本, 2018-7-19]
     */
    ImeiTrackingGoodsVo getImeiTrackingGoodsVo(Map<String, Object> map);

}
