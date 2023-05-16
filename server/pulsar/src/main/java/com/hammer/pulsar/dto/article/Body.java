package com.hammer.pulsar.dto.article;

import com.hammer.pulsar.dto.routine.Routine;

// 게시글의 내용 부분을 저장하는 DTO 클래스
public class Body {
    private Routine routine;
    private String content;

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

    // toString
    @Override
    public String toString() {
        return "Body{" +
                "routine=" + routine +
                ", content='" + content + '\'' +
                '}';
    }

}
