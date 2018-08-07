package com.phone.erp.boss.service.demo;

import com.phone.erp.boss.mapper.demo.ReportBaseDemoMapper;
import com.phone.erp.boss.vo.demo.Animal;

public interface ReportBaseDemoService<T extends Animal> {
	T getInstants(ReportBaseDemoMapper reprotBaseMapper, Class<T> clazz);
}
