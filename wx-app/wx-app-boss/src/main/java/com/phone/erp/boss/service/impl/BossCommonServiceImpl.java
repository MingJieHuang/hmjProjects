package com.phone.erp.boss.service.impl;

import com.github.pagehelper.PageHelper;
import com.phone.erp.base.Result;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import com.phone.erp.boss.mapper.BossCommonMapper;
import com.phone.erp.boss.service.BossCommonService;
import com.phone.erp.boss.util.BossReportUtil;
import com.phone.erp.boss.vo.common.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * [Boss小程序公共业务层实现类]
 *
 * @author HMJ
 * @version [版本, 2018-7-10]
 * @see
 */
@Service
@Transactional
public class BossCommonServiceImpl implements BossCommonService {

    @Autowired
    private BossCommonMapper bossCommonMapper;

    /********************************** BOSS公共组件区 START *********************************************/
    /**
     * [获取用户可使用公司下往来单位(供应商、客户)分页集合]
     *
     * @throws Exception
     * @author HMJ
     * @version [版本, 2018-7-18]
     */
    @Override
    public List<BossContactUnitVo> getContactUnits(BossQueryVo queryVo) throws Exception {
        // 第一步加工查询参数
        Map<String, Object> map = getParamMap(queryVo);
        /*
         * //第二步设置分页参数 PageHelper.startPage(queryVo.getPage(),
         * queryVo.getPageSize());
         */
        return bossCommonMapper.getContactUnits(map);
    }

