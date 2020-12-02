package com.github.chenxdGit.common.exception;

/**
 * 	没有访问该资源的权限异常 403
 * @author 陈晓东
 *
 */
public class ForbiddenException extends BaseException {
	private static final long serialVersionUID = 1L;
	public ForbiddenException(String msg) {
		super(msg);
	}

	public ForbiddenException(String msg, Throwable ex) {
		super(msg, ex);
	}

}