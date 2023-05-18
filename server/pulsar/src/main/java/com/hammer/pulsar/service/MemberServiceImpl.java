package com.hammer.pulsar.service;

import com.hammer.pulsar.dao.*;
import com.hammer.pulsar.dto.article.ArticlePreview;
import com.hammer.pulsar.dto.common.ConcernRegistRequest;
import com.hammer.pulsar.dto.member.Member;
import com.hammer.pulsar.dto.member.MemberModifyRequest;
import com.hammer.pulsar.dto.member.MemberRegistForm;
import com.hammer.pulsar.dto.member.MemberRegistRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// 실제 로직이 구현된 MemberService 인터페이스의 구현체 클래스
@Service
public class MemberServiceImpl implements MemberService {

    // 테이블에 접근할 수 있는 DAO
    private final MemberDao memberDao;
    private final ArticleDao articleDao;
    private final LikeDao likeDao;
    private final CommentDao commentDao;
    private final ConcernDao concernDao;

    // 업로드한 파일 저장을 위한 서비스
    private final FileManagementService fileManagementService;

    @Autowired
    public MemberServiceImpl(MemberDao memberDao, ArticleDao articleDao, LikeDao likeDao, CommentDao commentDao,
                             ConcernDao concernDao, FileManagementService fileManagementService) {
        this.memberDao = memberDao;
        this.articleDao = articleDao;
        this.likeDao = likeDao;
        this.commentDao = commentDao;
        this.concernDao = concernDao;
        this.fileManagementService = fileManagementService;
    }

    /**
     * 회원 가입 시 필요한 정보를 이용해 회원 가입을 진행하는 메서드
     *  - 이메일과 닉네임의 유효성 검사를 진행한다.
     *  - 유효한 Form이면 데이터를 분리해 아래의 동작을 수행한다.
     *  1. 이미지를 저장한 후, 저장한 이미지에 접근할 수 있는 경로를 MemberRegistRequest에 담는다.
     *  2. 회원 테이블에 저장될 정보만 MemberRegistRequest에 담아 테이블에 저장한다.
     *  3. 회원 고민 테이블에 저장될 정보만 ConcernRegistRequest에 담아 테이블에 저장한다.
     *
     * @param form
     * @param imgFile
     */
    @Override
    public void registMember(MemberRegistForm form, MultipartFile imgFile) {
        // 이메일, 닉네임 중복 검사를 서버 측에서 한 번 더 진행하기
        if(!checkIsValidForm(form)) return;

        // 프로필 이미지를 저장하기
        String profileImg = fileManagementService.uploadMemberProfileImg(imgFile);
        // 회원 테이블에 저장할 정보만 담기
        MemberRegistRequest memberRegistRequest = new MemberRegistRequest(form, profileImg);
        // 회원 테이블에 정보를 저장하기
        int memberId = memberDao.insertMember(memberRegistRequest);

        // 고민 테이블에 저장할 정보만 담기
        ConcernRegistRequest concernRegistRequest = new ConcernRegistRequest(memberId, form.getSelectedTag());
        // 고민 테이블에 정보를 저장하기
        concernDao.insertConcernTags(concernRegistRequest);
    }

    /**
     * Form에 저장된 이메일과 닉네임의 유효성 검사를 진행하는 메서드
     *
     * @param form
     * @return 유효한 폼이면 true, 중복된 값이 하나라도 있다면 false
     */
    private boolean checkIsValidForm(MemberRegistForm form) {
        // 이메일 중복 검사
        if(memberDao.findEmail(form.getEmail())) return false;
        // 닉네임 중복 검사
        if(memberDao.findNickname(form.getNickname())) return false;

        return true;
    }

    @Override
    public Member getMemberInfo(int memberId) {
        return null;
    }

    @Override
    public void modifyMemberInfo(MemberModifyRequest request) {

    }

    @Override
    public void quitMember(int memberId) {

    }

    @Override
    public List<ArticlePreview> getAllWritten(int memberId) {
        return null;
    }

    @Override
    public List<ArticlePreview> getAllLiked(int memberId) {
        return null;
    }

    @Override
    public List<ArticlePreview> getAllCommented(int memberId) {
        return null;
    }

}
