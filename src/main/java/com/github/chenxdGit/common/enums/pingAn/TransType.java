package com.github.chenxdGit.common.enums.pingAn;

public enum TransType {
	
	/**
	 * 消费
	 */
	consume("001"),
	/**
	 *退款
	 */
	refunds("002"),
	/**
	 * 获取时间磋
	 */
	getTimstamp("003"),
	/**
	 * 消费
	 */
	notice("004"),
	/**
	 * 信息查询
	 */
	informationSerch("005");
	
	private  String value;
	
	TransType(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}
}
