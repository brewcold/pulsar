package com.hammer.pulsar.dto.common;

import java.util.List;

// ConcernDao를 통해 회원의 고민 정보를 저장하기 위해 사용하는 DTO 클래스
public class ConcernUpdateRequest {
    // 회원번호
    private int memberId;
    // 고민 태그 목록
    private List<Integer> concernTagsId;

    // 기본 생성자
    public ConcernUpdateRequest() {}

    // 회원번호와 고민 태그 목록을 인자로 받는 생성자
    public ConcernUpdateRequest(int memberId, List<Integer> concernTagsId) {
        this.memberId = memberId;
        this.concernTagsId = concernTagsId;
    }

    // Getters, Setters
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public List<Integer> getConcernTagsId() {
        return concernTagsId;
    }

    public void setConcernTags(List<Integer> concernTagsId) {
        this.concernTagsId = concernTagsId;
    }

    // toString
    @Override
    public String toString() {
        return "ConcernUpdateRequest{" +
                "memberId=" + memberId +
                ", concernTagsId=" + concernTagsId +
                '}';
    }

}
