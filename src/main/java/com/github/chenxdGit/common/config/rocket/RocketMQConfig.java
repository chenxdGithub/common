package com.github.chenxdGit.common.config.rocket;



import org.springframework.context.annotation.Bean;

import com.aliyun.openservices.ons.api.PropertyKeyConst;
 
/**
 * rocketmq配置类
 * @author 陈晓东
 *
 */
public class RocketMQConfig {
	
    
 
    /**
     * 初始化参数
     * @return
     */
    @Bean
    public RocketCustomerProperties getProperties(RocketProperties rocketProperties) {
        // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
    	RocketCustomerProperties rocketCustomerProperties = new RocketCustomerProperties();
    	rocketCustomerProperties.put(PropertyKeyConst.AccessKey,rocketProperties.getAccessKey() );
        // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
    	rocketCustomerProperties.put(PropertyKeyConst.SecretKey, rocketProperties.getSecretKey());
        //设置发送超时时间，单位毫秒
    	rocketCustomerProperties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, rocketProperties.getSendMsgTimeoutMillis());
        // 设置 TCP 接入域名，进入控制台的实例管理页面的“获取接入点信息”区域查看
    	rocketCustomerProperties.put(PropertyKeyConst.NAMESRV_ADDR,rocketProperties.getNamesrvAddr());
        return rocketCustomerProperties;
    }
    
}