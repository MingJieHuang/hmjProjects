package com.phone.erp.boss.service.demo.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.erp.boss.mapper.demo.ReportBaseDemoMapper;
import com.phone.erp.boss.service.demo.ReportBaseDemoService;
import com.phone.erp.boss.vo.demo.Animal;

@Service
@Transactional
public class ReportBaseDemoServiceImpl<T extends Animal> implements ReportBaseDemoService<T> {

	@Override
	public T getInstants(ReportBaseDemoMapper reprotBaseMapper,Class<T> clazz) {
		String header = reprotBaseMapper.getHeader();
		String body = reprotBaseMapper.getBody();
		String tail = reprotBaseMapper.getTail();
		try {
			T t = clazz.newInstance();
			t.setInfo(header + "," + body + "," + tail);
			return t;
		} catch (Exception e) {
			return null;
		}
	}
}
