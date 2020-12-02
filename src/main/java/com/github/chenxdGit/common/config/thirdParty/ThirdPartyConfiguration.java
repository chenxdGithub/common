package com.github.chenxdGit.common.config.thirdParty;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "jh.third-party")
@Configuration
public class ThirdPartyConfiguration  {
	private Map<String,String> secret;
}