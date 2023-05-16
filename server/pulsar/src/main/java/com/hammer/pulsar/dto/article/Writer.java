package com.hammer.pulsar.dto.article;

// 게시글 정보에 담을 회원 정보 DTO 클래스
public class Writer {
    // 작성자의 회원번호
    private int writerNo;
    // 작성자 닉네임
    private String writerNickname;
    // 작성자 프로필 이미지
    private String writerProfile;

    // 기본 생성자
    public Writer() {}

    // Getters, Setters
    public int getWriterNo() {
        return writerNo;
    }

    public void setWriterNo(int writerNo) {
        this.writerNo = writerNo;
    }

    public String getWriterNickname() {
        return writerNickname;
    }

    public void setWriterNickname(String writerNickname) {
        this.writerNickname = writerNickname;
    }

    public String getWriterProfile() {
        return writerProfile;
    }

    public void setWriterProfile(String writerProfile) {
        this.writerProfile = writerProfile;
    }

    // toString
    @Override
    public String toString() {
        return "Writer{" +
                "writerNo=" + writerNo +
                ", writerNickname='" + writerNickname + '\'' +
                ", writerProfile='" + writerProfile + '\'' +
                '}';
    }

}
