package com.github.chenxdGit.common.permission;

import com.baomidou.mybatisplus.annotation.TableField;
import com.github.chenxdGit.common.dto.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SPermission extends BaseModel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8831002722212782650L;
	private Long menuId;
	private Long roleId;
	@TableField(exist = false)
	private Integer type;
	@TableField(exist = false)
	private Long[]  roleIds;
}