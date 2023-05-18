package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.common.ConcernUpdateRequest;
import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// 회원의 고민 태그를 저장하는 Concern 테이블과 통신하기 위한 DAO
public interface ConcernDao {
    // 선택한 회원이 고른 고민들을 추가하기 위한 메서드
    public void insertConcernTags(ConcernUpdateRequest request);

    // 선택한 회원이 고른 고민들을 조회하기 위한 메서드
    public List<Tag> selectTagsByMemberId(int memberId);

    // 선택한 회원이 고른 고민들을 삭제하기 위한 메서드
    public void deleteConcernTags(ConcernUpdateRequest request);

}
