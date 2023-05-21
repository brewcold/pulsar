package com.hammer.pulsar.service;

import com.hammer.pulsar.dao.*;
import com.hammer.pulsar.dto.article.ArticlePreview;
import com.hammer.pulsar.dto.article.CommentedArticle;
import com.hammer.pulsar.dto.common.ConcernUpdateRequest;
import com.hammer.pulsar.dto.common.Tag;
import com.hammer.pulsar.dto.member.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    @Transactional
    public boolean registMember(MemberRegistForm form, MultipartFile imgFile) {
        // 이메일, 닉네임 중복 검사를 서버 측에서 한 번 더 진행하기
        if(!isValidEmail(form.getEmail()) || !isValidNickname(form.getNickname())) return false;

        // 프로필 이미지를 저장하기
        String profileImg = fileManagementService.uploadMemberProfileImg(imgFile);
        // 회원 테이블에 저장할 정보만 담기
        MemberRegistRequest memberRegistRequest = new MemberRegistRequest(form, profileImg);
        // 회원 테이블에 정보를 저장하기
        int memberId = memberDao.insertMember(memberRegistRequest);

        // 고민 테이블에 저장할 정보만 담기
        // 고민 태그는 번호만 추출해서 Request 객체에 저장한다.
        ConcernUpdateRequest concernUpdateRequest =
                new ConcernUpdateRequest(memberId, form.getSelectedTag().stream().
                        map((Tag::getTagNo)).collect(Collectors.toList()));
        // 고민 테이블에 정보를 저장하기
//        concernDao.insertConcernTags(concernUpdateRequest);

        return true;
    }

    /**
     * 입력한 이메일의 유효성 검사를 진행하는 메서드
     *
     * @param email
     * @return 유효한 이메일이면 true, 중복된 이메일이면 false
     */
    private boolean isValidEmail(String email) {
        // 이메일 중복 검사
        return memberDao.findEmail(email);
    }

    /**
     * 입력한 닉네임의 유효성 검사를 진행하는 메서드
     *
     * @param nickname
     * @return 유효한 닉네임이면 true, 중복된 닉네임이면 false
     */
    private boolean isValidNickname(String nickname) {
        // 이메일 중복 검사
        return memberDao.findNickname(nickname);
    }

    /**
     * 회원가입 폼에서 AJAX로 이메일 중복 검사를 진행할 때 호출할 메서드
     *
     * @param email
     * @return 중복이면 false
     */
    @Override
    public boolean checkDuplicateEmail(String email) {
        return isValidEmail(email);
    }

    /**
     * 회원가입 폼에서 AJAX로 닉네임 중복 검사를 진행할 때 호출할 메서드
     *
     * @param nickname
     * @return 중복이면 false
     */
    @Override
    public boolean checkDuplicateNickname(String nickname) {
        return isValidNickname(nickname);
    }

    /**
     * 선택한 회원의 세부 정보를 조회하는 메서드
     *
     * @param memberId
     * @return
     */
    @Override
    public Member getMemberInfo(int memberId) {
        return memberDao.selectMemberByMemberId(memberId);
    }

    /**
     * 회원정보 수정 메서드
     * - 회원 정보 변경 폼의 값들 중 테이블에서 수정해야 할 항목들을 MemberModifyRequest에 저장한다.
     * - 수정사항이 적용되어야 할 테이블에 맞게 수정 요청을 보낸다.
     * - 회원 정보를 변경한 후의 닉네임을 반환한다.
     *
     * @param form
     */
    @Override
    public String modifyMemberInfo(MemberModifyForm form, MultipartFile imgFile) {
        // DB에 저장된 기존 회원정보를 조회한다.
        Member saved = memberDao.selectMemberByMemberId(form.getMemberId());
        // 기존의 값과 변경된 사항들을 저장한 MemberModifyRequest를 생성한다.
        MemberModifyRequest request = selectModified(form, saved);

        if(request == null) return saved.getNickname();

        // 테이블에 저장된 정보를 요청사항에 맞게 수정한다.
        String profileImg = fileManagementService.uploadMemberProfileImg(imgFile);
        if(profileImg != null) request.setProfileImg(profileImg);

        // 회원 테이블의 정보를 수정한다.
        memberDao.updateMember(request);

        // 태그 목록을 수정한다.
        modifyTagList(form.getSelectedTag(), saved.getMemberId());

        // 수정 작업 후의 회원의 닉네임을 반환한다.
        return request.getNickname() == null ?
                saved.getNickname() :
                request.getNickname();
    }

    /**
     * 사용자로부터 전달받은 값과 DB에 저장된 값들을 비교해 변경이 일어난 값들만 반환한다.
     * 변경하려는 닉네임이 중복일 경우 null을 반환한다.
     *
     * @param form
     * @param saved
     * @return
     */
    private MemberModifyRequest selectModified(MemberModifyForm form, Member saved) {
        MemberModifyRequest modified = new MemberModifyRequest();

        String newPassword = form.getPassword();
        String newNickname = form.getNickname();

        // 비밀번호가 변경되었다면 변경된 비밀번호를 modified에 저장
        if(!newPassword.equals(saved.getPassword())) modified.setPassword(newPassword);
        // 닉네임이 변경되었다면 중복 검사 후 modified에 저장
        if(!newNickname.equals(saved.getNickname())) {
            // 중복된 닉네임이면 null 반환 -> 예외 던지도록 변경 필요할 듯
            if(!isValidNickname(newNickname)) return null;

            modified.setNickname(newNickname);
        }

        return modified;
    }

    /**
     * 기존의 태그와 새롭게 전달받은 태그를 비교하여 변경사항들을 DB에 업데이트한다.
     *
     * @param newTags
     */
    private void modifyTagList(List<Tag> newTags, int memberId) {
        // 현재 회원이 선택한 고민 태그 목록들을 모두 불러온다.
        List<Tag> savedTags = concernDao.selectTagsByMemberId(memberId);

        /*
            기존의 고민과 새로운 고민 태그 목록을 비교한다.
            새로운 고민들은 DB에 추가하고, 기존 태그 목록에만 존재하는 값은 DB에서 삭제한다.
         */

        // 두 태그 목록 사이에 중복되는 요소를 걸러낼 set
        Set<Integer> savedTagsId = new HashSet<>();
        // 새로 추가된 태그들을 저장할 리스트
        List<Integer> appendedTags = new ArrayList<>();

        for(Tag tag : savedTags) {
            savedTagsId.add(tag.getTagNo());
        }

        // 기존과 변동이 없는 태그들을 걸러내기
        for(Tag tag : newTags) {
            // set에 없는 태그는 새롭게 추가된 태그이므로 appendedTags에 저장하기
            if(!savedTagsId.remove(tag.getTagNo())) {
                appendedTags.add(tag.getTagNo());
            }
        }

        // 새롭게 추가된 태그 목록들은 DB에 저장하기
        concernDao.insertConcernTags(new ConcernUpdateRequest(memberId, appendedTags));

        // Set에 남아있는 태그는 기존 태그 목록에만 존재하는 요소이므로 삭제하기
        concernDao.deleteConcernTags(new ConcernUpdateRequest(memberId, new ArrayList<>(savedTagsId)));
    }

    /**
     * 회원탈퇴 메서드
     *
     * @param memberId
     */
    @Override
    public void quitMember(int memberId) {
        memberDao.deleteMember(memberId);
    }

    /**
     * 선택한 회원이 작성한 모든 게시글을 조회하는 메서드
     *
     * @param memberId
     * @return
     */
    @Override
    public List<ArticlePreview> getAllWritten(int memberId) {
        return articleDao.selectArticleByMemberId(memberId);
    }

    /**
     * 선택한 회원이 추천한 모든 게시글 목록을 조회하는 메서드
     *
     * @param memberId
     * @return
     */
    @Override
    public List<ArticlePreview> getAllLiked(int memberId) {
        return likeDao.selectLikedByMemberId(memberId);
    }

    /**
     * 선택한 회원이 작성한 모든 댓글과 해당 댓글이 작성된 게시글을 모두 조회하는 메서드
     *
     * @param memberId
     * @return
     */
    @Override
    public List<CommentedArticle> getAllCommented(int memberId) {
        return commentDao.selectCommentsByMemberId(memberId);
    }

}
