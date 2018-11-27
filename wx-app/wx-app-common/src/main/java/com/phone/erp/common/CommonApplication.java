package com.phone.erp.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Boss项目启动类
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.phone.erp")
@MapperScan("com.phone.erp.common.mapper")
public class CommonApplication {

    /**
     * [SpringBoot启动的方法]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }
}
