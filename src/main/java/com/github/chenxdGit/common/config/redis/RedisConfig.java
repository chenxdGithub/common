package com.github.chenxdGit.common.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
@Configuration
public class RedisConfig {
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public RedisTemplate redisTemplate( RedisConnectionFactory factory,RedisTemplate redisTemplate) {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		//下面代码解决LocalDateTime序列化与反序列化不一致问题
		Jackson2JsonRedisSerializer<Object> j2jrs = new Jackson2JsonRedisSerializer<>(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		// 解决jackson2无法反序列化LocalDateTime的问题
		om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		om.registerModule(new JavaTimeModule());
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
		j2jrs.setObjectMapper(om);
		// 序列化 value 时使用此序列化方法
		redisTemplate.setValueSerializer(j2jrs);
		redisTemplate.setHashValueSerializer(j2jrs);
		redisTemplate.afterPropertiesSet();
	    return redisTemplate;
	}
	    
}
