package com.hammer.pulsar.dto.member;

import com.hammer.pulsar.dto.common.Tag;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// 회원가입 요청 시 사용자가 입력한 정보를 저장하는 DTO 클래스
public class MemberRegistRequest {

    // 이메일
    private String email;
    // 패스워드
    private String password;
    // 닉네임
    private String nickname;
    // 프로필 이미지
    private MultipartFile profileImg;
    // 선택한 고민 태그
    private List<Tag> selectedTag;

    // 기본 생성자
    public MemberRegistRequest() {}

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

    public MultipartFile getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(MultipartFile profileImg) {
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
        return "MemberRegistRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", profileImg=" + profileImg +
                ", selectedTag=" + selectedTag +
                '}';
    }

}
