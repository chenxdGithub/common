package com.github.chenxdGit.common.permission;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SPermissionMapper extends BaseMapper<SPermission>{
	@SelectProvider(type = SPermissionProvider.class, method = "query")
	public List<SMenu> query(SPermission param);
}
