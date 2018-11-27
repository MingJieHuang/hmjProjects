package com.phone.erp.websocket.service;

import com.phone.erp.base.vo.employee.EmployeeVo;
import com.phone.erp.websocket.vo.WebSocketUser;

import java.util.List;

/**
 * [登录模块服务接口]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public interface LoginService {

    /**
     * [保存登录信息,登录状态 0:在线;1:离线]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    void saveLoginStatus(WebSocketUser webSocketUser, Integer loginStatus);

    /**
     * [获取指定客户端平台指定角色下所有在线用户信息集合]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    List<EmployeeVo> getRoleOnLineEmployeeVoList(Integer clientType, Long roleId);

    /**
     * [获取指定客户端平台过期的在线用户信息集合]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    List<EmployeeVo> getExpiredOnLineEmployeeVoList(Integer clientType);

}
