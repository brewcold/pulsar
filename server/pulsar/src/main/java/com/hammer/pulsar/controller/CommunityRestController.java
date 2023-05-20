package com.hammer.pulsar.controller;

import com.hammer.pulsar.dto.NotDetermined;
import com.hammer.pulsar.dto.article.Article;
import com.hammer.pulsar.dto.article.ArticlePreview;
import com.hammer.pulsar.service.ArticleService;
import com.hammer.pulsar.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 커뮤니티 관련 API 요청을 처리할 REST 컨트롤러
@RestController
@RequestMapping("/community")
public class CommunityRestController {

    // 커뮤니티 관련 서비스 로직을 처리할 클래스
    private final ArticleService articleService;
    private final InteractionService interactionService;

    // 컨트롤러의 생성자
    @Autowired
    public CommunityRestController(ArticleService articleService, InteractionService interactionService) {
        this.articleService = articleService;
        this.interactionService = interactionService;
    }

    // 게시글 목록 조회 API
    @GetMapping()
    public ResponseEntity<List<ArticlePreview>> showAllArticles() {
        List<ArticlePreview> articleList = articleService.getAllArticles();

        return new ResponseEntity<>(articleList, HttpStatus.OK);
    }

    // 글 상세보기 API
    @GetMapping("/{articleId}/static")
    public ResponseEntity<Article> showArticleDetail(@PathVariable int articleId) {
        Article article = articleService.getArticle(articleId);

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    // 글 작성하기 API
    @PostMapping()
    public ResponseEntity<Integer> writeArticle(NotDetermined request) {
        return null;
    }

    // 글 수정하기 API
    @PutMapping()
    public ResponseEntity<Void> modifyArticle(NotDetermined request) {
        return null;
    }

    // 글 삭제하기 API
    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> removeArticle(@PathVariable int articleId) {
        return null;
    }

    // GET 요청이 더 좋아보이기도 합니다.
    // 응답에 검색조건에 맞는 게시글 목록이 들어가야 할 것 같습니다.
    // 검색 API
    @PostMapping("/search")
    public ResponseEntity<List<ArticlePreview>> searchArticles(NotDetermined searchCondition) {
        return null;
    }

}
