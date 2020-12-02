package com.github.chenxdGit.common.config.rocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;

public class RocketProducer {
 
	@Autowired
	RocketProperties rocketProperties;
 

    /**
     * 初始化生产者
     *
     * @return
     */
    @Bean(destroyMethod="shutdown")
    public Producer getProducer(RocketCustomerProperties Properties) {
        Producer producer = ONSFactory.createProducer(Properties);
        producer.start();
        return producer;
    }
}