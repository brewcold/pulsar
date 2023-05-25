package com.hammer.pulsar.controller;

import com.hammer.pulsar.dto.article.*;
import com.hammer.pulsar.dto.interaction.Comment;
import com.hammer.pulsar.dto.interaction.CommentWriteRequest;
import com.hammer.pulsar.dto.interaction.Like;
import com.hammer.pulsar.dto.interaction.LikeRequest;
import com.hammer.pulsar.service.ArticleService;
import com.hammer.pulsar.service.InteractionService;
import com.hammer.pulsar.util.MemoryAuthManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity<List<ArticlePreview>> showAllArticles(@RequestBody(required = false) PaginationCriteria criteria) {
        List<ArticlePreview> articleList = articleService.getAllArticles(criteria);

        return new ResponseEntity<>(articleList, HttpStatus.OK);
    }

    // 글 상세보기 API
    @GetMapping("/{articleId}/static")
    public ResponseEntity<Article> showArticleDetail(@PathVariable int articleId) {
        Article article = articleService.getArticle(articleId);

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    // 글 작성하기 API
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Integer> writeArticle(@RequestPart(value = "form") ArticleWriteForm form,
                                                @RequestPart(value = "imgs", required = false) MultipartFile[] imgFiles,
                                                HttpServletRequest request) {
        // 작성자의 회원번호를 조회한다.
        int memberId = MemoryAuthManager.getLoginMember();

        int articleNo = articleService.writeArticle(form, imgFiles, memberId);

        return new ResponseEntity<>(articleNo, HttpStatus.OK);
    }

    // 글 수정하기 API
    @PutMapping(value = "/{articleId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> modifyArticle(@PathVariable int articleId,
                                              @RequestPart(value = "form") ArticleModifyForm form,
                                              @RequestPart(value = "imgs", required = false) MultipartFile[] imgFiles,
                                              HttpServletRequest request) {
        int memberId = MemoryAuthManager.getLoginMember();
        form.setArticleId(articleId);

        articleService.modifyArticle(form, imgFiles, memberId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 글 삭제하기 API
    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> removeArticle(@PathVariable int articleId, HttpServletRequest request) {
        int memberId = MemoryAuthManager.getLoginMember();

        articleService.removeArticle(articleId, memberId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 추천 수 가져오기 API
    @GetMapping("/{articleId}/active/like")
    public ResponseEntity<Like> showLikes(@PathVariable int articleId, HttpServletRequest request) {
        // 추천수를 가져오기 위해 필요한 정보를 담기
        LikeRequest likeRequest = new LikeRequest();
        likeRequest.setArticleId(articleId);

        // 작성자의 회원번호를 조회한다.
        int memberId = MemoryAuthManager.getLoginMember();

        // 해당 게시글의 추천수를 가져오기
        Like likes = interactionService.countAllLikes(likeRequest);

        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    // 추천하기 API
    @PostMapping("/{articleId}/active/like")
    public ResponseEntity<Like> toggleLIkeStatus(@PathVariable int articleId, HttpServletRequest request) {
        // 작성자의 회원번호를 조회한다.
        int memberId = MemoryAuthManager.getLoginMember();

        // 추천하기 위해 필요한 정보를 담기
        LikeRequest likeRequest = new LikeRequest();
        likeRequest.setMemberId(memberId);
        likeRequest.setArticleId(articleId);

        // 추천 상태를 변경하기
        Like likes = interactionService.toggleLike(likeRequest);

        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    // 댓글 가져오기 API
    @GetMapping("/{articleId}/active/comment")
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable int articleId) {
        List<Comment> commentList = interactionService.getAllComments(articleId);

        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    // 댓글 쓰기 API
    @PostMapping("/{articleId}/active/comment")
    public ResponseEntity<List<Comment>> writeComment(@PathVariable int articleId, @RequestBody CommentWriteRequest commentWriteRequest, HttpServletRequest request) {
        // 작성자의 회원번호를 조회한다.
        int memberId = MemoryAuthManager.getLoginMember();

        // 댓글 작성에 필요한 데이터를 DTO에 담기
        CommentWriteRequest writeRequest = new CommentWriteRequest();

        writeRequest.setWriterId(memberId);
        writeRequest.setArticleId(articleId);

        // 댓글을 작성하고 댓글 목록을 다시 가져오기
        List<Comment> commentList = interactionService.writeComment(writeRequest);

        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    // 댓글 삭제 API
    @DeleteMapping("/{articleId}/active/comment/{commentId}")
    public ResponseEntity<List<Comment>> removeComment(@PathVariable int articleId, @PathVariable int commentId, HttpServletRequest request) {
        int memberId = MemoryAuthManager.getLoginMember();

        List<Comment> commentList = interactionService.removeComment(articleId, commentId, memberId);

        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

}
