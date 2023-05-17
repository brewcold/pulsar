package com.hammer.pulsar.service;

import com.hammer.pulsar.dto.NotDetermined;
import com.hammer.pulsar.dto.article.ArticlePreview;
import com.hammer.pulsar.dto.member.MemberProfile;
import com.hammer.pulsar.dto.member.MemberRegistRequest;

import java.util.List;

// 회원 관련 로직을 처리할 서비스의 인터페이스
public interface MemberService {
    // 회원 가입 로직
    public void registMember(MemberRegistRequest request);

    // 선택한 회원의 프로필 조회 로직
    public NotDetermined getMemberProfile(int memberId);

    // 회원 정보 수정 로직
    public NotDetermined modifyMemberInfo(NotDetermined request);

    // 회원 탈퇴 로직
    public void quitMember(int memberId);

    // 회원이 쓴 글 목록 조회 로직
    public List<ArticlePreview> getAllWritten(int memberId);

    // 회원이 북마크한 글 목록 조회 로직
    public List<ArticlePreview> getAllBookmarked(int memberId);

    // 회원이 추천한 글 목록 조회 로직
    public List<ArticlePreview> getAllLiked(int memberId);

    // 회원이 쓴 댓글과 해당 게시글 목록 조회 로직
    public List<ArticlePreview> getAllCommented(int memberId);

}
