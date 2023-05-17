package com.hammer.pulsar.dto.article;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// 게시글 상세보기를 위한 DTO 클래스
// DAO에서 받은 값들을 서비스 계층에서 조립하여 저장하는 객체
public class Article {
    // 게시글 제목
    private String title;
    // 작성자 번호
    private String writerNo;
    // 작성자 닉네임
    private String writerNickname;
    // 작성자 프로필 이미지
    private String writerProfileImg;
    // 게시글 본문
    private Body body;
    // 게시글 태그 목록
    private List<Tag> tagList;
    // 게시글 작성일
    private String createdAt;
    // 게시글 수정일
    private String modifiedAt;

    // 기본 생성자
    public Article() {}

    // Getters, Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriterNo() {
        return writerNo;
    }

    public void setWriterNo(String writerNo) {
        this.writerNo = writerNo;
    }

    public String getWriterNickname() {
        return writerNickname;
    }

    public void setWriterNickname(String writerNickname) {
        this.writerNickname = writerNickname;
    }

    public String getWriterProfileImg() {
        return writerProfileImg;
    }

    public void setWriterProfileImg(String writerProfileImg) {
        this.writerProfileImg = writerProfileImg;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    // toString
    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", writerNo='" + writerNo + '\'' +
                ", writerNickname='" + writerNickname + '\'' +
                ", writerProfileImg='" + writerProfileImg + '\'' +
                ", body=" + body +
                ", tagList=" + tagList +
                ", createdAt='" + createdAt + '\'' +
                ", modifiedAt='" + modifiedAt + '\'' +
                '}';
    }

}