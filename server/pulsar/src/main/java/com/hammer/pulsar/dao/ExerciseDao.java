package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

public interface ExerciseDao {
    // 선택할 수 있는 모든 운동 태그 정보를 가져오는 메서드
    public List<Tag> selectAllExerciseTags();
}
