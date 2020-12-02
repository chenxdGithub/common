package com.github.chenxdGit.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.chenxdGit.common.sysInterface.UserInfo;


public  class UserInfoUtil{
	
	public  static <T extends UserInfo> T getUserInfo (Class<T> userInfoClass) throws InstantiationException, IllegalAccessException {
		Long commonId = getCommonId();
		if(StringUtil.isNull(commonId)) {
			return null;
		}
		T userInfo = RedisUtil.getUserInfo(userInfoClass, getCommonId());
		return (T)userInfo;
	}
	
	public  static <T extends UserInfo> T getUserInfoNotRefresh (Class<T> userInfoClass) throws InstantiationException, IllegalAccessException {
		Long commonId = getCommonId();
		if(StringUtil.isNull(commonId)) {
			return null;
		}
		T userInfo = RedisUtil.getUserInfoNotRefresh(userInfoClass, getCommonId());
		return (T)userInfo;
	}
	
	public static  <T extends UserInfo > void putUserInfo (T userInfo) {
		RedisUtil.putUserInfo(userInfo);
	}
	public static  <T extends UserInfo > T refreshUserInfo (Class<T> userInfoClass,Long commonId) throws InstantiationException, IllegalAccessException {
		T refreshUserInfo = RedisUtil.refreshUserInfo(userInfoClass,commonId);
		return  refreshUserInfo;
	}
	public static Long   getCommonId ()  {
		ServletRequestAttributes servletRequestAttributes =(ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		String jwt = servletRequestAttributes.getRequest().getHeader(JwtUtil.getTokenSecret());
		if(StringUtil.isNull(jwt)) {
			return null;
		}
		Long commonId =JwtUtil.getClaim(jwt);
		return commonId;
	}
}
