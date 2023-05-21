package com.hammer.pulsar.controller;

import com.hammer.pulsar.dto.article.ArticlePreview;
import com.hammer.pulsar.dto.article.CommentedArticle;
import com.hammer.pulsar.dto.member.Member;
import com.hammer.pulsar.dto.member.MemberModifyForm;
import com.hammer.pulsar.dto.member.MemberRegistForm;
import com.hammer.pulsar.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// 회원 관련 API 요청을 처리할 REST 컨트롤러
@RestController
@RequestMapping("/member")
public class MemberRestController {

    private final Logger logger = LoggerFactory.getLogger(MemberRestController.class);

    // 회원 관련 서비스 로직을 처리할 클래스
    private final MemberService memberService;

    // 컨트롤러의 생성자
    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입 요청 API
    @PostMapping(value = "/signup", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> registMember(@RequestPart(value = "form") MemberRegistForm form,
                                             @RequestPart(value = "profileImg", required = false) MultipartFile imgFile) {

        // 회원가입을 문제없이 완료하면 201 응답
        return memberService.registMember(form, imgFile) ?
                new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    // 이메일 중복 검사 요청 API
    // 중복된 이메일이 있을 경우 409 CONFLICT 응답
    @PostMapping("/signup/validation/email")
    public ResponseEntity<Void> checkValidEmail(@RequestBody String email) {
        return memberService.checkDuplicateEmail(email) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.CONFLICT) ;
    }

    // 닉네임 중복 검사 요청 API
    // 중복된 닉네임이 있을 경우 409 CONFLICT 응답
    @PostMapping("/signup/validation/nickname")
    public ResponseEntity<Void> checkValidNickname(@RequestBody String nickname) {
        return memberService.checkDuplicateNickname(nickname) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.CONFLICT) ;
    }

    // 로그인 API
    // 상세 로직을 정하지 못했음
    @PostMapping("/login")
    public ResponseEntity<Void> login(String email, String password) {
        return null;
    }

    // 로그아웃 API
    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        return null;
    }

    // 회원정보 수정 API
    // 먼저 화면에 보여줄 현재 회원 정보
    // TODO: 이후에 서비스 로직에 Optional을 도입하면 404도 고려해보기
    @GetMapping("/{memberId}")
    public ResponseEntity<Member> showMemberInfo(@PathVariable int memberId) {
        Member memberInfo = memberService.getMemberInfo(memberId);

        return new ResponseEntity<>(memberInfo, HttpStatus.OK);
    }

    // 회원정보 수정 API
    // 작성한 정보로 수정 요청
    @PostMapping("/{memberId}")
    public ResponseEntity<Void> modifyMemberInfo(@PathVariable int memberId,
                                                 MemberModifyForm form, MultipartFile imgFile) {
        memberService.modifyMemberInfo(form, imgFile);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 회원 탈퇴 API
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
