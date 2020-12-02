package com.github.chenxdGit.common.config.rocket;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;

/**
 * MQ消费者消费接口
 * @author 陈晓东
 *
 */
public interface RocketConsumerService {
 
	public Action consume(Message message, ConsumeContext context);
}