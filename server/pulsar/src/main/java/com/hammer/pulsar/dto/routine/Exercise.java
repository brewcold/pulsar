package com.hammer.pulsar.dto.routine;

// API 응답으로 보낼 운동 정보를 저장하고 있는 DTO 클래스
public class Exercise {
    // 운동 세부 계획 번호
    private int exerciseNo;
    // 운동 이름
    private String exerciseName;
    // 운동 횟수
    private int count;
    // 운동 1회 당 시간
    private int duration;

    // 기본 생성자
    public Exercise() {}

    // Getters, Setters
    public int getExerciseNo() {
        return exerciseNo;
    }

    public void setExerciseNo(int exerciseNo) {
        this.exerciseNo = exerciseNo;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // toString
    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseNo=" + exerciseNo +
                ", exerciseName='" + exerciseName + '\'' +
                ", count=" + count +
                ", duration=" + duration +
                '}';
    }

}
