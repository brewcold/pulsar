package com.hammer.pulsar.util;

import com.hammer.pulsar.dto.member.LoginInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthUtil {
    // 로그인한 유저의 정보를 저장하는 맵
    private static final Map<UUID, LoginInfo> loginInfoMap = new HashMap<>();

    private AuthUtil() {}

    // 해당 토큰으로 로그인한 유저가 있는지 확인
    public static boolean checkLogin(UUID authToken) {
        return loginInfoMap.containsKey(authToken);
    }

    // 토큰 정보와 일치하는 회원의 정보를 가져오는 메서드
    public static LoginInfo getLoginUserInfo(UUID authToken) {
        return loginInfoMap.get(authToken);
    }

    public static UUID getNewAuthToken() {
        UUID newToken = UUID.randomUUID();

        return newToken;
    }

    public static void removeAuthToken(UUID token) {
        loginInfoMap.remove(token);
    }

}