    /**
     * [获取类别集合]
     *
     * @param onlyQueryOneLevelGoodsclass 为true是一级类别.为false是全部类别
     * @author hmj
     * @version [版本, 2018-7-11]
     */
    @Override
    public List<GoodsClassVo> getGoodsClassVoList(LoginEmployeeVo employeeVo, Boolean onlyQueryOneLevelGoodsclass, Result result) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("groupId", employeeVo.getGroupId());
        if (onlyQueryOneLevelGoodsclass) {
            map.put("onlyQueryOneLevelGoodsclass", 1);// 不为空即可
        }
        return bossCommonMapper.getGoodsClassVoList(map);
    }

    /**
     * 获取商品品牌集合(分页)
     *
     * @param keyWord  模糊查询
     * @author hmj
     * @version [版本, 2018-7-10]
     */
    @Override
    public List<GoodsBrandVo> getGoodsBrandList(LoginEmployeeVo employeeVo, String keyWord) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("groupId", employeeVo.getGroupId());
        if (StringUtils.isNotBlank(keyWord)) {
            map.put("keyWord", keyWord);
        }
        return bossCommonMapper.getGoodsBrandList(map);
    }

    /**
     * 获取当前登录员工在该下报表有权限的公司集合
     *
     * @param employeeVo 当前登录人
     * @param menuCode   报表菜单码
     * @author hmj
     * @version [版本, 2018-7-11]
     */
    @Override
    public List<BossCompanyVo> getMenuCodeCompanyList(LoginEmployeeVo employeeVo, String menuCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("menuCode", menuCode);
        map.put("employeeId", employeeVo.getId());
        List<BossCompanyVo> companyList = bossCommonMapper.getMenuCodeCompanyList(map);
        if (CollectionUtils.isNotEmpty(companyList)) {
            putSectionListInCompany(employeeVo, companyList);
        }
        return companyList;
    }

    /**
     * [获取Boss小程序菜单集合(不分页,固定长度)]
     *
     * @author hmj
     * @version [版本, 2018-7-10]
     */
    @Override
    public List<BossMenuVo> getBossMenuList(LoginEmployeeVo employeeVo) {
        // 第一步获取系统自带的boss菜单集合
        List<BossMenuVo> BossMenuVoList = bossCommonMapper.getBossMenuList();
        if (CollectionUtils.isNotEmpty(BossMenuVoList)) {
            // 第二步循环系统菜单集合,然后匹配当前登录员工的的权限,如果没有访问权限就将对应菜单状态设置为禁用
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("employeeId", employeeVo.getId());
            map.put("groupId", employeeVo.getGroupId());
            map.put("companyId", employeeVo.getCompanyId());
            map.put("fun_code", "FW");
            for (BossMenuVo bossMenuVo : BossMenuVoList) {
                map.put("menuCode", bossMenuVo.getCode());
                Long authCodeNumber = bossCommonMapper.getAuthCodeNumber(map);
                if (authCodeNumber == 0) {
                    bossMenuVo.setStatus(1);
                }
            }
        }
        return BossMenuVoList;
    }

    /**
     * [获取运营商名称集合]
     *
     * @author hmj
     * @version [版本, 2018-8-22]
     * @param queryVo
     */
    @Override
    public List<BossConditionVo> getOperatorList(BossQueryVo queryVo) throws Exception {
        //如果keyWord非空设置参数
        Map<String,Object> map = map = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(queryVo.getKeyWord())){
            map.put("keyWord",queryVo.getKeyWord());
        }
        return bossCommonMapper.getOperatorList(map);
    }

    /**
     * 获取运营商单位集合
     * @param queryVo
     * @return
     */
    @Override
    public List<BossConditionVo> getOperatorUnitList(BossQueryVo queryVo) throws Exception {
        Map<String, Object> map = getConditionMap(queryVo, false);
        return bossCommonMapper.getOperatorUnitList(map);
    }

    /**
     * 获取运营商业务名称集合
     * @param queryVo
     * @return
     * @throws Exception
     */
    @Override
    public List<BossConditionVo> getOperatorNameList(BossQueryVo queryVo) throws Exception {
        Map<String, Object> map = getConditionMap(queryVo, false);
        return bossCommonMapper.getOperatorNameList(map);
    }
    /**
     * 获取抵扣单位集合
     * @author hmj
     * @version [版本,2018-8-28]
     */
    @Override
    public List<BossConditionVo> getDeductionUnitsList(BossQueryVo queryVo) throws Exception {
        Map<String, Object> map = getConditionMap(queryVo,false);
        return bossCommonMapper.getDeductionUnitsList(map);
    }
    /**
     * 获取抵扣活动集合
     * @author hmj
     * @version [版本,2018-8-28]
     */
    @Override
    public List<BossConditionVo> getActivityNamesList(BossQueryVo queryVo) throws Exception {
        Map<String, Object> map = getConditionMap(queryVo,false);
        return bossCommonMapper.getActivityNamesList(map);
    }
    /**
     * 获取分期商名称集合
     * @author hmj
     * @version [版本,2018-8-28]
     */
    @Override
    public List<BossConditionVo> getInstallmentfeesList(BossQueryVo queryVo) throws Exception {
        Map<String, Object> map = getConditionMap(queryVo,false);
        return bossCommonMapper.getInstallmentfeesList(map);
    }
    /**
     * 获取分期业务名称集合
     * @author hmj
     * @version [版本,2018-8-28]
     */
    @Override
    public List<InstallmentBusinessVo> getInstallmentBusinessList(BossQueryVo queryVo) throws Exception {
        Map<String, Object> map = getConditionMap(queryVo,false);
        return bossCommonMapper.getInstallmentBusinessList(map);
    }
    /**
     * 获取资金账户类型集合
     * @author hmj
     * @version [版本,2018-8-30]
     */
    @Override
    public List<BossConditionVo> getAccountTypeList() throws Exception {
        return bossCommonMapper.getAccountTypeList();
    }

    @Override
    public List<BossCompanyVo> getCompanyList(LoginEmployeeVo employeeVo, String menuCode) {
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("employeeId",employeeVo.getId());
        map.put("menuCode",menuCode);
        return bossCommonMapper.getMenuCodeCompanyList(map);
    }
    /**
     * 获取增值服务名称集合
     * @author hmj
     * @version [版本,2018-9-11]
     * @param queryVo
     */
    @Override
    public List<BossConditionVo> getAddValueServiceNameList(BossQueryVo queryVo) throws Exception {
        Map<String, Object> map = getConditionMap(queryVo,false);
        return bossCommonMapper.getAddValueServiceNameList(map);
    }


    /********************************** BOSS公共组件区 END *********************************************/
    /**
     * 获取报表组件查询map
     * @param queryVo
     * @param isQueryPage 是否分页
     * @return
     * @throws Exception
     */
    private Map<String, Object> getConditionMap(BossQueryVo queryVo,Boolean isQueryPage) throws Exception {
        List<BossCompanyVo> menuCodeCompanyList = getMenuCodeCompanyList(queryVo.getEmployeeVo(), queryVo.getMenuCode());
        Map<String,Object> map = new HashMap<String, Object>();
        if (CollectionUtils.isNotEmpty(menuCodeCompanyList)){
            map.put("companyIds", BossReportUtil.getFieldStr(menuCodeCompanyList, "id"));
        }
        if (StringUtils.isNotBlank(queryVo.getKeyWord())){
            map.put("keyWord",queryVo.getKeyWord());
        }
        if (isQueryPage){
            //设置分页参数
            Integer page = queryVo.getPage();
            Integer pageSize = queryVo.getPageSize();
            PageHelper.startPage(page==null?1:page,pageSize==null?20:pageSize);
        }
        return map;
    }
    /**
     * [获取报表权限]
     *
     * @author hmj
     * @version [版本, 2018-7-10]
     */
    @Override
    public Result getBossAuthValidate(LoginEmployeeVo employeeVo, String menuCode, Result result) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("menuCode", menuCode);
        map.put("employeeId", employeeVo.getId());
        map.put("groupId", employeeVo.getGroupId());
        map.put("companyId", employeeVo.getCompanyId());
        // 定义报表的fun_code数组
        String[] fun_codeArray = {"FW", "CKCBJ"};
        for (String fun_code : fun_codeArray) {
            map.put("fun_code", fun_code);
            Long authCodeNumber = bossCommonMapper.getAuthCodeNumber(map);
            Boolean flag = authCodeNumber == 0 ? false : true;
            if ("FW".equals(fun_code) && (!flag)) {
                Assert.isTrue(flag, ErrorCode.UNAUTHORIZED);// 没有访问权限就报错
            }
            result.put(fun_code, flag);
        }
        return result;
    }

    /**
     * 获取公司部门集合
     *
     * @param dataList 不含部门的公司集合
     * @author hmj
     * @version [版本, 2018-7-11]
     */
    @Override
    public void putSectionListInCompany(LoginEmployeeVo employeeVo, List<BossCompanyVo> dataList) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("employeeId", employeeVo.getId());
        map.put("groupId", employeeVo.getGroupId());
        for (BossCompanyVo bossCompanyVo : dataList) {
            map.put("companyId", bossCompanyVo.getId());
            // 获取公司下的可使用部门并设置到公司对象中
            bossCompanyVo.setSectionList(getSectionListInCompany(map));
        }
    }

    /**
     * 获取单个公司下的部门集合(含叶子节点和无权限父节点)
     *
     * @param map [employeeId,groupId,companyId,kcFalg]
     * @author hmj
     * @version [版本, 2018-7-12]
     */
    public List<BossSectionVo> getSectionListInCompany(Map<String, Object> map) {
        List<BossSectionVo> sectionList = new ArrayList<BossSectionVo>();
        try {
            // 获取公司下的可使用部门[含所有的叶子节点和无权限父节点部门集合]
            sectionList = bossCommonMapper.getAllUsableSections(map);// 获取公司下的可使用部门包含叶字节点和无权限的父节点
            if (CollectionUtils.isEmpty(sectionList)) {
                sectionList = bossCommonMapper.getAllSectionsInConmpany(map);// 获取公司下全部部门
            }
        } catch (Exception e) {
            throw new RuntimeException("获取公司下有权限部门集合失败!!");
        }// 暂时屏蔽部门路径
        setSectionPath(sectionList);
        return sectionList;
    }

    /**
     * 获取部门父节点下的所有子节点集合
     *
     * @param sectionId 部门父节点id
     * @author hmj
     * @version [版本, 2018-7-12]
     */
    public List<BossSectionVo> getLeafNodeSectionList(Long sectionId) {
        List<BossSectionVo> sectionList = new ArrayList<BossSectionVo>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sectionId", sectionId);
        try {
            // 获取公司下的可使用部门[含所有的叶子节点和无权限父节点部门集合]
            sectionList = bossCommonMapper.getLeafNodeSectionList(map);
        } catch (Exception e) {
            throw new RuntimeException("获取部门下叶子节点集合失败!!");
        }
        return sectionList;
    }

    /**
     * 加工查询报表时公司部门参数
     *
     * @param map                 [存参数]
     * @param companySectionParam 前端点击公司部门参数传值 为空代表全部,为"Company,id"或者"Section,id"
     * @param employeeVo          当前登录员工
     * @param menuCode            报表菜单码
     * @throws Exception
     * @author hmj
     * @version [版本, 2018-7-12]
     */
    public Map<String, Object> putCompanySectionInMap(LoginEmployeeVo employeeVo, String menuCode, Map<String, Object> map, String companySectionParam)
            throws Exception {
        List<BossSectionVo> sectionList = new ArrayList<BossSectionVo>();
        List<BossCompanyVo> companyList = new ArrayList<BossCompanyVo>();
        if (StringUtils.isBlank(companySectionParam)) {// 传的是全部
            companyList = getMenuCodeCompanyList(employeeVo, menuCode);
            if (CollectionUtils.isNotEmpty(companyList)) {
                for (BossCompanyVo bossCompanyVo : companyList) {
                    sectionList.addAll(bossCompanyVo.getSectionList());
                }
            }
        } else {
            String[] typeAndId = companySectionParam.split(",");
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("employeeId", employeeVo.getId());
            paramMap.put("groupId", employeeVo.getGroupId());
            BossCompanyVo companyVo = new BossCompanyVo();
            if ("Company".equals(typeAndId[0])) {// 传的是公司节点
                companyVo.setId(Long.valueOf(typeAndId[1]));
                paramMap.put("companyId", typeAndId[1]);
                sectionList = getSectionListInCompany(paramMap);
            } else {// 传的是部门节点
                sectionList = getLeafNodeSectionList(Long.valueOf(typeAndId[1]));
                if (CollectionUtils.isNotEmpty(sectionList)) {
                    companyVo.setId(sectionList.get(0).getCompanyId());
                }
            }
            companyList.add(companyVo);
        }
        // 最后判断公司集合不为空就存companyIds,否则存员工公司id
        if (CollectionUtils.isNotEmpty(companyList)) {
            map.put("companyIds", BossReportUtil.getFieldStr(companyList, "id"));
        } else {
            map.put("companyIds", employeeVo.getCompanyId().toString());
        }
        // 最后判断部门集合不为空就存SectionIds,否则存员工部门id
        if (CollectionUtils.isNotEmpty(sectionList)) {
            map.put("sectionIds", BossReportUtil.getFieldStr(sectionList, "id"));
        } else {
            map.put("sectionIds", employeeVo.getSectionId().toString());
        }
        return map;
    }

    /**
     * 给部门加路径
     * @author hmj
     * @version [版本, 2018-7-12]
     */
    public void setSectionPath(List<BossSectionVo> sectionList) {
        if (CollectionUtils.isNotEmpty(sectionList)) {
            Boolean flag = false;// 不进入递归
            String sectionPath = "";
            for (BossSectionVo vo1 : sectionList) {
                sectionPath = vo1.getSectionPath();
                Long pid1 = Long.valueOf(sectionPath.split(",")[0]);
                if (pid1 != -1) {// 父id不为-1的需要将父id替换成父name
                    flag = true;
                    for (BossSectionVo vo2 : sectionList) {
                        if (vo2.getId().equals(pid1)) {
                            vo1.setSectionPath(sectionPath.replace(pid1.toString(), vo2.getSectionPath()));
                            break;// 设置本次内循环
                        }
                    }
                }
            }
            if (flag) {// 判断是否进入递归,直到pid1全部为-1为
                setSectionPath(sectionList);
            }
            // 去掉-1,和替换,为/
            for (BossSectionVo bossSectionVo : sectionList) {
                sectionPath = bossSectionVo.getSectionPath().replace("-1,", "").replaceAll(",", "/");
                bossSectionVo.setSectionPath(sectionPath);
            }
            // 根据sectionPath排序
            Collections.sort(sectionList, new Comparator<BossSectionVo>() {
                @Override
                public int compare(BossSectionVo one, BossSectionVo two) {
                    return one.getSectionPath().compareToIgnoreCase(two.getSectionPath());
                }
            });
        }
    }

    /**
     * 报表查询先验证访问权限和查看成本价权限
     * @author hmj
     * @version [版本, 2018-7-12]
     */
    public void authValidate(BossQueryVo queryVo, Result result) {
        LoginEmployeeVo employeeVo = queryVo.getEmployeeVo();
        String menuCode = queryVo.getMenuCode();
        getBossAuthValidate(employeeVo, menuCode, result);
        Map<String, Object> data = result.getData();
        Assert.isTrue((Boolean) data.get("FW"), ErrorCode.UNAUTHORIZED);// 没有访问权限就报错
        queryVo.setCanSeeAmount((Boolean) data.get("CKCBJ"));
        data.clear();
    }

    /**
     * 加工查询参数
     * @throws Exception
     * @author hmj
     * @version [版本, 2018-7-12]
     */
    public Map<String, Object> getParamMap(BossQueryVo queryVo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        LoginEmployeeVo employeeVo = queryVo.getEmployeeVo();
        if (null != employeeVo) {
            Long companyId = null == queryVo.getCompanyId() ? employeeVo.getCompanyId() : queryVo.getCompanyId();
            Long sectionId = null == queryVo.getSectionId() ? employeeVo.getSectionId() : queryVo.getSectionId();
            map.put("employeeId", employeeVo.getId());
            map.put("groupId", employeeVo.getGroupId());
            map.put("companyId", companyId);
            map.put("sectionId", sectionId);
        }// 设置compayIds 和 sectionIds 参数且有默认值(当前登录员工所属公司,所属部门)
        map = putCompanySectionInMap(employeeVo, queryVo.getMenuCode(), map, queryVo.getCompanySectionParam());
        // 设置page 和pageSize 如果为空 给默认 1和20
        if (null == queryVo.getPage()) {
            queryVo.setPage(1);
        }
        if (null == queryVo.getPageSize()) {
            queryVo.setPageSize(20);
        }
        // 设置是否禁用参数
        if (null != queryVo.getContainsDisable()) {
            map.put("containsDisable", queryVo.getContainsDisable());
        }
        // 设置商品分类id
        if (null != queryVo.getGoodsClassId()) {
            map.put("goodsClassId", queryVo.getGoodsClassId());
        }
        // 设置商品品牌id
        if (null != queryVo.getGoodsBrandId()) {
            map.put("goodsBrandId", queryVo.getGoodsBrandId());
        }
        // 设置模糊查询关键字参数
        if (StringUtils.isNotBlank(queryVo.getKeyWord())) {
            map.put("keyWord", queryVo.getKeyWord());
        }
        // 设置是否公开库存量参数
        if (null != queryVo.getKcFalg() && queryVo.getKcFalg()) {
            map.put("kcFlag", 1);
        }
        // 设置查看成本价权限参数
        if (null != queryVo.getCanSeeAmount() && queryVo.getCanSeeAmount()) {
            map.put("canSeeAmount", 1);
        }
        // 设置商品id参数
        if (null != queryVo.getGoodsId()) {
            map.put("goodsId", queryVo.getGoodsId());
        }
        // 设置销售类型参数
        if (null != queryVo.getSalesType()) {
            map.put("salesType", queryVo.getSalesType());
        }
        // 设置查询起始时间参数
        if (StringUtils.isNotBlank(queryVo.getStartDate())) {
            map.put("startDate", queryVo.getStartDate());
        }
        // 设置查询截止时间参数
        if (StringUtils.isNotBlank(queryVo.getEndDate())) {
            map.put("endDate", queryVo.getEndDate());
        }
        // 设置对象类型参数
        if (StringUtils.isNotBlank(queryVo.getNodeType())) {
            map.put("nodeType", queryVo.getNodeType());
        }
        // 设置详情页模糊匹配参数
        if (StringUtils.isNotBlank(queryVo.getDetailKeyWord())) {
            map.put("detailKeyWord", queryVo.getDetailKeyWord());
        }
        // 设置供应商Id参数
        if (null != queryVo.getSupplierId()) {
            map.put("supplierId", queryVo.getSupplierId());
        }
        // 设置汇总字段参数
        if (StringUtils.isNotBlank(queryVo.getGroupField())) {
            map.put("groupField", queryVo.getGroupField());
        }
        // 设置串号id参数
        if (null != queryVo.getImeiId()) {
            map.put("imeiId", queryVo.getImeiId());
        }
        //设置运营商名称ID参数
        if (null!= queryVo.getOperatorId()){
            map.put("operatorId",queryVo.getOperatorId());
        }
        //设置运营商单位ID参数
        if (null!= queryVo.getOperatorUnitId()){
            map.put("operatorUnitId",queryVo.getOperatorUnitId());
        }
        //设置运营商业务ID参数
        if (null!= queryVo.getOperatorNameId()){
            map.put("operatorNameId",queryVo.getOperatorNameId());
        }
        //设置分期商ID参数
        if (null!= queryVo.getInstallmentfeesId()){
            map.put("installmentfeesId",queryVo.getInstallmentfeesId());
        }
        //设置分期业务ID参数
        if (null!= queryVo.getInstallmentBusinessId()){
            map.put("installmentBusinessId",queryVo.getInstallmentBusinessId());
        }
        //设置资金账户类型ID参数
        if (null!= queryVo.getAccountTypeId()){
            map.put("accountTypeId",queryVo.getAccountTypeId());
        }
        //设置排行依据参数
        if (StringUtils.isNotBlank(queryVo.getRankingGist())){
            map.put("rankingGist",queryVo.getRankingGist());
        }
        //设置排序字段参数
        if (StringUtils.isNotBlank(queryVo.getOrderField())){
            map.put("orderField",queryVo.getOrderField());
        }
        //设置库龄天数参数
        if (null!=queryVo.getStockAge()){
            map.put("stockAge",queryVo.getStockAge());
        }
        //设置第三方抵扣单位id参数
        if (null!=queryVo.getDeductionUnitsId()){
            map.put("deductionUnitsId",queryVo.getDeductionUnitsId());
        }
        //设置第三方抵扣活动id参数
        if (null!=queryVo.getActivityNamesId()){
            map.put("activityNamesId",queryVo.getActivityNamesId());
        }
        //设置增值服务id参数
        if (null!=queryVo.getServiceId()){
            map.put("serviceId",queryVo.getServiceId());
        }
        //设置查询调拨类型参数
        if (null!=queryVo.getAllotType()){
            map.put("allotType",queryVo.getAllotType());
        }
        return map;
    }

}
