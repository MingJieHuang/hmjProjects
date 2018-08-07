package com.phone.erp.boss.controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phone.erp.base.Result;
import com.phone.erp.base.controller.BaseController;
import com.phone.erp.boss.mapper.demo.CatMapper;
import com.phone.erp.boss.mapper.demo.DogMapper;
import com.phone.erp.boss.service.demo.ReportBaseDemoService;
import com.phone.erp.boss.vo.demo.Cat;
import com.phone.erp.boss.vo.demo.Dog;

@RestController
@RequestMapping("${project.url.prefix}/base")
public class ReportBaseDemoController extends BaseController {

	@Autowired
	private ReportBaseDemoService<Dog> dogService;
	@Autowired
	private ReportBaseDemoService<Cat> catService;
	@Autowired
	private DogMapper dogMapper;
	@Autowired
	private CatMapper catMapper;

	@RequestMapping("/forTest")
	public Result forTest() {
		Dog dog = dogService.getInstants(dogMapper, Dog.class);
		System.out.println(dog);
		Cat cat = catService.getInstants(catMapper, Cat.class);
		System.out.println(cat);
		return new Result();
	}
}
