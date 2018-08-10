package com.phone.erp.boss;

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
@MapperScan("com.phone.erp.boss.mapper")
public class BossApplication {

	/**
	 * [SpringBoot启动的方法]
	 * 
	 * @author Chris li[黎超]
	 * @version [版本, 2017-04-12]
	 */
	public static void main(String[] args) {
		SpringApplication.run(BossApplication.class, args);
	}
}
