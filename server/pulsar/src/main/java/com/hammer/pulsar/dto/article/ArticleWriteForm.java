package com.hammer.pulsar.dto.article;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// 게시글 작성을 위해 사용자가 입력한 내용을 담고 있는 DTO 클래스
public class ArticleWriteForm {
    // 게시글 제목
    private String title;
    // 게시글 본문
    private Body body;
    // 게시글에 선택한 태그 목록
    private List<Tag> tagList;

    // 기본 생성자
    public ArticleWriteForm() {}

    // Getters, Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    // toString
    @Override
    public String toString() {
        return "ArticleWriteForm{" +
                "title='" + title + '\'' +
                ", body=" + body +
                ", tagList=" + tagList +
                '}';
    }

}
