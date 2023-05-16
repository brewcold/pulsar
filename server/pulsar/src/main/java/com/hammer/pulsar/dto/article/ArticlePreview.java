package com.hammer.pulsar.dto.article;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// 게시글 목록에서 노출될 정보를 저장하는 DTO 클래스
// DAO에서 받은 값들을 서비스 계층에서 조립하여 저장하는 객체
public class ArticlePreview {
    // 게시글 번호
    private int articleNo;
    // 작성자 닉네임
    private String writerNickname;
    // 게시글 제목
    private String title;
    // 게시글 작성일
    private String createdAt;
    // 게시글 조회수
    private int viewCnt;
    // 게시글 추천수
    private int recommendCnt;
    // 게시글 태그목록
    private List<Tag> articleTag;

    public ArticlePreview() {}

    // Getters, Setters
    public int getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(int articleNo) {
        this.articleNo = articleNo;
    }

    public String getWriterNickname() {
        return writerNickname;
    }

    public void setWriterNickname(String writerNickname) {
        this.writerNickname = writerNickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public int getRecommendCnt() {
        return recommendCnt;
    }

    public void setRecommendCnt(int recommendCnt) {
        this.recommendCnt = recommendCnt;
    }

    public List<Tag> getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(List<Tag> articleTag) {
        this.articleTag = articleTag;
    }

    // toString
    @Override
    public String toString() {
        return "ArticlePreview{" +
                "articleNo=" + articleNo +
                ", writerNickname='" + writerNickname + '\'' +
                ", title='" + title + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", viewCnt=" + viewCnt +
                ", recommendCnt=" + recommendCnt +
                ", articleTag=" + articleTag +
                '}';
    }

}
