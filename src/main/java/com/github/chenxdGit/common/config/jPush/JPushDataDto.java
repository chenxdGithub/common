package com.github.chenxdGit.common.config.jPush;

import lombok.Data;

@Data
public class JPushDataDto {
	/**
	 * registrationId
	 */
	private String registrationId;
	/**
	 * 消息主体
	 */
	private String content;
	/**
	 * 消息标题
	 */
	private String title;
	/**
	 *附加参数extras
	 */
	private JPushExtrasDto extras;
}