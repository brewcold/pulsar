package com.hammer.pulsar.dto.routine;

import java.util.Arrays;
import java.util.List;

// 루틴의 시간 정보를 저장하고 있는 DTO 클래스
public class RoutineTime {
    // 반복 주기
    private int repeatPeriod;
    // 반복 단위
    private String repeatUnit;
    // 요일
    private List<String> repeatDay;
    // 시작 시간
    // {시(24시), 분}
    private int[] startTime;

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

    public int[] getStartTime() {
        return startTime;
    }

    public void setStartTime(int[] startTime) {
        this.startTime = startTime;
    }

    // toString
    @Override
    public String toString() {
        return "RoutineTime{" +
                "repeatPeriod=" + repeatPeriod +
                ", repeatUnit='" + repeatUnit + '\'' +
                ", repeatDay=" + repeatDay +
                ", startTime=" + Arrays.toString(startTime) +
                '}';
    }

}
