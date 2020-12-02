package com.github.chenxdGit.common.permission;

import com.github.chenxdGit.common.util.StringUtil;

public class SPermissionProvider {
	public static final String querySql = "select  "
			+ "sm.id,"
			+ "sm.p_id,"
			+ "sm.name,"
			+ "sm.icon,"
			+ "sm.type,"
			+ "sm.path,"
			+ "sm.redirect,"
			+ "sm.hidden,"
			+ "sm.component,"
			+ "sm.title,"
			+ "sm.create_time,"
			+ "sm.create_by,"
			+ "sm.update_by,"
			+ "sm.update_time,"
			+ "sm.version "
			+ "from  s_permission sp inner join s_menu sm on sm.id = sp.menu_id and sm.deleted = 0  "
			+ " where 1=1 \n";
	public String query(SPermission param) {
		StringBuffer sb = new StringBuffer(querySql);
		if(StringUtil.isNotNull(param.getId()) ) {
			sb.append( " AND sm.id = #{id} ");
		}
		Long[] roleIds = param.getRoleIds();
		if(StringUtil.isNotNull(roleIds) ) {
			String roleStr = "0";
			for (Long roleId : roleIds) {
				roleStr +=(","+roleId);
			}
			sb.append( " AND sp.role_id in("+roleStr+") ");
		}
		if(StringUtil.isNotNull(param.getType()) ) {
			sb.append( " AND sm.type = #{type} ");
		}
		sb.append( " AND sp.deleted = 0 ");
		sb.append( " order by  sm.order ASC ");
		return sb.toString();
	}
}
