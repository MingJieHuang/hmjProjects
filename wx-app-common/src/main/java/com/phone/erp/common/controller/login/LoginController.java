package com.phone.erp.common.controller.login;

import com.phone.erp.base.Constants;
import com.phone.erp.base.Result;
import com.phone.erp.base.annotation.AuthValidate;
import com.phone.erp.base.controller.BaseController;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.enums.MiniApp;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.utils.wechat.WechatUtil;
import com.phone.erp.base.vo.company.CompanyVo;
import com.phone.erp.base.vo.employee.LoginEmployeeVo;
import com.phone.erp.common.service.login.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.chrisli.utils.encrypt.EncryptUtil;
import org.chrisli.utils.encrypt.JwtUtil;
import org.chrisli.utils.json.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [登录的控制类]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@RestController
@RequestMapping("${project.url.prefix}/login")
public class LoginController extends BaseController {
    /**
     * 微信登录失效时间(单位为秒)
     */
    @Value("${wechat.login.timeout}")
    private String timeout;

    @Autowired
    private LoginService loginService;

    /**
     * [首次登录,获取可使用公司集合]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    @RequestMapping("/getAccessCompanyVoList")
    @ResponseBody
    public Result getAccessCompanyVoList(String userName, String password) {
        LoginEmployeeVo loginEmployeeVo = validateEmployee(userName, password);
        List<CompanyVo> accessCompanyVoList = getAccessCompanyVoListByEmployeeId(loginEmployeeVo.getId());
        Assert.notEmpty(accessCompanyVoList, ErrorCode.HAS_NO_ACCESS_COMPANY);
        Result result = new Result();
        result.put("dataList", accessCompanyVoList);
        return result;
    }

    /**
     * [使用账号密码登录系统]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(String userName, String password, Long companyId, String code, String userInfo) {
        Assert.isTrue(companyId != null, ErrorCode.LOGIN_COMPANY_MISSING);
        Assert.notBlank(code, ErrorCode.WECHAT_LOGIN_PARAMS_MISSING);
        Assert.notBlank(userInfo, ErrorCode.WECHAT_LOGIN_PARAMS_MISSING);
        LoginEmployeeVo loginEmployeeVo = validateEmployee(userName, password);
        List<CompanyVo> accessCompanyVoList = getAccessCompanyVoListByEmployeeId(loginEmployeeVo.getId());
        Assert.notEmpty(accessCompanyVoList, ErrorCode.HAS_NO_ACCESS_COMPANY);
        CompanyVo loginCompanyVo = validateCompanyId(accessCompanyVoList, companyId);
        Assert.notNull(loginCompanyVo, ErrorCode.LOGIN_COMPANY_ILLEGAL);
        loginEmployeeVo.setCompanyId(loginCompanyVo.getId());
        loginEmployeeVo.setCompanyName(loginCompanyVo.getName());
        loginEmployeeVo.setLoginMiniAppCode(getCurrentMiniApp().getCode());
        // 绑定微信登录信息
        String openid = WechatUtil.getOpenid(getCurrentMiniApp(), code, userInfo);
        loginService.saveWechatEmployeeLogin(loginEmployeeVo, openid);
        Result result = new Result();
        result.put("loginEmployeeVo", loginEmployeeVo);
        result.put("accessCompanyVoList", accessCompanyVoList);
        result.put(Constants.LOGIN_TOKEN_KEY, JwtUtil.createToken(buildClaimMap(loginEmployeeVo), Long.valueOf(timeout) * 1000));
        return result;
    }

    /**
     * [验证账号密码是否能获取到用户,并检查用户状态]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    private LoginEmployeeVo validateEmployee(String userName, String password) {
        Assert.notBlank(userName, ErrorCode.USERNAME_OR_PASSWORD_MISSING);
        Assert.notBlank(password, ErrorCode.USERNAME_OR_PASSWORD_MISSING);
        // 验证登录账号
        LoginEmployeeVo loginEmployeeVo = loginService.getLoginEmployeeVoByUserName(userName);
        Assert.notNull(loginEmployeeVo, ErrorCode.USERNAME_OR_PASSWORD_ILLEGAL);
        // 验证密码
        Assert.isTrue(loginEmployeeVo.getPassword().equals(EncryptUtil.getMd5(password)), ErrorCode.USERNAME_OR_PASSWORD_ILLEGAL);
        // 验证用户状态
        Assert.isTrue(loginEmployeeVo.getStatus().intValue() != 1, ErrorCode.LOGIN_EMPLOYEE_DISABLED);
        // 验证用户类型
        Assert.isTrue(loginEmployeeVo.getOperatorFlag().intValue() == 1, ErrorCode.LOGIN_EMPLOYEE_IS_NOT_OPERATOR);
        // 验证集团状态
        Assert.isFalse(loginEmployeeVo.getGroupStatus().intValue() == 1, ErrorCode.LOGIN_GROUP_DISABLED);
        Assert.isFalse(loginEmployeeVo.getGroupStatus().intValue() == 2, ErrorCode.LOGIN_GROUP_DELETED);
        // 验证公司状态
        Assert.isFalse(loginEmployeeVo.getCompanyStatus().intValue() == 1, ErrorCode.LOGIN_COMPANY_DISABLED);
        Assert.isFalse(loginEmployeeVo.getCompanyStatus().intValue() == 2, ErrorCode.LOGIN_COMPANY_DELETED);
        // 验证通过,处理敏感信息
        loginEmployeeVo.setPassword("********");
        return loginEmployeeVo;
    }

    /**
     * [微信账号自动登录]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    @RequestMapping("/autoLogin")
    public Result autoLogin(String code, String userInfo) throws Exception {
        Assert.notBlank(code, ErrorCode.WECHAT_LOGIN_PARAMS_MISSING);
        Assert.notBlank(userInfo, ErrorCode.WECHAT_LOGIN_PARAMS_MISSING);
        String openid = WechatUtil.getOpenid(getCurrentMiniApp(), code, userInfo);
        LoginEmployeeVo loginEmployeeVo = loginService.getLoginEmployeeVoByOpenid(getCurrentMiniApp().getCode(), openid);
        Result result = new Result();
        Assert.notNull(loginEmployeeVo, ErrorCode.WECHAT_AUTO_LOGIN_FAILED);
        List<CompanyVo> accessCompanyVoList = getAccessCompanyVoListByEmployeeId(loginEmployeeVo.getId());
        Assert.notEmpty(accessCompanyVoList, ErrorCode.HAS_NO_ACCESS_COMPANY);
        result.put("loginEmployeeVo", loginEmployeeVo);
        result.put("accessCompanyVoList", accessCompanyVoList);
        result.put(Constants.LOGIN_TOKEN_KEY, JwtUtil.createToken(buildClaimMap(loginEmployeeVo), Long.valueOf(timeout) * 1000));
        return result;
    }

    /**
     * [切换登录公司]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    @AuthValidate
    @RequestMapping("/changeLoginCompany")
    @ResponseBody
    public Result changeLoginCompany(String code, String userInfo, Long companyId) throws Exception {
        Assert.notBlank(code, ErrorCode.WECHAT_LOGIN_PARAMS_MISSING);
        Assert.notBlank(userInfo, ErrorCode.WECHAT_LOGIN_PARAMS_MISSING);
        Assert.notNull(companyId, ErrorCode.USERNAME_OR_PASSWORD_MISSING);
        Assert.isTrue(companyId != null, ErrorCode.LOGIN_COMPANY_MISSING);
        LoginEmployeeVo currentEmployeeVo = getCurrentEmployeeVo();
        List<CompanyVo> accessCompanyVoList = getAccessCompanyVoListByEmployeeId(currentEmployeeVo.getId());
        Assert.notEmpty(accessCompanyVoList, ErrorCode.HAS_NO_ACCESS_COMPANY);
        CompanyVo loginCompanyVo = validateCompanyId(accessCompanyVoList, companyId);
        Assert.notNull(loginCompanyVo, ErrorCode.LOGIN_COMPANY_ILLEGAL);
        currentEmployeeVo.setCompanyId(loginCompanyVo.getId());
        currentEmployeeVo.setCompanyName(loginCompanyVo.getName());
        // 绑定微信登录信息
        String openid = WechatUtil.getOpenid(MiniApp.getMatchedInstance(currentEmployeeVo.getLoginMiniAppCode()), code, userInfo);
        loginService.saveWechatEmployeeLogin(currentEmployeeVo, openid);
        Result result = new Result();
        result.put("loginEmployeeVo", currentEmployeeVo);
        result.put("accessCompanyVoList", accessCompanyVoList);
        result.put(Constants.LOGIN_TOKEN_KEY, JwtUtil.createToken(buildClaimMap(currentEmployeeVo), Long.valueOf(timeout) * 1000));
        return result;
    }

    /**
     * [获取可使用公司集合]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    private List<CompanyVo> getAccessCompanyVoListByEmployeeId(Long employeeId) {
        return loginService.getAccessCompanyVoListByEmployeeId(employeeId);
    }

    /**
     * [验证登录的公司是否合法]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    private CompanyVo validateCompanyId(List<CompanyVo> accessCompanyVoList, Long companyId) {
        for (CompanyVo companyVo : accessCompanyVoList) {
            if (companyVo.getId().longValue() == companyId.longValue()) {
                return companyVo;
            }
        }
        return null;
    }

    /**
     * [生成载荷Map]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    private Map<String, String> buildClaimMap(LoginEmployeeVo loginEmployeeVo) {
        Map<String, String> claimMap = new HashMap<String, String>();
        claimMap.put(Constants.TOKEN_CLAIM_CUR_EMP_KEY, JsonUtil.beanToJson(loginEmployeeVo));
        claimMap.put(Constants.TOKEN_CLAIM_CUR_APP_KEY, StringUtils.isNotBlank(loginEmployeeVo.getLoginMiniAppCode()) ? loginEmployeeVo
                .getLoginMiniAppCode() : getCurrentMiniApp().getCode());
        return claimMap;
    }
}
