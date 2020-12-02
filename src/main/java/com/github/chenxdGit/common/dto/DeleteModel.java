package com.github.chenxdGit.common.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import lombok.Data;
@Data
public class DeleteModel {
    @TableLogic
    @TableField(value = "deleted")
    private boolean deleted;
}
