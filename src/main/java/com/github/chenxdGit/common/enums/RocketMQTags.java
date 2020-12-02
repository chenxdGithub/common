package com.github.chenxdGit.common.enums;

public enum RocketMQTags {
	officialAccounts("officialAccounts","公众号推送Tags");
	
	private  String remake;
	private  String value;
	RocketMQTags(String value, String remake) {
		this.remake = remake;
		this.value = value;
	}
	public String value() {
		return this.value;
	}
	public String remake() {
		return this.remake;
	}
}
