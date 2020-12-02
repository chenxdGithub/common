package com.github.chenxdGit.common.enums;

public enum Sex {
	
	/**
	 * 未知
	 */
	unknown("未知"),
	/**
	 * 男
	 */
	man("男"),
	/**
	 * 女
	 */
	woman("女");
	
	private  String value;
	
	Sex(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}
}
