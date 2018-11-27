package com.phone.erp.common.service.login;

import com.phone.erp.base.vo.company.CompanyVo;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;

import java.util.List;

/**
 * [登录的服务类]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public interface LoginService {

    /**
     * [通过登录账号获取登录员工信息]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public LoginEmployeeVo getLoginEmployeeVoByUserName(String userName);

    /**
     * [通过openid获取登录员工信息]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public LoginEmployeeVo getLoginEmployeeVoByOpenid(String loginMiniAppCode, String openid);

    /**
     * [通过员工id获取可使用公司集合]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public List<CompanyVo> getAccessCompanyVoListByEmployeeId(Long employeeId);

    /**
     * [保存微信账号与ERP员工登录信息绑定]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public void saveWechatEmployeeLogin(LoginEmployeeVo currentEmployeeVo, String openid);
}
