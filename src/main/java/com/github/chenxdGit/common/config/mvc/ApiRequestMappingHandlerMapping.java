package com.github.chenxdGit.common.config.mvc;

import java.lang.reflect.Method;

import com.github.chenxdGit.common.annotation.ApiVersion;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


/**
 * 版本号匹配拦截器
 * @author Chenxd
 */
public class ApiRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
 
	  @Override
	    protected RequestCondition<ApiVersionCondition> getCustomTypeCondition(Class<?> handlerType) {
	        ApiVersion apiVersion = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
	        return this.createCondition(apiVersion);
	    }

	    @Override
	    protected RequestCondition<ApiVersionCondition> getCustomMethodCondition(Method method) {
	        ApiVersion apiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);
	        return this.createCondition(apiVersion);
	    }

	    private RequestCondition<ApiVersionCondition> createCondition(ApiVersion apiVersion){
	       return apiVersion == null ? null : new ApiVersionCondition(apiVersion.value());
	    }
 
 
 
}