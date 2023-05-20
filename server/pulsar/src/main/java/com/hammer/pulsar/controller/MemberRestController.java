package com.hammer.pulsar.controller;

import com.hammer.pulsar.dto.NotDetermined;
import com.hammer.pulsar.dto.article.ArticlePreview;
import com.hammer.pulsar.dto.member.MemberRegistForm;
import com.hammer.pulsar.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    // 회원가입 요청 API
    @PostMapping("/signup")
    public ResponseEntity<Void> registMember(MemberRegistForm form, MultipartFile imgFile) {
        memberService.registMember(form, imgFile);

        // 회원가입을 문제없이 완료하면 201 응답
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 이메일 중복 검사 요청 API
    // 중복된 이메일이 있을 경우 409 CONFLICT 응답
    @PostMapping("/signup/validation/email")
    public ResponseEntity<Void> checkValidEmail(String email) {
        return memberService.checkDuplicateEmail(email) ?
                new ResponseEntity<>(HttpStatus.CONFLICT) :
                new ResponseEntity<>(HttpStatus.OK);
    }

    // 닉네임 중복 검사 요청 API
    // 중복된 닉네임이 있을 경우 409 CONFLICT 응답
    @PostMapping("/signup/validation/nickname")
    public ResponseEntity<Void> checkValidNickname(String nickname) {
        return memberService.checkDuplicateNickname(nickname) ?
                new ResponseEntity<>(HttpStatus.CONFLICT) :
                new ResponseEntity<>(HttpStatus.OK);
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
    @GetMapping("/{memberId}")
    public ResponseEntity<NotDetermined> showMemberInfo(@PathVariable int memberId) {
        return null;
    }

    // 회원정보 수정 API
    // 작성한 정보로 수정 요청
    @PostMapping("/{memberId}")
    public ResponseEntity<Void> modifyMemberInfo(@PathVariable int memberId) {
        return null;
    }

    // 회원 탈퇴 API
    @PostMapping("/{memberId}/quit")
    public ResponseEntity<Void> quitMember(@PathVariable int memberId) {
        return null;
    }

    // 내 활동내역 보기 - 북마크한 글 API
    @GetMapping("/{memberId}/history/bookmark")
    public ResponseEntity<List<ArticlePreview>> showBookmarked(@PathVariable int memberId) {
        return null;
    }

    // 내 활동내역 보기 - 작성한 글 API
    @GetMapping("/{memberId}/history/myarticle")
    public ResponseEntity<List<ArticlePreview>> showWritten(@PathVariable int memberId) {
        return null;
    }

    // 내 활동내역 보기 - 추천한 글 API
    @GetMapping("/{memberId}/history/recommended")
    public ResponseEntity<List<ArticlePreview>> showLiked(@PathVariable int memberId) {
        return null;
    }

    // 내 활동내역 보기 - 댓글 작성한 글 API
    @GetMapping("/{memberId}/history/comment")
    public ResponseEntity<List<NotDetermined>> showCommented(@PathVariable int memberId) {
        return null;
    }

}
