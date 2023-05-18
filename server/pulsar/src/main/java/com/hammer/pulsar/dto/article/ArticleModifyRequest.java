package com.hammer.pulsar.dto.article;

// 게시글 DB에 저장된 게시글 정보를 수정하기 위한 정보를 담은 DTO 클래스
public class ArticleModifyRequest {
    // 게시글 제목
    private String title;
    // 게시글 내용
    private String content;

    // 기본 생성자
    public ArticleModifyRequest() {}

    // Getters, Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // toString
    @Override
    public String toString() {
        return "ArticleModifyRequest{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
