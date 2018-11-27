package com.phone.erp.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.phone.erp.base.vo.employee.LoginEmployeeVo;

/**
 * [开发配置,定义一些开发阶段的调试参数]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@Configuration
public class DevModelConfig {

    /**
     * 是否启用开发模式
     */
    @Value("${dev.model.enable}")
    private String devModelEnable;

    /**
     * 开发者模式默认集团ID
     */
    @Value("${dev.model.groupId}")
    private String devModelGroupId;

    /**
     * 开发者模式默认公司ID
     */
    @Value("${dev.model.companyId}")
    private String devModelCompanyId;

    /**
     * 开发者模式默认部门ID
     */
    @Value("${dev.model.sectionId}")
    private String devModelSectionId;

    /**
     * 开发者模式默认员工ID
     */
    @Value("${dev.model.employeeId}")
    private String devModelEmployeeId;

    /**
     * 开发者模式默认微信小程序
     */
    @Value("${dev.model.miniAppCode}")
    private String devModelMiniAppCode;

    /**
     * [是否是开发模式]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public boolean isDevModel() {
        return "true".equalsIgnoreCase(devModelEnable);
    }

    /**
     * [获取开发模式下的默认员工对象]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public LoginEmployeeVo getDevModelEmployeeVo() {
        LoginEmployeeVo loginEmployeeVo = new LoginEmployeeVo();
        loginEmployeeVo.setGroupId(Long.valueOf(devModelGroupId));
        loginEmployeeVo.setCompanyId(Long.valueOf(devModelCompanyId));
        loginEmployeeVo.setSectionId(Long.valueOf(devModelSectionId));
        loginEmployeeVo.setId(Long.valueOf(devModelEmployeeId));
        loginEmployeeVo.setLoginMiniAppCode(devModelMiniAppCode);
        return loginEmployeeVo;
    }
}
