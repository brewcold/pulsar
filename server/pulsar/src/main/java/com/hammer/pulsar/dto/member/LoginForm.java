package com.hammer.pulsar.dto.member;

// 로그인 요청에 필요한 정보를 담은 DTO 클래스
public class LoginForm {
    private String email;
    private String password;

    // 기본 생성자
    public LoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters, Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString
    @Override
    public String toString() {
        return "LoginRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
