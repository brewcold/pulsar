package com.hammer.pulsar.dto.member;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// 로그인 성공 시 클라이언트에 보내줄 로그인 정보를 담은 DTO 클래스
public class MemberProfile {
    private int memberNo;
    private String email;
    private String nickname;
    private String profileImg;
    private List<Tag> selectedTag;

    // 기본 생성자
    public MemberProfile() {}

    // Getters, Setters
    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "LoginInfo{" +
                "memberNo=" + memberNo +
                ", nickname='" + nickname + '\'' +
                ", profileImg='" + profileImg + '\'' +
                ", selectedTag=" + selectedTag +
                '}';
    }

}
