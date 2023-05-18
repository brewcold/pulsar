package com.hammer.pulsar.dto.member;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// DB에 저장된 회원 정보를 수정하기 위해 사용자가 입력한 값을 담고있는 DTO 클래스
public class MemberModifyForm {
    // 이메일
    private String email;
    // 패스워드
    private String password;
    // 닉네임
    private String nickname;
    // 선택한 태그 목록
    private List<Tag> selectedTag;

    // 기본 생성자
    public MemberModifyForm() {}

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
        return "MemberModifyForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", selectedTag=" + selectedTag +
                '}';
    }

}
