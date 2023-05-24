package com.hammer.pulsar.controller;

import com.hammer.pulsar.dto.article.ArticlePreview;
import com.hammer.pulsar.dto.article.CommentedArticle;
import com.hammer.pulsar.dto.common.LoginSuccessResponse;
import com.hammer.pulsar.dto.member.*;
import com.hammer.pulsar.exception.UnauthorizedException;
import com.hammer.pulsar.service.MemberService;
import com.hammer.pulsar.util.UUIDTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

// 회원 관련 API 요청을 처리할 REST 컨트롤러
@RestController
@RequestMapping("/member")
public class MemberRestController {

    // 회원 관련 서비스 로직을 처리할 클래스
    private final MemberService memberService;

    // 컨트롤러의 생성자
    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원가입 요청 API
     *
     * @param form
     * @param imgFile
     * @return
     *  200 OK : 회원가입 성공 <br>
     *  409 CONFLICT : 이메일 또는 닉네임 중복
     */
    @PostMapping(value = "/signup", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> registMember(@RequestPart(value = "form") MemberRegistForm form,
                                             @RequestPart(value = "profileImg", required = false) MultipartFile imgFile) {

        // 회원가입을 문제없이 완료하면 201 응답
        return memberService.registMember(form, imgFile) ?
                new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    /**
     * 이메일 중복 검사 요청 API
     *
     * @param email
     * @return
     *  200 OK : 사용 가능한 이메일 <br>
     *  409 CONFLICT : 중복된 이메일
     */
    @PostMapping("/signup/validation/email")
    public ResponseEntity<Void> checkValidEmail(@RequestBody String email) {
        return memberService.checkDuplicateEmail(email) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.CONFLICT) ;
    }

    /**
     * 닉네임 중복 검사 요청 API
     *
     * @param nickname
     * @return
     *  200 OK : 사용가능한 닉네임 <br>
     *  409 CONFLICT : 중복된 닉네임
     */
    @PostMapping("/signup/validation/nickname")
    public ResponseEntity<Void> checkValidNickname(@RequestBody String nickname) {
        return memberService.checkDuplicateNickname(nickname) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.CONFLICT) ;
    }

    // 로그인 API
    // JWT 이전까지는 UUID 형식의 토큰과 로그인 정보를 반환합니다.
    // TODO: JWT 방식으로 변경하기
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm form, HttpServletRequest request) throws UnsupportedEncodingException {
        MemberProfile memberProfile = memberService.login(form);

        String token = UUIDTokenManager.getNewAuthToken(memberProfile);

        return new ResponseEntity<>(new LoginSuccessResponse(memberProfile, token), HttpStatus.OK);
    }

    // 로그아웃 API
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization");

        UUIDTokenManager.removeAuthToken(authToken);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 회원정보 조회 API
     *
     * @param memberId
     * @return
     *  200 OK : 조회 성공 <br>
     *  404 NOT FOUND : 존재하지 않는 회원
     */
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberProfile> showMemberInfo(@PathVariable int memberId) {
        MemberProfile memberInfo = memberService.getMemberInfo(memberId);

        return new ResponseEntity<>(memberInfo, HttpStatus.OK);
    }

    // 회원정보 수정 API
    // 작성한 정보로 수정 요청
    @PostMapping(value = "/{memberId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<MemberModifyResponse> modifyMemberInfo(@PathVariable int memberId,
                                                 @RequestPart(value = "form") MemberModifyForm form,
                                                 @RequestPart(value = "imgFile", required = false) MultipartFile imgFile,
                                                 HttpServletRequest request) {
//        int loginMember = UUIDTokenManager.getLoginUserInfo(request.getHeader("Authorization")).getMemberNo();
//
//        if(loginMember != memberId) throw new UnauthorizedException("권한이 없습니다.");

        form.setMemberId(memberId);
        MemberModifyResponse response = memberService.modifyMemberInfo(form, imgFile);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 회원 탈퇴 API
     *
     * @param memberId
     * @return
     *  200 OK : 회원탈퇴 성공 <br>
     *  404 NOT FOUND : 존재하지 않는 회원
     */
    @PostMapping("/{memberId}/quit")
    public ResponseEntity<Void> quitMember(@PathVariable int memberId) {
        memberService.quitMember(memberId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 내 활동내역 보기 - 작성한 글 API
    @GetMapping("/{memberId}/history/myarticle")
    public ResponseEntity<List<ArticlePreview>> showWritten(@PathVariable int memberId) {
        List<ArticlePreview> myArticles = memberService.getAllWritten(memberId);

        return new ResponseEntity<>(myArticles, HttpStatus.OK);
    }

    // 내 활동내역 보기 - 추천한 글 API
    @GetMapping("/{memberId}/history/recommended")
    public ResponseEntity<List<ArticlePreview>> showLiked(@PathVariable int memberId) {
        List<ArticlePreview> myLiked = memberService.getAllLiked(memberId);

        return new ResponseEntity<>(myLiked, HttpStatus.OK);
    }

    // 내 활동내역 보기 - 댓글 작성한 글 API
    @GetMapping("/{memberId}/history/comment")
    public ResponseEntity<List<CommentedArticle>> showCommented(@PathVariable int memberId) {
        List<CommentedArticle> myComments = memberService.getAllCommented(memberId);

        return new ResponseEntity<>(myComments, HttpStatus.OK);
    }

}
