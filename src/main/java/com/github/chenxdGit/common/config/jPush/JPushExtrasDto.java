package com.github.chenxdGit.common.config.jPush;

import lombok.Data;

@Data
public class JPushExtrasDto {
	/**
	 * 跳转url
	 */
	private String url;
	/**
	 * 跳转类型 
	 * 10141001  app内页面
	 * 10141002	 网页地址
	 */
	private String jumpType;
}