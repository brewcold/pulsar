package com.hammer.pulsar.dto.routine;

// 새로운 루틴을 추가할 때 사용하기 위한 DTO 클래스
public class RoutineRegistForm {
    // 루틴 제목
    private String routineTitle;
    // 루틴 시간 정보
    private RoutineTime time;

    // 기본 생성자
    public RoutineRegistForm() {}

    // Getters, Setters
    public String getRoutineTitle() {
        return routineTitle;
    }

    public void setRoutineTitle(String routineTitle) {
        this.routineTitle = routineTitle;
    }

    public RoutineTime getTime() {
        return time;
    }

    public void setTime(RoutineTime time) {
        this.time = time;
    }

    // toString
    @Override
    public String toString() {
        return "RoutineUpdateForm{" +
                "routineTitle='" + routineTitle + '\'' +
                ", time=" + time +
                '}';
    }

}
