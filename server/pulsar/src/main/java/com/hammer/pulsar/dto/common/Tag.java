package com.hammer.pulsar.dto.common;

// 회원의 고민, 게시글 태그 목록에 사용할 DTO 클래스
public class Tag {
    // 태그 번호
    private int tagNo;
    // 태그명
    private String tagName;

    // 기본 생성자
    public Tag() {}

    // Getter, Setters
    public int getTagNo() {
        return tagNo;
    }

    public void setTagNo(int tagNo) {
        this.tagNo = tagNo;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    // toString
    @Override
    public String toString() {
        return "Tag{" +
                "tagNo=" + tagNo +
                ", tagName='" + tagName + '\'' +
                '}';
    }

}
