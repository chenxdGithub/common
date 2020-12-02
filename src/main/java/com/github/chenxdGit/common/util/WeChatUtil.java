package com.github.chenxdGit.common.util;

import com.github.chenxdGit.common.config.weChat.WeChatProperties;
import com.github.chenxdGit.common.dto.TokenDto;
import com.github.chenxdGit.common.enums.RedisKey;
import com.github.chenxdGit.common.exception.UnGetTokenException;
import com.github.chenxdGit.common.enums.WeChatKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeChatUtil {

    public static TokenDto refreshToken() {
        WeChatProperties weChatProperties = ApplicationContextAwareHelper.getBeanByType(WeChatProperties.class);
        RestTemplate restTemplate = ApplicationContextAwareHelper.getBeanByName("restTemplate",RestTemplate.class);
        Map object = restTemplate.getForObject(WeChatKey.getOATokenUrl.value(), Map.class,weChatProperties.getAppid(),weChatProperties.getSecret());
        if(object.get("errcode")!=null){
            log.error("获取通用Token失败！"+object.toString(),object);
            throw new UnGetTokenException("未获取到token");
        }
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken((String)object.get("access_token"));
        return tokenDto;
    }
    public static TokenDto  getAccessToken() {
        TokenDto tokenDto = (TokenDto)RedisUtil.get(RedisKey.officialAccountsToken.value(),TokenDto.class.getName());
        if(tokenDto==null) {
            tokenDto = refreshToken();
            RedisUtil.put(RedisKey.officialAccountsToken.value(),TokenDto.class.getName(),tokenDto);
            RedisUtil.expire(RedisKey.officialAccountsToken.value(),7000,TimeUnit.SECONDS);
        }
        return tokenDto;
    }
}

