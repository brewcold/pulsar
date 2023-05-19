package com.hammer.pulsar.dto.interaction;

// 댓글 테이블에 새로운 댓글을 추가하기 위한 DTO 클래스
public class CommentWriteRequest {
    // 작성자 고유번호
    private int writerId;
    // 게시글 번호
    private int articleId;
    // 댓글 내용
    private String content;

    // 기본 생성자
    public CommentWriteRequest() {}

    // Getters, Setters
    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
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
        return "CommentWriteRequest{" +
                "writerId=" + writerId +
                ", articleId=" + articleId +
                ", content='" + content + '\'' +
                '}';
    }

}
