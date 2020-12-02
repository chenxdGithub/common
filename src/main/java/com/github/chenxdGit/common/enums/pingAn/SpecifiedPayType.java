package com.github.chenxdGit.common.enums.pingAn;

public enum SpecifiedPayType {
	
	/**
	 * CMA
	 */
	CMA("CMA"),
	/**
	 * WITHHOLD
	 */
	WITHHOLD("WITHHOLD");
	
	private  String value;
	
	SpecifiedPayType(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}
}
