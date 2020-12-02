package com.github.chenxdGit.common.exception;

/**
 *	基础异常
 * @author 陈晓东
 *
 */
public abstract class BaseException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4240112437069105602L;
	private  Object  data;
	
	
	private  Integer  code =200;
	
	private  String  message;
	
	public Object getData() {
		return data;
	}
	public void  setData(Object  data) {
		this.data= data ;
	}
	
	public Integer getCode() {
		return code;
	}
	public void  setCode(Integer  code) {
		this.code= code;
	}
	
	public String getMessage() {
		return message;
	}
	public void  setMessage(String  message) {
		this.message= message ;
	}
	public BaseException(String message) {
		super(message);
		this.message= message ;
	}
	public <T> BaseException(String msg, T data) {
		super(msg);
		setData(data);
	}

}	