package com.phone.erp.websocket.mapper.login;

import com.phone.erp.base.vo.employee.EmployeeVo;
import com.phone.erp.websocket.vo.login.LoginStatusVo;

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
     * [获取账号登录记录信息]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    List<LoginStatusVo> getLoginStatusVoList(Map<String, Object> paramMap);

    /**
     * [删除重复的登录记录,保留最早的一条]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    void deleteDuplicatedLoginStatusVo(Map<String, Object> paramMap);

    /**
     * [新增登录记录]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    void insertLoginStatusVo(Map<String, Object> paramMap);

    /**
     * [修改登录记录]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    void updateLoginStatusVo(Map<String, Object> paramMap);

    /**
     * [获取指定客户端平台下指定角色下所有在线用户信息集合]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    List<EmployeeVo> getRoleOnLineEmployeeVoList(Map<String, Object> paramMap);

    /**
     * [获取指定客户端平台下所有过期的在线用户信息集合]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    List<EmployeeVo> getExpiredOnLineEmployeeVoList(Map<String, Object> paramMap);

}
