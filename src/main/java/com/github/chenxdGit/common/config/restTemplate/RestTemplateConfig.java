package com.github.chenxdGit.common.config.restTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.github.chenxdGit.common.config.mvc.SeataTransactionInterceptor;

@Configuration
public class RestTemplateConfig {

	@Bean 
    public RestTemplate restTemplate(){
      RestTemplate restTemplate = new RestTemplate();
      MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter= new MappingJackson2HttpMessageConverter();
      List<MediaType> mediaTypes = new ArrayList<>();
      mediaTypes.add(MediaType.TEXT_PLAIN);
      mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypes);
      restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        return restTemplate;
    }
	
	@Bean
	@LoadBalanced
	public LoadBalancedRestTemplate grestLoadBalancedRestTemplate(SeataTransactionInterceptor seataTransactionInterceptor){
	        LoadBalancedRestTemplate loadBalancedRestTemplate = new LoadBalancedRestTemplate();
	        loadBalancedRestTemplate.setInterceptors(Collections.singletonList(seataTransactionInterceptor));
			return loadBalancedRestTemplate;
	}
	
	
}
