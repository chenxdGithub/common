package com.github.chenxdGit.common.enums.pingAn;

public enum Version {
	
	/**
	 * 版本code
	 */
	CODE("1.0.0");
	
	private  String value;
	
	Version(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}
}
