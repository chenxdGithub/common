package com.github.chenxdGit.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.chenxdGit.common.config.importSelector.StorageImportSelector;
import org.springframework.context.annotation.Import;

@Target({ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Import(StorageImportSelector.class)
/**
 * 启用文件存储
 * @author 陈晓东
 *
 */
public @interface EnableStorage {
	Class<?> value();
}
