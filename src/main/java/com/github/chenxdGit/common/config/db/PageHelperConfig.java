package com.github.chenxdGit.common.config.db;


import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper PageHelper(){
    	Properties properties = new Properties();
        PageHelper page= new PageHelper();
        page.setProperties(properties);
        return page;
    }
}