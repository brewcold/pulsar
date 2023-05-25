package com.hammer.pulsar.dto.common;

import com.hammer.pulsar.dto.member.MemberProfile;

// JWT 사용 이전까지 로그인 성공 시 반환할 응답
public class LoginSuccessResponse {
    private MemberProfile memberProfile;
    private String token;

    // 기본 생성자
    public LoginSuccessResponse() {}

    // 생성자
    public LoginSuccessResponse(MemberProfile memberProfile, String token) {
        this.memberProfile = memberProfile;
        this.token = token;
    }

    // Getters, Setters
    public MemberProfile getLoginInfo() {
        return memberProfile;
    }

    public void setLoginInfo(MemberProfile memberProfile) {
        this.memberProfile = memberProfile;
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
                "loginInfo=" + memberProfile +
                ", token='" + token + '\'' +
                '}';
    }
}
