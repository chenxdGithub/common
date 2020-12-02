package com.github.chenxdGit.common.enums.pingAn;

public enum SignMethod {
	
	/**
	 *SHA-256
	 */
	SHA256("SHA-256"),
	/**
	 * RSA
	 */
	RSA("RSA");
	
	private  String value;
	
	SignMethod(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}
}
