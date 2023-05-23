package com.hammer.pulsar.dto.routine;

import java.util.List;

// 루틴에 운동 계획 정보를 저장하기 위한 DTO 클래스
public class ExerciseRegistRequest {
    // 루틴 고유번호
    private int routineId;
    // 루틴에 저장된 운동정보
    private List<Exercise> exerciseList;

    // 기본 생성자
    public ExerciseRegistRequest() {}

    // Getters, Setters
    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
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
        return "ExerciseRegistRequest{" +
                "routineId=" + routineId +
                ", exerciseList=" + exerciseList +
                '}';
    }

}
