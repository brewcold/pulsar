package com.hammer.pulsar.dto.routine;

import java.util.List;

// 이미 작성된 루틴의 내용을 수정할 때 사용하는 DTO 클래스
public class RoutineModifyForm {
    // 루틴 번호
    private int routineId;
    // 루틴 이름
    private String routineTitle;
    // 루틴 시간 정보
    private RoutineTime time;
    // 루틴 세부 운동 계획 정보
    private List<Exercise> exerciseList;

    // 기본 생성자
    public RoutineModifyForm() {}

    // Getters, Setters
    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

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

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    // toString
    @Override
    public String toString() {
        return "RoutineModifyForm{" +
                "routineId=" + routineId +
                ", routineTitle='" + routineTitle + '\'' +
                ", time=" + time +
                ", exerciseList=" + exerciseList +
                '}';
    }

}
