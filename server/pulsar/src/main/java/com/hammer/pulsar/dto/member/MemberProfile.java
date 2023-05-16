package com.hammer.pulsar.dto.member;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// 회원의 프로필 정보를 담고 있는 DTO 클래스
public class MemberProfile {
    // 회원의 닉네임
    private String nickname;
    // 회원의 프로필 이미지
    private String profileImg;
    // 회원의 고민 태그 목록
    private List<Tag> selectedTag;

    // 기본 생성자
    public MemberProfile() {}

    // Getters, Setters
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
        return "MemberProfile{" +
                "nickname='" + nickname + '\'' +
                ", profileImg='" + profileImg + '\'' +
                ", selectedTag=" + selectedTag +
                '}';
    }

}
