package com.github.chenxdGit.common.config.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * jwt配置类
 * @author 陈晓东
 *
 */

@ConfigurationProperties(prefix = "jh.jwt.expirestime")
@Configuration
@Data
public class JwtExpirestime{
		private Integer seconds;
	    private Integer month   = 1 ;
	    private Integer day ;
	    private Integer year;
	    private Integer hour;
	    private Integer minute;
		 
}