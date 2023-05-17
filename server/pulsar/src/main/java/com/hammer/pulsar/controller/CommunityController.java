package com.hammer.pulsar.controller;

import com.hammer.pulsar.service.ArticleService;
import com.hammer.pulsar.service.InteractionService;
import com.hammer.pulsar.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 커뮤니티 관련 API 요청을 처리할 REST 컨트롤러
@RestController
@RequestMapping("/community")
public class CommunityController {

    // 커뮤니티 관련 서비스 로직을 처리할 클래스
    private final ArticleService articleService;
    private final InteractionService interactionService;

    // 컨트롤러의 생성자
    @Autowired
    public CommunityController(ArticleService articleService, InteractionService interactionService) {
        this.articleService = articleService;
        this.interactionService = interactionService;
    }
}
