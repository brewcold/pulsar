package com.hammer.pulsar.dto.routine;

import java.util.List;

// 루틴 테이블에 저장된 루틴 정보를 수정하기 위한 DTO 클래스
public class RoutineModifyRequest {
    // 루틴의 고유번호
    private int routineId;
    // 루틴 제목
    private String title;
    // 루틴 반복 단위
    private String repeatUnit;
    // 루틴 반복 주기
    private int repeatPeriod;
    // 루틴 시작 시간
    private int startHour;
    // 루틴 시작 분
    private int startMin;

    // 기본 생성자
    public RoutineModifyRequest() {
    }

    // 루틴 작성 폼을 인자로 받는 생성자
    public RoutineModifyRequest(RoutineModifyForm form) {
        this.routineId = form.getRoutineId();
        this.title = form.getRoutineTitle();
        this.repeatUnit = form.getTime().getRepeatUnit();
        this.repeatPeriod = form.getTime().getRepeatPeriod();
        this.startHour = form.getTime().getStartHour();
        this.startMin = form.getTime().getStartMin();
    }

    // Getters, Setters
    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRepeatUnit() {
        return repeatUnit;
    }

    public void setRepeatUnit(String repeatUnit) {
        this.repeatUnit = repeatUnit;
    }

    public int getRepeatPeriod() {
        return repeatPeriod;
    }

    public void setRepeatPeriod(int repeatPeriod) {
        this.repeatPeriod = repeatPeriod;
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
        return "RoutineModifyRequest{" +
                "routineId=" + routineId +
                ", title='" + title + '\'' +
                ", repeatUnit='" + repeatUnit + '\'' +
                ", repeatPeriod=" + repeatPeriod +
                ", startHour=" + startHour +
                ", startMin=" + startMin +
                '}';
    }

}
