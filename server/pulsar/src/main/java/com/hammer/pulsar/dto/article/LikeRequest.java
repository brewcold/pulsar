package com.hammer.pulsar.dto.article;

// DB에 추천 요청을 하기 위한 DTO 클래스
public class LikeRequest {
    // 추천하려는 회원의 고유번호
    private int memberId;
    // 추천하려는 게시글의 고유번호
    private int articleId;

    // 기본 생성자
    public LikeRequest() {}

    // Getters, Setters
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    // toString
    @Override
    public String toString() {
        return "LikeRequest{" +
                "memberId=" + memberId +
                ", articleId=" + articleId +
                '}';
    }

}
