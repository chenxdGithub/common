package com.github.chenxdGit.common.config.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * CORS 处理
 *
 * @author piumnl
 * @since on 2018-01-11.
 */
@Component
public class CORSInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) {

        response.setHeader("Access-Control-Max-Age", "36000000");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", getAllowMethods(request));
        response.setHeader("Access-Control-Allow-Headers", getAllowHeaders(request));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return true;
    }

    private String getAllowHeaders(HttpServletRequest request) {
        return "x-requested-with,Authorization," + request.getHeader("Access-Control-Request-Headers");
    }

    private String getAllowMethods(HttpServletRequest request) {
        return request.getMethod() + "," + request.getHeader("Access-Control-Request-Method");
    }
}
