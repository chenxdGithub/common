package com.github.chenxdGit.common.config.importSelector;

import java.util.ArrayList;
import java.util.List;

import com.github.chenxdGit.common.annotation.EnableRocketMQ;
import com.github.chenxdGit.common.config.rocket.RocketConsumerListener;
import com.github.chenxdGit.common.config.rocket.RocketProperties;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import com.github.chenxdGit.common.config.rocket.RocketMQConfig;
import com.github.chenxdGit.common.config.rocket.RocketProducer;

public class RocketMQImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		  AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(
                		EnableRocketMQ.class.getName()));
		  boolean isProduct =(boolean) annotationAttributes.get("isProduct");
		  Class<?> consumerService =(Class<?>) annotationAttributes.get("consumerService");
		  List<String> list=new ArrayList<>();
		  list.add(RocketProperties.class.getName());
		  list.add(RocketMQConfig.class.getName());
		  if(isProduct) {
			  list.add(RocketProducer.class.getName());
		  }
		  if(!consumerService.getName().equals(Object.class.getName())  ) {
			list.add(RocketConsumerListener.class.getName());
			list.add(consumerService.getName());
		  }
		return list.toArray(new String[list.size()]);
	}

}
