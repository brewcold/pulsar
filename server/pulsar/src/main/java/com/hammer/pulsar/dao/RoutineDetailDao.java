package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.routine.Exercise;

import java.util.List;

// 루틴의 운동 정보를 저장하는 Exercise 테이블과 통신하는 DAO
public interface ExerciseDao {
    // 선택한 루틴에 운동을 추가하는 메서드
    public int insertExercise(int routineId, Exercise exercise);

    // 선택한 루틴의 운동목록을 조회하는 메서드
    public List<Exercise> selectExercisesByRoutineId(int routineId);

    // 선택한 운동을 수정하는 메서드
    public int updateExercise(Exercise exercise);

    // 선택한 운동을 삭제하는 메서드
    public int deleteExercise(int exerciseId);
}
