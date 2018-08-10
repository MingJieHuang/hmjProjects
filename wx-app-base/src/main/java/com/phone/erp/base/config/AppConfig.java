package com.phone.erp.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * [小程序配置类,须指定当前小程序的编号]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@Configuration
public class AppConfig {

    /**
     * 小程序编号
     */
    @Value("${wechat.mini.app.code}")
    private String miniAppCode;

    public String getMiniAppCode() {
        return miniAppCode;
    }

}
