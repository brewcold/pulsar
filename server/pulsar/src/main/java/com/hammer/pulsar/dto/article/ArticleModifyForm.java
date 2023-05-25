package com.hammer.pulsar.dto.article;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// 게시글 수정을 위해 사용자가 입력한 정보들을 저장하고 있는 DTO 클래스
public class ArticleModifyForm {
    // 게시글 번호
    private int articleId;
    // 게시글 제목
    private String title;
    // 게시글 본문
    private Body body;
    // 선택한 태그 리스트
    private List<Tag> tagList;

    // 기본 생성자
    public ArticleModifyForm() {}

    // Getters, Setters

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    // toString
    @Override
    public String toString() {
        return "ArticleModifyForm{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", body=" + body +
                ", tagList=" + tagList +
                '}';
    }

}
