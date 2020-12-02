package com.github.chenxdGit.common.enums.pingAn;

public enum Charset {
	
	/**
	 * GBK
	 */
	GBK("GBK"),
	/**
	 * UTF8
	 */
	UTF8("UTF-8");
	
	private  String value;
	
	Charset(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}
}
