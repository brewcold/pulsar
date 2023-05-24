package com.hammer.pulsar.dto.article;

// 게시글 목록에서 사용할 페이지네이션 조건을 담는 DTO
public class PaginationCriteria {
    // 마지막으로 전달된 게시글의 번호
    private Integer lastArticleId;
    // 검색 조건으로 선택된 태그의 번호
    private Integer selectedTagId;

    // 기본 생성자
    public PaginationCriteria() {}

    // Getters, Setters
    public Integer getLastArticleId() {
        return lastArticleId;
    }

    public void setLastArticleId(Integer lastArticleId) {
        this.lastArticleId = lastArticleId;
    }

    public Integer getSelectedTagId() {
        return selectedTagId;
    }

    public void setSelectedTagId(Integer selectedTagId) {
        this.selectedTagId = selectedTagId;
    }

    // toString
    @Override
    public String toString() {
        return "PaginationCriteria{" +
                "lastArticleId=" + lastArticleId +
                ", selectedTagId=" + selectedTagId +
                '}';
    }

}
