package com.hammer.pulsar.interceptor;

import com.hammer.pulsar.exception.UnauthorizedException;
import com.hammer.pulsar.util.UUIDTokenManager;
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
        logger.info("Authorization = {}", request.getHeader("Authorization"));

        String authToken = request.getHeader("Authorization");

        // 로그인이 되어있는 유저인지 체크
//        if(!UUIDTokenManager.checkLogin(authToken)) throw new UnauthorizedException();

        return true;
    }
}
