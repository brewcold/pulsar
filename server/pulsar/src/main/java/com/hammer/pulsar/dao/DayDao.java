package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.routine.DayUpdateRequest;
import com.hammer.pulsar.dto.routine.RoutineDay;

// 루틴의 요일정보를 저장하는 Day 테이블과 통신하는 DAO
public interface DayDao {
    // 루틴의 요일정보를 추가하는 메서드
    public int insertRoutineDay(DayUpdateRequest request);

    // 루틴의 요일정보를 조회하는 메서드
    public RoutineDay selectRoutineDay(int routineId);

    // 루틴의 요일정보를 수정하는 메서드
    public int updateRoutineDay(DayUpdateRequest request);
}
