package com.github.chenxdGit.common.enums;

public enum RedisKey {
	officialAccountsToken("officialAccount.token","公众号token");
	
	private  String remake;
	private  String value;
	RedisKey(String value,String remake) {
		this.value = value;
		this.remake = remake;
	}

	public String value() {
		return this.value;
	}
	public String remake() {
		return this.remake;
	}

}
