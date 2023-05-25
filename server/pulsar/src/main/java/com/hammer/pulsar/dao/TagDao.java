package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// 태그 정보를 저장하는 Tag 테이블과 통신하기 위한 DAO
public interface TagDao {
    // 선택할 수 있는 모든 태그 정보를 조회하는 메서드
    public List<Tag> selectAllTags();

}
