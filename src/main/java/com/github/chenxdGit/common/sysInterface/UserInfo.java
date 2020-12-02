package com.github.chenxdGit.common.sysInterface;

/**
 * 用户信息接口
 * @author 陈晓东
 *
 */
public interface UserInfo  {
	
	public  Long getCommonId() ;
	
	public default void setRoleId(Long[] roleIds) {
	};
	
	public default Long[] getRoleIds() {
		return null;
	};
	
	public  boolean getOnChange() ;
	
	public  void setOnChange(boolean onChange) ;

	public <T extends UserInfo > T refreshUserInfo(Long commonId);
}
