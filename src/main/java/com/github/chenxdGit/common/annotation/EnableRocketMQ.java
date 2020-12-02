package com.github.chenxdGit.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.chenxdGit.common.config.importSelector.RocketMQImportSelector;
import org.springframework.context.annotation.Import;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RocketMQImportSelector.class)
/**
 * 启用RocketMQ
 * @author 陈晓东
 *
 */
public @interface EnableRocketMQ {
	/**
	 * 是否启用生产者
	 * @return
	 */
	boolean isProduct() default false;
	/**
	 * 消费者类
	 * @return
	 */
	Class<?> consumerService() default Object.class;
}
