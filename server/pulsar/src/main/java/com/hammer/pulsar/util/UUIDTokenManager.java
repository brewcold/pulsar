package com.hammer.pulsar.util;

import com.hammer.pulsar.dto.member.LoginInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// JWT를 적용하기 전 임시로 사용할 토큰 관리 클래스
public class UUIDTokenManager {
    // 로그인한 유저의 정보를 저장하는 맵
    private static final Map<String, LoginInfo> loginInfoMap = new HashMap<>();

    private UUIDTokenManager() {}

    // 해당 토큰으로 로그인한 유저가 있는지 확인
    public static boolean checkLogin(String authToken) {
        return loginInfoMap.containsKey(authToken);
    }

    // 토큰 정보와 일치하는 회원의 정보를 가져오는 메서드
    public static LoginInfo getLoginUserInfo(String authToken) {
        return loginInfoMap.get(authToken);
    }

    public static String getNewAuthToken(LoginInfo info) {
        String newToken = UUID.randomUUID().toString();

        loginInfoMap.put(newToken, info);
        return newToken;
    }

    public static void removeAuthToken(String authToken) {
        loginInfoMap.remove(authToken);
    }

}
