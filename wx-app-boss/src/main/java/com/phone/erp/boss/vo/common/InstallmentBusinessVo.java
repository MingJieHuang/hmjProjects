package com.phone.erp.boss.vo.common;

import com.phone.erp.base.vo.BaseResultVo;

import java.util.List;

/**
 * 分期商业务名称组件Vo类
 * @author hmj
 * @create 2018-09-05 9:40
 */
public class InstallmentBusinessVo extends BaseResultVo {
    List<BossConditionVo> installmentBusinessList;

    public List<BossConditionVo> getInstallmentBusinessList() {
        return installmentBusinessList;
    }

    public void setInstallmentBusinessList(List<BossConditionVo> installmentBusinessList) {
        this.installmentBusinessList = installmentBusinessList;
    }
}
