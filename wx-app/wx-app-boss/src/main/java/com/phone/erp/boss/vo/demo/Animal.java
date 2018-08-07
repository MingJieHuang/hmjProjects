package com.phone.erp.boss.vo.demo;

public abstract class Animal {
	private String info;

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
	
	@Override
	public String toString() {
		return info;
	}
}
