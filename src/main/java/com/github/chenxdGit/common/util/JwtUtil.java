package com.github.chenxdGit.common.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.chenxdGit.common.config.jwt.JwtExpirestime;
public class JwtUtil { 
	
    private   static final  String tokenSecret = "jwt";
    
    
    
    public static String getTokenSecret() {
		return tokenSecret;
	}
    
    /**
     * 生成签名，15分钟过期
    * @return
     */
    public  static String sign(Long value) {
        try {
        	JwtExpirestime expirestime = ApplicationContextAwareHelper.getBeanByType(JwtExpirestime.class);
        	 Date now = new Date();
        	if(expirestime.getDay()!=null&&expirestime.getDay()!=0) {
        		now = DateUtils.addDays(now,expirestime.getDay());
        	}
        	if(expirestime.getYear()!=null&&expirestime.getYear()!=0) {
        		now = DateUtils.addYears(now,expirestime.getYear());
        	}
        	if(expirestime.getMonth()!=null&&expirestime.getMonth()!=0) {
        		now = DateUtils.addMonths(now,expirestime.getMonth());
        	}
        	if(expirestime.getSeconds()!=null&&expirestime.getSeconds()!=0) {
        		now = DateUtils.addMilliseconds(now,expirestime.getSeconds());
        	}
        	if(expirestime.getHour()!=null&&expirestime.getHour()!=0) {
        		now = DateUtils.addHours(now,expirestime.getHour());
        	}
        	if(expirestime.getMinute()!=null&&expirestime.getMinute()!=0) {
        		now = DateUtils.addMinutes(now,expirestime.getMinute());
        	}
        	
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            return JWT.create()
                    .withHeader(header).withClaim("commonId", value)
                    .withExpiresAt(now)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   
    /**
     * 判断token是否有效
     * @param token
     * @return
     */
    public static  boolean isTimeOut(String token){
            DecodedJWT jwt =getJwt(token);
			return jwt.getExpiresAt().before(new Date());
    }
    
    
    /**
     * 根据token字符串生成token对象
     * @param token
     * @return
     */
    public static  DecodedJWT getJwt(String token){
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT verify = verifier.verify(token);
			return  verify;
    }
    
    /**
     * 根据token字符串生成token对象
     * @param <T>
     * @param token
     * @return
     */
    public static  Long getClaim(String jwt){
    		DecodedJWT decodedJWT = getJwt(jwt);
			return  decodedJWT.getClaim("commonId").as(Long.class);
    }
}