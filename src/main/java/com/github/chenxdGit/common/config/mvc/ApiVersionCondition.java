package com.github.chenxdGit.common.config.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.condition.RequestCondition;
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    private int apiVersion;

    public ApiVersionCondition(int apiVersion) {
        this.apiVersion = apiVersion;
    }

    public int getApiVersion() {
        return apiVersion;
    }


    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(apiVersionCondition.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("versionNum");
        if (header!=null) {
            Integer version = Integer.valueOf(header);
            if (version >= this.apiVersion) {
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return apiVersionCondition.getApiVersion() - this.apiVersion;
    }
}