package com.phone.erp.websocket.service.impl;

import com.phone.erp.base.vo.employee.EmployeeVo;
import com.phone.erp.websocket.mapper.login.LoginMapper;
import com.phone.erp.websocket.service.LoginService;
import com.phone.erp.websocket.vo.WebSocketUser;
import com.phone.erp.websocket.vo.login.LoginStatusVo;
import org.apache.commons.collections.CollectionUtils;
import org.chrisli.utils.reflect.ReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [账户登录服务类]
 *
 * @author Chris li
 * @version [版本, 2017-5-10]
 * @see
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void saveLoginStatus(WebSocketUser webSocketUser, Integer loginStatus) {
        // 首先判断表中是否存在,如果不存在,则插入,存在则更新
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("employeeId", webSocketUser.getUserId());
        paramMap.put("platform", webSocketUser.getClient().getType());
        List<LoginStatusVo> loginStatusVoList = loginMapper.getLoginStatusVoList(paramMap);
        paramMap.put("wsClientName", webSocketUser.getName());
        if (CollectionUtils.isNotEmpty(loginStatusVoList)) {
            // 存在登录记录
            if (loginStatusVoList.size() > 1) {
                // 删除重复的记录,保留最早的一条
                loginMapper.deleteDuplicatedLoginStatusVo(paramMap);
            }
            LoginStatusVo loginStatusVo = loginStatusVoList.get(0);
            loginStatusVo.setLoginStatus(loginStatus);
            loginStatusVo.setWsClientName(webSocketUser.getName());
            if (loginStatus.intValue() == 0) {
                loginStatusVo.setLoginTime(new Date());
            } else {
                loginStatusVo.setLogoutTime(new Date());
            }
            loginMapper.updateLoginStatusVo(ReflectUtil.beanToMap(loginStatusVo));
        } else {
            // 不存在登录记录
            paramMap.put("loginStatus", loginStatus);
            if (loginStatus.intValue() == 0) {
                paramMap.put("loginTime", new Date());
            } else {
                paramMap.put("logoutTime", new Date());
            }
            loginMapper.insertLoginStatusVo(paramMap);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public List<EmployeeVo> getRoleOnLineEmployeeVoList(Integer clientType, Long roleId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("clientType", clientType);
        paramMap.put("roleId", roleId);
        return loginMapper.getRoleOnLineEmployeeVoList(paramMap);
    }

    @Override
    public List<EmployeeVo> getExpiredOnLineEmployeeVoList(Integer clientType) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("clientType", clientType);
        return loginMapper.getExpiredOnLineEmployeeVoList(paramMap);
    }

}
