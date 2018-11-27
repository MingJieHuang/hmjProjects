package com.phone.erp.common.service.login.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.erp.base.vo.company.CompanyVo;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import com.phone.erp.common.mapper.login.LoginMapper;
import com.phone.erp.common.service.login.LoginService;

/**
 * [登录的服务类实现]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginEmployeeVo getLoginEmployeeVoByUserName(String userName) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userName", userName);
        return loginMapper.getLoginEmployeeVoByUserName(paramMap);
    }

    @Override
    public LoginEmployeeVo getLoginEmployeeVoByOpenid(String loginMiniAppCode, String openid) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("openid", openid);
        paramMap.put("loginMiniAppCode", loginMiniAppCode);
        return loginMapper.getLoginEmployeeVoByOpenid(paramMap);
    }

    @Override
    public List<CompanyVo> getAccessCompanyVoListByEmployeeId(Long employeeId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("employeeId", employeeId);
        return loginMapper.getAccessCompanyVoListByEmployeeId(paramMap);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void saveWechatEmployeeLogin(LoginEmployeeVo currentEmployeeVo, String openid) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("groupId", currentEmployeeVo.getGroupId());
        paramMap.put("companyId", currentEmployeeVo.getCompanyId());
        paramMap.put("employeeId", currentEmployeeVo.getId());
        paramMap.put("loginMiniAppCode", currentEmployeeVo.getLoginMiniAppCode());
        paramMap.put("openid", openid);

        loginMapper.deleteWechatEmployeeLogin(paramMap);
        loginMapper.insertWechatEmployeeLogin(paramMap);
    }

}
