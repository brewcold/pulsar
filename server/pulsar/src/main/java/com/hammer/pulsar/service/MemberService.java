package com.hammer.pulsar.service;

import com.hammer.pulsar.dto.article.ArticlePreview;
import com.hammer.pulsar.dto.article.CommentedArticle;
import com.hammer.pulsar.dto.member.Member;
import com.hammer.pulsar.dto.member.MemberModifyForm;
import com.hammer.pulsar.dto.member.MemberRegistForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

// 회원 관련 로직을 처리할 서비스의 인터페이스
public interface MemberService {
    // 회원 가입 로직
    public boolean registMember(MemberRegistForm form, MultipartFile imgFile);

    // 이메일 중복 검사 로직
    public boolean checkDuplicateEmail(String email);

    // 닉네임 중복 검사 로직
    public boolean checkDuplicateNickname(String nickname);

    // 선택한 회원의 정보 조회 로직
    public Member getMemberInfo(int memberId) throws NoSuchElementException;

    // 회원 정보 수정 로직
    public String modifyMemberInfo(MemberModifyForm form, MultipartFile imgFile);

    // 회원 탈퇴 로직
    public void quitMember(int memberId) throws NoSuchElementException;

    // 회원이 쓴 글 목록 조회 로직
    public List<ArticlePreview> getAllWritten(int memberId);

    // 회원이 추천한 글 목록 조회 로직
    public List<ArticlePreview> getAllLiked(int memberId);

    // 회원이 쓴 댓글과 해당 게시글 목록 조회 로직
    public List<CommentedArticle> getAllCommented(int memberId);

}
