package com.hammer.pulsar.dto.routine;

import java.util.List;

// 루틴의 시간 정보를 저장하고 있는 DTO 클래스
public class RoutineTime {
    // 시간 정보
    // 반복 주기 (0~30의 정수)
    private int repeatPeriod;
    // 반복 단위 (day, week, month)
    private String repeatUnit;
    // 요일 (mon, tue, wed, thu, fri, sat, sun)
    private List<String> repeatDay;
    // 시작 시간 : 시(24시), 분
    private int startHour;
    private int startMin;

    // 기본 생성자
    public RoutineTime() {}

    // Getters, Setters
    public int getRepeatPeriod() {
        return repeatPeriod;
    }

    public void setRepeatPeriod(int repeatPeriod) {
        this.repeatPeriod = repeatPeriod;
    }

    public String getRepeatUnit() {
        return repeatUnit;
    }

    public void setRepeatUnit(String repeatUnit) {
        this.repeatUnit = repeatUnit;
    }

    public List<String> getRepeatDay() {
        return repeatDay;
    }

    public void setRepeatDay(List<String> repeatDay) {
        this.repeatDay = repeatDay;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMin() {
        return startMin;
    }

    public void setStartMin(int startMin) {
        this.startMin = startMin;
    }

    // toString
    @Override
    public String toString() {
        return "RoutineTime{" +
                "repeatPeriod=" + repeatPeriod +
                ", repeatUnit='" + repeatUnit + '\'' +
                ", repeatDay=" + repeatDay +
                ", startHour=" + startHour +
                ", startMin=" + startMin +
                '}';
    }

}
