package com.github.chenxdGit.common.dto;

import lombok.Data;

/**
 * 订单发货通知Dto
 */
@Data
public class DPODto {

    private String warn;
	
    private String openId;

    private String goodName;

    private String goodNum;
    
    private String goodPrice;

    private String phone;

    private String remark;

    private String url;
}