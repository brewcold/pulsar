package com.hammer.pulsar.dto.article;

import java.util.List;

public class ArticleTagUpdateRequest {
    // 회원번호
    private int articleId;
    // 고민 태그 목록
    private List<Integer> ArticleTagsId;

    // 기본 생성자
    public ArticleTagUpdateRequest() {}

    // 게시글 번호와 고민 태그 목록을 인자로 받는 생성자
    public ArticleTagUpdateRequest(int articleId, List<Integer> articleTagsId) {
        this.articleId = articleId;
        ArticleTagsId = articleTagsId;
    }

    // Getters, Setters
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public List<Integer> getArticleTagsId() {
        return ArticleTagsId;
    }

    public void setArticleTagsId(List<Integer> articleTagsId) {
        ArticleTagsId = articleTagsId;
    }

    // toString
    @Override
    public String toString() {
        return "ArticleTagUpdateRequest{" +
                "articleId=" + articleId +
                ", ArticleTagsId=" + ArticleTagsId +
                '}';
    }

}
