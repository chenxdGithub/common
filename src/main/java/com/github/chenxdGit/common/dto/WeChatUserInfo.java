package com.github.chenxdGit.common.dto;

import java.util.Date;

import com.github.chenxdGit.common.sysInterface.UserInfo;

import lombok.Data;

@Data
public class WeChatUserInfo implements UserInfo {
	private Integer subscribe;
	private String openid;
	private String nickname;
	private Integer sex;
	private String language;
	private String city;
	private String province;
	private String country;
	private String headimgurl;
	private Date subscribe_time;
	private String unionid;
	private Integer groupid;
	private Integer[] tagid_list;
	private String subscribe_scene;
	private Integer qr_scene;
	private String qr_scene_str;
	private Long commonId;
	private boolean onChange;
	
	public void setCommonId(Long commonId) {
	}
	@Override
	public Long getCommonId() {
		return Long.parseLong(this.unionid.hashCode()+"") ;
	}
	@Override
	public boolean getOnChange() {
		return false;
	}
	@Override
	public void setOnChange(boolean onChange) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends UserInfo> T refreshUserInfo(Long commonId) {
		return (T) this;
	}
}