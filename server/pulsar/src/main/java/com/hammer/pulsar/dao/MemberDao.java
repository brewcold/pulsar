package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.member.MemberRegistRequest;

// Member 테이블과 통신하기 위한 DAO
public interface MemberDao {
    // 회원가입을 위한 insert 메서드
    public int insertMember(MemberRegistRequest request);

    // 이메일 중복 검사를 위한 조회 메서드
    public boolean findEmail(String email);

    // 닉네임 중복 검사를 위한 메서드
    public boolean findNickname(String nickname);

    // 회원 정보 수정을 위한 메서드
    public int updateMember(MemberRegistRequest request);

    // 회원 탈퇴를 위한 메서드
    public int deleteMember(int memberId);

}
