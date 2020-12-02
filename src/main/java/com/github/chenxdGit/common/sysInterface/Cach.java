package com.github.chenxdGit.common.sysInterface;

import java.util.List;
import java.util.Map;

import com.github.chenxdGit.common.dto.CachDto;

/**
 * 缓存接口
 * @author 陈晓东
 *
 */
public interface Cach  {
	
	public Map<Integer, List<CachDto>> init();
	
	public Map<Integer, List<CachDto>>  getAll();
	
	public List<CachDto> getByType();
}
