package com.hammer.pulsar.dto.interaction;

import com.hammer.pulsar.dto.common.Writer;

// 게시글에 작성된 댓글 정보를 저장할 DTO 클래스
public class Comment {
    // 댓글 번호
    private int commentNo;
    // 게시글 번호
    private int articleNo;
    // 작성자 정보
    private Writer writerInfo;
    // 댓글 내용
    private String content;
    // 댓글 작성일
    private String createdAt;

    // 기본 생성자
    public Comment() {}

    // Getters, Setters
    public int getCommentNo() {
        return commentNo;
    }

    public void setCommentNo(int commentNo) {
        this.commentNo = commentNo;
    }

    public int getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(int articleNo) {
        this.articleNo = articleNo;
    }

    public Writer getWriterInfo() {
        return writerInfo;
    }

    public void setWriterInfo(Writer writerInfo) {
        this.writerInfo = writerInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    // toString
    @Override
    public String toString() {
        return "Comment{" +
                "commentNo=" + commentNo +
                ", articleNo=" + articleNo +
                ", writerInfo=" + writerInfo +
                ", content='" + content + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

}
