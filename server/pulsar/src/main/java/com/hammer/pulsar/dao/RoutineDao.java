package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.routine.Routine;

import java.util.List;

// 루틴 정보를 저장하는 Routine 테이블과 통신하는 DAO
public interface RoutineDao {
    // 선택한 회원의 루틴을 추가하는 메서드
    public int insertRoutine(Routine routine);

    // 회원의 루틴 목록을 조회하는 메서드
    public List<Routine> selectRoutinesByMemberId(int memberId);

    // 회원의 루틴을 수정하는 메서드
    public int updateRoutine(Routine routine);

    // 회원의 루틴을 삭제하는 메서드
    public int deleteRoutine(int routineId);
}
