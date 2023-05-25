package com.hammer.pulsar.dto.article;

import com.hammer.pulsar.dto.common.Tag;
import com.hammer.pulsar.dto.common.Writer;

import java.util.List;

// 게시글 상세보기를 위한 DTO 클래스
// DAO에서 받은 값들을 서비스 계층에서 조립하여 저장하는 객체
public class Article {
    // 게시글 번호
    private int articleNo;
    // 게시글 제목
    private String title;
    // 작성자 정보
    private Writer writerInfo;
    // 게시글 본문
    private Body body;
    // 게시글 태그 목록
    private List<Tag> tagList;
    // 게시글 작성일
    private String createdAt;
    // 게시글 수정일
    private String modifiedAt;
    // 게시글 조회수
    private int viewCnt;

    // 기본 생성자
    public Article() {}

    // Getters, Setters
    public int getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(int articleNo) {
        this.articleNo = articleNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Writer getWriterInfo() {
        return writerInfo;
    }

    public void setWriterInfo(Writer writerInfo) {
        this.writerInfo = writerInfo;
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

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    // toString
    @Override
    public String toString() {
        return "Article{" +
                "articleNo=" + articleNo +
                ", title='" + title + '\'' +
                ", writerInfo=" + writerInfo +
                ", body=" + body +
                ", tagList=" + tagList +
                ", createdAt='" + createdAt + '\'' +
                ", modifiedAt='" + modifiedAt + '\'' +
                ", viewCnt='" + viewCnt + '\'' +
                '}';
    }

}
