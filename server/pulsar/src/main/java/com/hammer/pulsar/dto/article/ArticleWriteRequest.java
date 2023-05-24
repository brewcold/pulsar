package com.hammer.pulsar.dto.article;

// 게시글 DB에 새로운 게시글 정보를 추가하기 위한 DTO 클래스
public class ArticleWriteRequest {
    // 게시글의 고유번호
    private int articleId;
    // 게시글 제목
    private String title;
    // 게시글 내용
    private String content;
    // 작성자 고유번호
    private int writerId;
    // 추가한 루틴의 고유번호
    private Integer routineId;

    // 기본 생성자
    public ArticleWriteRequest() {}

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Integer routineId) {
        this.routineId = routineId;
    }

    // toString
    @Override
    public String toString() {
        return "ArticleWriteRequest{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writerId=" + writerId +
                ", routineId=" + routineId +
                '}';
    }

}
