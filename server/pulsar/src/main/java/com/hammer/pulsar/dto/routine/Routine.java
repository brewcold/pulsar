package com.hammer.pulsar.dto.routine;

import java.util.List;

// 루틴 정보를 담고 있는 DTO 클래스
// 루틴 API에서 주고받을 정보
public class Routine {
    // 루틴 작성자 번호
    private int memberNo;
    // 루틴 번호
    private int routineNo;
    // 루틴 이름
    private String routineTitle;
    // 시간 정보
    private RoutineTime time;
    // 루틴에 포함된 운동 정보
    private List<Exercise> exerciseList;

    // 기본 생성자
    public Routine() {}

    // Getters, Setters
    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getRoutineNo() {
        return routineNo;
    }

    public void setRoutineNo(int routineNo) {
        this.routineNo = routineNo;
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
        return "Routine{" +
                "memberNo=" + memberNo +
                ", routineNo=" + routineNo +
                ", routineTitle='" + routineTitle + '\'' +
                ", time=" + time +
                ", exerciseList=" + exerciseList +
                '}';
    }

}
