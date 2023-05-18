package com.hammer.pulsar.dto.member;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// DB에 저장된 회원 정보를 수정하기 위해 사용자가 입력한 값을 담고있는 DTO 클래스
public class MemberModifyForm {
    // 회원 고유번호
    private int memberId;
    // 패스워드
    private String password;
    // 닉네임
    private String nickname;
    // 선택한 태그 목록
    private List<Tag> selectedTag;

    // 기본 생성자
    public MemberModifyForm() {}

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    // Getters, Setters
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
                "memberId=" + memberId +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", selectedTag=" + selectedTag +
                '}';
    }

}
