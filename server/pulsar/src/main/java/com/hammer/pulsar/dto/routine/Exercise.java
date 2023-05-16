package com.hammer.pulsar.dto.routine;

// 운동 정보를 저장하고 있는 DTO 클래스
public class Exercise {
    // 운동 이름
    private String exerciseName;
    // 운동 횟수
    private int count;
    // 운동 1회 당 시간
    private int duration;
    // 운동 순서
    private int order;

    // 기본 생성자
    public Exercise() {}

    // Getters, Setters
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    // toString
    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseName='" + exerciseName + '\'' +
                ", count=" + count +
                ", duration=" + duration +
                ", order=" + order +
                '}';
    }

}
