package com.github.chenxdGit.common.config.rocket;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
 
/**
 * rocketmq配置属性类
 * @author 陈晓东
 *
 */
@ConfigurationProperties(prefix = "aliyun.rocketmq")
@Data
public class RocketProperties {
 
    private String accessKey;
    private String secretKey;
    private String namesrvAddr;
    private String sendMsgTimeoutMillis;
    private String topic;
    private String group;
    private String tag;
 
}