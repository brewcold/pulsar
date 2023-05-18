package com.hammer.pulsar.dto.member;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// DB에 저장된 회원정보를 수정하기 위한 DTO 클래스
public class MemberModifyRequest {

    // 이메일
    private String email;
    // 패스워드
    private String password;
    // 닉네임
    private String nickname;
    // DB에 저장한 프로필 이미지 경로
    private String profileImg;

    // 기본 생성자
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    // toString
    @Override
    public String toString() {
        return "MemberModifyRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", profileImg='" + profileImg + '\'' +
                '}';
    }

}
