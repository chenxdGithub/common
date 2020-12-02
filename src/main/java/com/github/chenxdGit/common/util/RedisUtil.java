package com.github.chenxdGit.common.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.github.chenxdGit.common.permission.PermissionDto;
import org.springframework.data.redis.core.RedisTemplate;

import com.github.chenxdGit.common.sysInterface.UserInfo;

/**
 * redis工具类
 * @author 陈晓东
 * @param <H>
 *
 */
public class RedisUtil  {
	private static final String sessionKey ="session:commonId:";
	
	/**
	 * 获取redis实例
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static RedisTemplate<String, ?>  getRedisTemplate() {
		return ApplicationContextAwareHelper.getBeanByName("redisTemplate",RedisTemplate.class);
	}
 
	@SuppressWarnings({ "unchecked"})
	public static <H, HV> HV   get(H key, Object hashKey){
		return (HV) getRedisTemplate().opsForHash().get(String.valueOf(key),String.valueOf(hashKey));
	}
	
	
	public static <H> List<Object>   values(H key){
		List<Object> values = getRedisTemplate().opsForHash().values(String.valueOf(key));
		return  values;
	}
	
	
	@SuppressWarnings({ "unchecked"})
	public static <HK, HV> Map<HK, HV>  entries(String key){
		return  (Map<HK, HV>) getRedisTemplate().opsForHash().entries(key);
	}
	
	
	
	
	public static Boolean deleteAll(String key){
		return getRedisTemplate().delete(key);
	}
	
	/**
	 * 添加hashMap的一个值
	 * @param <HV>
	 * @param <HK>
	 * @param <H>
	 * @param key redis的key 
	 * @param hashKey  hashMap的key 
	 * @param value hashMap的value 
	 */
	public static <HV, HK, H> void put(H key, HK hashKey, HV value){
		getRedisTemplate().opsForHash().put(String.valueOf(key),String.valueOf(hashKey),value);
	}
	
	/**
	 * 添加一个hashMap
	 * @param <HV>
	 * @param <HK>
	 * @param <H>
	 * @param key  redis的key 
	 * @param m value
	 */
	public static <HV, HK, H> void putAll(H key, Map<? extends HK, ? extends HV> m){
		getRedisTemplate().opsForHash().putAll(String.valueOf(key),m);
	}
	
	/**
	 * 根据redis的key和 hashkey  删除多个值
	 * @param <H>
	 * @param key
	 * @param hashKeys
	 */
	public static  <H> void delete (H key, Object... hashKeys){
		getRedisTemplate().opsForHash().delete(String.valueOf(key), hashKeys);
	}
	/**
	 * 根据key设置过期时间
	 * @param <K>
	 * @param key redis的key
	 * @param timeout 延时
	 * @param unit 时间单位
	 */
	public static  <K> void expire(K key, final long timeout, final TimeUnit unit) {
		getRedisTemplate().expire(String.valueOf(key),timeout,unit);
	}
	
	
	
	/**
	 * 添加用户信息
	 * @param user
	 */
	public static void putUserInfo(UserInfo user,long timeout, final TimeUnit unit) {
		put(sessionKey+user.getCommonId(),user.getClass().getName(),user);
		expire(sessionKey+user.getCommonId(),30,TimeUnit.DAYS);
	}
	
	
	
	/**
	 * 添加用户信息
	 * @param user
	 */
	public static void putUserInfo(UserInfo user) {
		put(sessionKey+user.getCommonId(),user.getClass().getName(),user);
		expire(sessionKey+user.getCommonId(),30,TimeUnit.DAYS);
	}
	
	/**
	 *刷新用户信息
	 * @param <T>
	 * @param user
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public static <T extends UserInfo> T refreshUserInfo(Class<T> user,Long commonId) throws InstantiationException, IllegalAccessException {
			UserInfo refreshUserInfo = user.newInstance().refreshUserInfo(commonId);
			putUserInfo(refreshUserInfo);
			return (T) refreshUserInfo;
	}
	
	/**
	 *获取用户信息
	 * @param <T>
	 * @param user
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public static <T extends UserInfo > T getUserInfo (Class<T> user,Long commonId) throws InstantiationException, IllegalAccessException {
		T t = (T) get(sessionKey+String.valueOf(commonId),user.getName());
		if(t==null) {
			return refreshUserInfo(user,commonId);
		}
		return t;
	}
	
	public static <T extends UserInfo > PermissionDto getPermission (T user) {
		PermissionDto t = (PermissionDto) get(sessionKey+String.valueOf(user.getCommonId()),user.getClass()+".permission");
		return t;
	}
	
	public static <T extends UserInfo > void putPermission (T user,PermissionDto permissionDto) {
		put(sessionKey+String.valueOf(user.getCommonId()),user.getClass()+".permission",permissionDto);
	}
	
	public static <T extends UserInfo > void deletePermission (T user) {
		delete(sessionKey+String.valueOf(user.getCommonId()),user.getClass()+".permission");
	}
	

	/**
	 *获取用户信息不刷新缓存
	 * @param <T>
	 * @param user
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public static <T extends UserInfo > T getUserInfoNotRefresh (Class<T> user,Long commonId) throws InstantiationException, IllegalAccessException {
		T t = (T) get(sessionKey+String.valueOf(commonId),user.getName());
		return t;
	}
}
