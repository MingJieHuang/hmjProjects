package com.phone.erp.boss.mapper;

import com.phone.erp.boss.vo.common.*;

import java.util.List;
import java.util.Map;

/**
 * [Boss小程序mapper接口]
 *
 * @author HMJ
 * @version [版本, 2018-7-10]
 * @see
 */

public interface BossCommonMapper {

    /**
     * [判断是否有权限,为0表示没有权限]
     *
     * @author hmj
     * @version [版本, 2018-7-10]
     */
    public Long getAuthCodeNumber(Map<String, Object> map);

    /**
     * [获取Boss小程序菜单集合]
     *
     * @author hmj
     * @version [版本, 2018-7-10]
     */
    public List<BossMenuVo> getBossMenuList();

    /**
     * [获取商品类别集合]
     *
     * @author hmj
     * @version [版本, 2018-7-11]
     */
    public List<GoodsClassVo> getGoodsClassVoList(Map<String, Object> map);

    /**
     * 获取商品品牌集合
     *
     * @author hmj
     * @version [版本, 2018-7-10]
     */
    public List<GoodsBrandVo> getGoodsBrandList(Map<String, Object> map);

    /**
     * 获取当前登录员工在该下报表有权限的公司集合
     *
     * @author hmj
     * @version [版本, 2018-7-11]
     */
    public List<BossCompanyVo> getMenuCodeCompanyList(Map<String, Object> map);

    /**
     * [获取公司下所有有权限的部门子节点和全部父节点部门集合]
     *
     * @author hmj
     * @version [版本, 2018-7-11]
     */
    public List<BossSectionVo> getAllUsableSections(Map<String, Object> map);

    /**
     * [获取公司下全部部门]
     *
     * @author hmj
     * @version [版本, 2018-7-11]
     */
    public List<BossSectionVo> getAllSectionsInConmpany(Map<String, Object> map);

    /**
     * [获取部门节点下的所有叶子节点集合]
     *
     * @author hmj
     * @version [版本, 2018-7-12]
     */
    public List<BossSectionVo> getLeafNodeSectionList(Map<String, Object> map);

    /**
     * [获取用户可使用公司下往来单位(供应商、客户)分页集合]
     *
     * @author HMJ
     * @version [版本, 2018-7-18]
     */
    public List<BossContactUnitVo> getContactUnits(Map<String, Object> map);

}
