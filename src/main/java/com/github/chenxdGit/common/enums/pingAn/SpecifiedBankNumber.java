package com.github.chenxdGit.common.enums.pingAn;

public enum SpecifiedBankNumber {
	
	/**
	 * CMA
	 */
	CMA("C"),
	/**
	 * WITHHOLD
	 */
	WITHHOLD("D");
	
	private  String value;
	
	SpecifiedBankNumber(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}
}
