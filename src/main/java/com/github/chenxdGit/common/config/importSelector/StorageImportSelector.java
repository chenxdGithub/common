package com.github.chenxdGit.common.config.importSelector;

import com.github.chenxdGit.common.annotation.EnableStorage;
import com.github.chenxdGit.common.config.storage.StorageService;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class StorageImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		  AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(
                		EnableStorage.class.getName()));
		Class<?> object =(Class<?>) annotationAttributes.get("value");
		return new String[]{StorageService.class.getName(),object.getName()};
	}

}
