package com.github.chenxdGit.common.config.weChat;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 微信配置属性类
 * @author 陈晓东
 *
 */
@ConfigurationProperties(prefix = "jh.wechat")
@Data
@Configuration
public class WeChatProperties {
 
    private String appid;
    private String secret;
 
}