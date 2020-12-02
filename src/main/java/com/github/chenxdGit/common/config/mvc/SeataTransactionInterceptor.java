package com.github.chenxdGit.common.config.mvc;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.github.chenxdGit.common.util.StringUtil;

import io.seata.core.context.RootContext;
/**
 * seata事务id拦截器
 * @author 陈晓东
 *
 */
@Component
public class SeataTransactionInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
    	String xid = RootContext.getXID();
        if(StringUtil.isNotNull(xid)) {
        	HttpHeaders headers = httpRequest.getHeaders();
        	headers.add(RootContext.KEY_XID, xid);
        }
        return clientHttpRequestExecution.execute(httpRequest, body);
    }
}