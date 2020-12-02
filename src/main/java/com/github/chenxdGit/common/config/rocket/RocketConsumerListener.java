package com.github.chenxdGit.common.config.rocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.PropertyValueConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RocketConsumerListener implements CommandLineRunner {
 
	@Autowired
	RocketCustomerProperties properties;
	@Autowired
	RocketProperties rocketProperties;
	@Autowired
	RocketConsumerService rocketConsumerService;
	
 
    @Override
    public void run(String... args) throws Exception {
    	properties.put(PropertyKeyConst.GROUP_ID, rocketProperties.getGroup());
        // 集群订阅方式设置（不设置的情况下，默认为集群订阅方式）
    	properties.put(PropertyKeyConst.MessageModel, PropertyValueConst.CLUSTERING);
 
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe(rocketProperties.getTopic(), rocketProperties.getTag(), new MessageListener() {
            @Override
            public Action consume(Message message, ConsumeContext context) {
                log.debug(rocketProperties.getTag() + " Receive: " + new String(message.getBody()));
                return rocketConsumerService.consume(message, context);
            }
        });
        consumer.start();
 
    }
}