package com.phone.erp.base.vo.wechat;

import java.io.Serializable;

/**
 * [小程序从微信中获取的完整用户信息]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class FullUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String errMsg;
    private String rawData;
    private UserInfo userInfo;
    private String encryptedData;
    private String iv;
    private String signature;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
