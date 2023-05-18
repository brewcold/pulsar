package com.hammer.pulsar.dto.common;

import java.util.List;

// ConcernDao를 통해 회원의 고민 정보를 저장하기 위해 사용하는 DTO 클래스
public class ConcernRegistRequest {
    // 회원번호
    private int memberId;
    // 고민 태그 목록
    private List<Tag> concernTags;

    // 기본 생성자
    public ConcernRegistRequest() {}

    // 회원번호와 고민 태그 목록을 인자로 받는 생성자
    public ConcernRegistRequest(int memberId, List<Tag> concernTags) {
        this.memberId = memberId;
        this.concernTags = concernTags;
    }

    // Getters, Setters
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public List<Tag> getConcernTags() {
        return concernTags;
    }

    public void setConcernTags(List<Tag> concernTags) {
        this.concernTags = concernTags;
    }

    // toString
    @Override
    public String toString() {
        return "ConcernRegistRequest{" +
                "memberId=" + memberId +
                ", concernTags=" + concernTags +
                '}';
    }

}
