package com.github.chenxdGit.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.chenxdGit.common.permission.PermissionDto;
import com.github.chenxdGit.common.permission.SMenu;
import com.github.chenxdGit.common.permission.SPermissionService;
import com.github.chenxdGit.common.exception.UnauthorizedException;
import com.github.chenxdGit.common.sysInterface.UserInfo;
public  class PermissionUtil{
	
	public  static <T  extends UserInfo> PermissionDto getPermissionDto (T userInfo) throws InstantiationException, IllegalAccessException {
		if(userInfo==null) {
			throw new UnauthorizedException("用户信息不存在");
		}
		PermissionDto permissionDto = RedisUtil.getPermission(userInfo);
		if(permissionDto==null) {
			SPermissionService beanByType = ApplicationContextAwareHelper.getBeanByType(SPermissionService.class);
			Long[] roleIds = userInfo.getRoleIds();
			PermissionDto perPermissionByRoleId  = null;
			if(roleIds!=null) {
				perPermissionByRoleId = beanByType.getPerPermissionByRoleId(roleIds);
			}
			if(perPermissionByRoleId!=null) {
				RedisUtil.putPermission(userInfo, perPermissionByRoleId);
				return perPermissionByRoleId;
			}
			permissionDto = new PermissionDto();
			List<SMenu>  menus = new ArrayList<SMenu>();
			Map<String,SMenu>  url = new HashMap<String,SMenu>();
			permissionDto.setMenus(menus);
			permissionDto.setUrl(url);
			return permissionDto;
		}
		return permissionDto;
	}
	
	public  static <T  extends UserInfo> void removePermissionDto (T userInfo) {
		if(userInfo==null) {
			throw new UnauthorizedException("用户信息不存在");
		}
		RedisUtil.deletePermission(userInfo);
	}
}
