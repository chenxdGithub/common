package com.github.chenxdGit.common.dto;

import java.util.Date;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CommonUser extends  BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6901964361677853976L;
	/**
     * 用户姓名
     */
    private  String name;
    /**
     * wx_unionId
     */
    private  String weixinUnionid;
    /**
     * 手机号
     */
    private  String mobile;
    /**
     * 账号
     */
    private  String account;
    /**
     * 密码
     */
    private  String password;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 性别
     */
    private String sex;
    
    /**
     * 头像
     */
    private String avatar;
    
}
