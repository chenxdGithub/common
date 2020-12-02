package com.github.chenxdGit.common.permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@Service
public class SPermissionService  {
	
	@Autowired
	private SPermissionMapper sPermissionMapper;
	@Autowired
	private MenuMapper menuMapper;
	
	
	public HashMap<String, SMenu> getCommonUrl (){
    	QueryWrapper<SMenu> sRoleQueryWrapper = new  QueryWrapper<SMenu>();
    	HashMap<String,SMenu>  url = new HashMap<String, SMenu>();
    	sRoleQueryWrapper.lambda().eq(SMenu::getType,10011003);
    	List<SMenu> menuList = menuMapper.selectList(sRoleQueryWrapper);
		for (SMenu sMenu : menuList) {
			url.put(sMenu.getPath(), sMenu);
		}
		return url;
	}
	
	public  PermissionDto  getPerPermissionByRoleId(Long[]  roleIds) {
		SPermission sp = new SPermission();
		HashMap<String,SMenu>  url = new HashMap<String, SMenu>();
		sp.setRoleIds(roleIds);
		// 原始的数据
		List<SMenu> menuList = sPermissionMapper.query(sp);
		// 最后的结果
		List<SMenu> newMenuList = new ArrayList<>();
		// 先找到所有的一级菜单
		for (int i = 0; i < menuList.size(); i++){
			SMenu SMenuDto=menuList.get(i);
		    Long pId=SMenuDto.getPId();
		    // 如果是顶级菜单，没有父菜单
		    Integer type = SMenuDto.getType();
			if (pId==null&&type==10011001){
		        newMenuList.add(SMenuDto);
		    }else if(type==10011002) {
		    	url.put(SMenuDto.getPath(), SMenuDto);
		    }
		}
		// 为一级菜单设置子菜单，getChild是递归调用的
		for (SMenu menu : newMenuList) {
		    menu.setChildren((getChild(menu.getId(), menuList)));
		}
		PermissionDto p = new PermissionDto();
		p.setMenus(newMenuList);
		url.putAll(getCommonUrl());
		p.setUrl(url);
		return p;
	}
	
//    递归查找子菜单
	private List<SMenu> getChild(long id,List<SMenu> rootMenu) {
	    // 子菜单
	    List<SMenu> childList = new ArrayList<>();
	    for (SMenu menu : rootMenu) {
	        // 遍历所有节点，将父菜单id与传过来的id比较
	        Long pId = menu.getPId();
			if (pId!=null&&pId==id) {
	            childList.add(menu);
	        }
    }
    // 把子菜单的子菜单再循环一遍
    for (SMenu menu : childList) {
            // 递归
            menu.setChildren(getChild(menu.getId(), rootMenu));
    }
    // 递归退出条件
    if (childList.size() == 0) {
        return null;
    }
    return childList;
}
}
