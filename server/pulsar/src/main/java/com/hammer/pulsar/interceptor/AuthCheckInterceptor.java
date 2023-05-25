package com.hammer.pulsar.interceptor;

import com.hammer.pulsar.exception.UnauthorizedException;
import com.hammer.pulsar.util.MemoryAuthManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthCheckInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(AuthCheckInterceptor.class);

    // 회원이 접근할 수 없는 경로
    // {로그인}
    private final String[] notPermittedToMember = {"/member/login"};

    // 비회원이 GET 요청으로 접근할 수 있는 경로
    // {게시글 목록보기, 인터랙션 결과(추천, 댓글 등등) 보기}
    private final String[] permittedGetToStranger = {"/community"};
    private final String[] permittedGetToStrangerRegex = {"^/community/[^/]+/active/[^/]+$"};
   // 비회원이 POST 요청으로 접근할 수 있는 경로
    // {로그인}
    private final String[] permittedPostToStranger = {"/member/login"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int loginMember = MemoryAuthManager.getLoginMember();

        String httpMethod = request.getMethod();
        String requestUri = request.getRequestURI();

        logger.info("method = {}, uri = {}", httpMethod, requestUri);
//
//        // 회원이 접근할 수 없는 경로로 접근했을 경우 차단
//        if(loginMember != 0 && !isPermittedRequestToMember(requestUri)) {
//            throw new UnauthorizedException("잘못된 요청입니다.");
//        }
//
//        // 비회원이 접근할 수 없는 경로로 접근했을 경우 차단
//        if(loginMember == 0 && !isPermittedRequestToStranger(httpMethod, requestUri)) {
//            throw new UnauthorizedException("로그인이 필요한 기능입니다.");
//        }

        // 그 외의 경우에는 허용
        return true;
    }

    // 회원이 접근할 수 있는 경로이면 true를 반환하는 메서드
    private boolean isPermittedRequestToMember(String uri) {
        return isPermittedUriToMember(uri);
    }

    // 접근 경로가 회원의 접근 불가 경로를 저장해둔 배열에 있다면 false를 반환하는 메서드
    private boolean isPermittedUriToMember(String uri) {
        for(String notPermitted : notPermittedToMember) {
            if(uri.equals(notPermitted)) return false;
        }

        return true;
    }

    // 비회원이 접근할 수 있는 경로이면 true를 반환하는 메서드
    private boolean isPermittedRequestToStranger(String method, String uri) {
        return isPermittedUriToStranger(method, uri) || isPermittedUriToStrangerRegex(method, uri);
    }

    // 접근 경로가 비회원의 접근 가능한 경로를 저장해둔 배열에 있다면 true를 반환하는 메서드
    private boolean isPermittedUriToStranger(String method, String uri) {
        String[] uriList = null;

        if(method.equals("GET")) uriList = permittedGetToStranger;
        else if(method.equals("POST")) uriList = permittedPostToStranger;
        else uriList = new String[0];

        for(String permitted : uriList) {
            if(uri.equals(permitted)) return true;
        }
        return false;
    }

    // 접근 경로가 비회원의 접근 가능한 경로를 저장해둔 배열에 있다면 true를 반환하는 메서드
    private boolean isPermittedUriToStrangerRegex(String method, String uri) {
        String[] uriRegexList = null;

        if(method.equals("GET")) uriRegexList = permittedGetToStrangerRegex;
        else uriRegexList = new String[0];

        for(String permitted : uriRegexList) {
            if(uri.matches(permitted)) return true;
        }
        return false;
    }

}
