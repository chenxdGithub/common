package com.github.chenxdGit.common.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class MapUtil  	{
	
	public static Map dtoToMap(Object dto) {
		return JSONObject.parseObject(JSONObject.toJSONString(dto), Map.class);
	}
	public static <T> T mapToDto(Map map,Class<T> dto) {
		return JSONObject.parseObject(JSONObject.toJSONString(map), dto);
	}
	
	public static Map<String,Object>  mapKeyToLine(Map<String,Object> map) {
			LinkedHashMap<String,Object> camelcaseExtMap = new LinkedHashMap<String,Object>();
	        for (Map.Entry<String, Object> entry : map.entrySet()) {
	            camelcaseExtMap.put(StringUtil.toLine(entry.getKey()), entry.getValue());
	        }
			return camelcaseExtMap;
	}
}
