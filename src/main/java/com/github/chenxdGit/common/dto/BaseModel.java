package com.github.chenxdGit.common.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class BaseModel  extends  DeleteModel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8406965443426261868L;
	/**
	 * 
	 */
	@TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Long id;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private  Long createBy;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private  Long updateBy;
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime; 
}
