package com.hammer.pulsar.dto.article;

// 게시글 DB에 새로운 게시글 정보를 추가하기 위한 DTO 클래스
public class ArticleWriteRequest {
    // 게시글 제목
    private String title;
    // 게시글 내용
    private String content;
    // 작성자 고유번호
    private String writerId;

    // 기본 생성자
    public ArticleWriteRequest() {}

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

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    // toString
    @Override
    public String toString() {
        return "ArticleWriteRequest{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writerId='" + writerId + '\'' +
                '}';
    }

}
