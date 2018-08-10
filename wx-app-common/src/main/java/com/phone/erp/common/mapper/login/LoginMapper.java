package com.phone.erp.common.mapper.login;

import com.phone.erp.base.vo.company.CompanyVo;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;

import java.util.List;
import java.util.Map;

/**
 * [登录的mapper]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public interface LoginMapper {
    /**
     * [通过用户账号获取登录员工信息]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    LoginEmployeeVo getLoginEmployeeVoByUserName(Map<String, Object> paramMap);

    /**
     * [通过openid获取登录员工信息]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    LoginEmployeeVo getLoginEmployeeVoByOpenid(Map<String, Object> paramMap);

    /**
     * [通过员工id获取可使用公司集合]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    List<CompanyVo> getAccessCompanyVoListByEmployeeId(Map<String, Object> paramMap);

    /**
     * [删除微信账号与ERP员工登录信息绑定]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    void deleteWechatEmployeeLogin(Map<String, Object> paramMap);

    /**
     * [新增微信账号与ERP员工登录信息绑定]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    void insertWechatEmployeeLogin(Map<String, Object> paramMap);

}
