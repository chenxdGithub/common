package com.github.chenxdGit.common.permission;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class PermissionDto  {
	List<SMenu>  menus;
	Map<String,SMenu>  url;
}