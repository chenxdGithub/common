package com.github.chenxdGit.common.config.permission;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 微信配置属性类
 * @author 陈晓东
 *
 */
@ConfigurationProperties(prefix = "jh.permission")
@Data
@Configuration
public class CommonUrlProperties {
 
    private Map<String,String> url;
}