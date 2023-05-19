package com.hammer.pulsar.dto.article;

import com.hammer.pulsar.dto.interaction.Comment;

// 내 활동내역 - 내가 쓴 댓글 API에서 사용할 DTO 클래스
// 회원이 작성한 댓글과 해당 게시글의 미리보기를 캡슐화
public class CommentedArticle {
    // 댓글이 달린 게시글의 미리보기
    private ArticlePreview article;
    // 작성한 댓글 정보
    private Comment comment;

    // 기본 생성자
    public CommentedArticle() {
    }

    // Getters, Setters
    public ArticlePreview getArticle() {
        return article;
    }

    public void setArticle(ArticlePreview article) {
        this.article = article;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    // toString
    @Override
    public String toString() {
        return "CommentedArticle{" +
                "article=" + article +
                ", comment=" + comment +
                '}';
    }

}
