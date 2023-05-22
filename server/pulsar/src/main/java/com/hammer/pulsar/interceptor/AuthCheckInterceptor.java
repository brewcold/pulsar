package com.hammer.pulsar.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthCheckInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(AuthCheckInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("userNo = {}, sessionId = {}", request.getSession().getAttribute("loginInfo")
                ,request.getSession().getId());

        return true;
    }
}
