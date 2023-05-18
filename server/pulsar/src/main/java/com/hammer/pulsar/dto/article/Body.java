package com.hammer.pulsar.dto.article;

import com.hammer.pulsar.dto.routine.Routine;

import java.util.List;

// 게시글의 내용 부분을 저장하는 DTO 클래스
public class Body {
    // 본문에 포함된 루틴 정보
    private Routine routine;
    // 본문 글 내용
    private String content;
    // 본문에 첨부된 이미지
    private List<String> imgs;

    // 기본 생성자
    public Body() {}

    // Getters, Setters
    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }


    // toString
    @Override
    public String toString() {
        return "Body{" +
                "routine=" + routine +
                ", content='" + content + '\'' +
                ", imgs=" + imgs +
                '}';
    }

}
