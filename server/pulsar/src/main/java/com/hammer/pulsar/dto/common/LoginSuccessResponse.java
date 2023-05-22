package com.hammer.pulsar.dto.common;

import com.hammer.pulsar.dto.member.LoginInfo;

// JWT 사용 이전까지 로그인 성공 시 반환할 응답
public class LoginSuccessResponse {
    private LoginInfo loginInfo;
    private String token;

    // 기본 생성자
    public LoginSuccessResponse() {}

    // 생성자
    public LoginSuccessResponse(LoginInfo loginInfo, String token) {
        this.loginInfo = loginInfo;
        this.token = token;
    }

    // Getters, Setters
    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // toString
    @Override
    public String toString() {
        return "LoginSuccessResponse{" +
                "loginInfo=" + loginInfo +
                ", token='" + token + '\'' +
                '}';
    }
}
