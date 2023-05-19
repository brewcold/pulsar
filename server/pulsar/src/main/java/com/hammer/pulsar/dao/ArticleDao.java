package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.article.Article;
import com.hammer.pulsar.dto.article.ArticlePreview;
import com.hammer.pulsar.dto.article.ArticleWriteRequest;

import java.util.List;

// 게시글 정보를 저장하는 Article 테이블과 통신하는 DAO
public interface ArticleDao {
    // 게시글을 작성하는 메서드
    public int insertArticle(ArticleWriteRequest request);

    // 게시글 목록을 조회하는 메서드
    public List<ArticlePreview> selectArticles();

    // 선택한 게시글을 조회하는 메서드
    public Article selectArticleByArticleId(int articleId);

    // 선택한 회원의 게시글 목록을 조회하는 메서드
    public List<ArticlePreview> selectArticleByMemberId(int memberId);

    // 검색 조건에 따라 게시글 목록을 조회하는 메서드

    // 선택한 게시글을 수정하는 메서드
    public int updateArticle(Article article);

    // 선택한 게시글을 삭제하는 메서드
    public int deleteArticle(int articleId);

    // 선택한 게시글의 추천수를 1 증가시키는 메서드
    public void addLikes(int articleId);

    // 선택한 게시글의 추천수를 1 감소시키는 메서드
    public void subtractLikes(int articleId);

}
