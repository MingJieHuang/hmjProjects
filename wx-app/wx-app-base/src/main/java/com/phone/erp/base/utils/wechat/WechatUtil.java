package com.phone.erp.base.utils.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.phone.erp.base.enums.ErrorCode;
import com.phone.erp.base.enums.MiniApp;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.vo.wechat.FullUserInfo;
import org.chrisli.utils.encrypt.EncryptUtil;
import org.chrisli.utils.json.JsonUtil;
import org.chrisli.utils.web.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * [微信工具类]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class WechatUtil {

    private static Logger logger = LoggerFactory.getLogger(WechatUtil.class);

    private static final String JSCODE_TO_SESSION_URL_FORMAT = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    /**
     * [使用临时登录凭证code获取微信账户敏感信息]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public static String getOpenid(MiniApp miniApp, String code, String userInfo) {
        String result = HttpUtil.httpFormUrlEncodedGet(String.format(JSCODE_TO_SESSION_URL_FORMAT, miniApp.getAppid(), miniApp.getSecret(), code));
        JSONObject sessionData = JSON.parseObject(result);
        String openid = sessionData.getString("openid");
        String sessionKey = sessionData.getString("session_key");
        Assert.notBlank(openid, ErrorCode.WECHAT_AUTO_LOGIN_OPENID_MISSING);
        logger.info("获取到微信用户的openid: " + openid);
        // 验证sessionKey是否合法
        FullUserInfo fullUserInfo = JsonUtil.jsonToBean(userInfo, FullUserInfo.class);
        String tempSignature = EncryptUtil.getSha1(fullUserInfo.getRawData() + sessionKey);
        logger.info("获取到微信用户的签名: " + fullUserInfo.getSignature());
        logger.info("获取到微信参数的签名: " + tempSignature);
        // TODO 暂时注释掉,部分用户(西安xi''an)参数验证会出问题
        // Assert.isTrue(fullUserInfo.getSignature().equals(tempSignature),
        // ErrorCode.WECHAT_AUTO_LOGIN_SIGNATURE_ILLEGAL);
        return openid;
    }

}
