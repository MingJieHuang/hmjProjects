package com.phone.erp.websocket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Websocket项目启动类
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.phone.erp")
@MapperScan("com.phone.erp.websocket.mapper")
public class WebSocketApplication {

    /**
     * [SpringBoot启动的方法]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }
}
