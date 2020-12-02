package com.github.chenxdGit.common.permission;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.github.chenxdGit.common.dto.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SMenu extends BaseModel  {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 9217049087001900304L;
	private String name;
	private String icon;
	private Integer type;
	private Long pId;
	private String path;
	private String redirect;
	private Boolean hidden;
	private String component;
	private String title;
	@TableField(exist = false)
	private List<SMenu> children;
}