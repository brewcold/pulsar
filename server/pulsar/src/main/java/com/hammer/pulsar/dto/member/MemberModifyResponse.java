package com.hammer.pulsar.dto.member;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// 회원정보 수정 후 클라이언트에서 갱신해야하는 정보들을 담은 DTO 클래스
public class MemberModifyResponse {
    // 정보수정 후의 닉네임
    private String nickname;
    // 정보수정 후의 태그목록
    private List<Tag> selectedTag;

    // 기본 생성자
    public MemberModifyResponse() {}

    // Getters, Setters
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
        return "MemberModifyResponse{" +
                "nickname='" + nickname + '\'' +
                ", selectedTag=" + selectedTag +
                '}';
    }

}
