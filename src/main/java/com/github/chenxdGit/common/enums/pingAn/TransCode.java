package com.github.chenxdGit.common.enums.pingAn;

public enum TransCode {
	
	/**
	 * 健康卡
	 */
	healthCard("0020");
	
	private  String value;
	
	TransCode(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}
}
