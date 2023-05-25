package com.hammer.pulsar.dto.member;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// 회원정보를 보여주기 위한 DTO 클래스
public class Member {
    // 회원 고유번호
    private int memberId;
    // 이메일
    private String email;
    // 패스워드
    private String password;
    // 닉네임
    private String nickname;
    // 프로필 이미지 리소스 경로
    private String profileImg;
    // 선택한 고민 태그 리스트
    private List<Tag> selectedTag;

    // 기본 생성자
    public Member() {}

    // Getters, Setters
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

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

    public List<Tag> getSelectedTag() {
        return selectedTag;
    }

    public void setSelectedTag(List<Tag> selectedTag) {
        this.selectedTag = selectedTag;
    }

    // toString
    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", profileImg='" + profileImg + '\'' +
                ", selectedTag=" + selectedTag +
                '}';
    }

}
