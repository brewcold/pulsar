package com.hammer.pulsar.dto.routine;

import java.util.List;

// 루틴 정보를 담고 있는 DTO 클래스
public class Routine {
    // 루틴 번호
    private int rountineNo;
    // 루틴 이름
    private int routineTitle;
    // 시간 정보

    // 루틴에 포함된 운동 정보
    private List<Exercise> exerciseList;

    // 기본 생성자
    public Routine() {}

    // Getters, Setters
    public int getRountineNo() {
        return rountineNo;
    }

    public void setRountineNo(int rountineNo) {
        this.rountineNo = rountineNo;
    }

    public int getRoutineTitle() {
        return routineTitle;
    }

    public void setRoutineTitle(int routineTitle) {
        this.routineTitle = routineTitle;
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
        return "Routine{" +
                "rountineNo=" + rountineNo +
                ", routineTitle=" + routineTitle +
                ", exerciseList=" + exerciseList +
                '}';
    }

}
