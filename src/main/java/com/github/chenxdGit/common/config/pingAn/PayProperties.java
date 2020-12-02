package com.github.chenxdGit.common.config.pingAn;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 品安支付配置类
 * @author 陈晓东
 *
 */

@ConfigurationProperties(prefix = "jh.pingan.pay")
@Configuration
@Data
public class PayProperties{
	/**
	 * 支付URL
	 */
	private String payUrl;
	/**
	 * 退款URL
	 */
	private String refundUrl;
	/**
	 * 后台通知URL
	 */
	private String backEndUrl;
	/**
	 * 前台通知URL
	 */
	private String frontEndUrl;
	/**
	 * 异常返回URL
	 */
	private String cancelUrl;
	/**
	 * 商户号
	 */
	private String merchantId;
}