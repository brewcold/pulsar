package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.routine.Exercise;
import com.hammer.pulsar.dto.routine.ExerciseRegistRequest;

import java.util.List;

// 루틴의 운동 정보를 저장하는 Exercise 테이블과 통신하는 DAO
public interface RoutineDetailDao {
    // 선택한 루틴에 운동을 추가하는 메서드
    public void insertExercises(ExerciseRegistRequest request);

    // 선택한 루틴의 운동목록을 조회하는 메서드
    public List<Exercise> selectExercisesByRoutineId(int routineId);

    // 선택한 운동을 삭제하는 메서드
    public void deleteExercises(int routineId);
}
