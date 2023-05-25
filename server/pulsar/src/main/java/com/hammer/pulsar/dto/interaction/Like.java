package com.hammer.pulsar.dto.interaction;

// 게시글에 대한 회원의 추천 여부, 총 추천수를 저장할 DTO 클래스
public class Like {
    // 현재 사용자가 추천을 눌렀는지 여부
    private boolean liked;
    // 게시글의 총 추천수
    private int likes;

    // 기본 생성자
    public Like() {}

    // Getters, Setters
    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    // toString
    @Override
    public String toString() {
        return "Like{" +
                "liked=" + liked +
                ", likes=" + likes +
                '}';
    }

}
