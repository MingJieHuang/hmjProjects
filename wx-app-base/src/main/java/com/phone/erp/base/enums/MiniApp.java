package com.phone.erp.base.enums;

import com.phone.erp.base.utils.Assert;
import org.chrisli.utils.exception.AssertFailedException;

/**
 * [小程序系统]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public enum MiniApp {
    /**
     * 云盛店员助手小程序
     */
    CLERK_ASSISTANT("0001", "店员助手小程序", "wxbebb5fca8a3b9e3d", "e92845b5b48873be9e1b4026af04c5ec"),
    /**
     * 云盛老板报表小程序
     */
    BOSS_REPORT("0002", "老板报表小程序", "wx9f22d7e7010593c1", "3379cc5d6e647de9920d1e0d7f50377c"),;

    private final String code;

    private final String name;

    private final String appid;

    private final String secret;

    MiniApp(String code, String name, String appid, String secret) {
        this.code = code;
        this.name = name;
        this.appid = appid;
        this.secret = secret;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getAppid() {
        return appid;
    }

    public String getSecret() {
        return secret;
    }

    /**
     * [获取匹配的实例]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public static MiniApp getMatchedInstance(String code) {
        Assert.notBlank(code, "小程序编号不允许为空!");
        for (MiniApp miniApp : MiniApp.values()) {
            if (miniApp.getCode().equalsIgnoreCase(code)) {
                return miniApp;
            }
        }
        throw new AssertFailedException(String.format("非法的小程序编号[%s]", code));
    }
}
