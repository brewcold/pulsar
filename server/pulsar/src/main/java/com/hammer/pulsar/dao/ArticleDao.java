package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.article.*;

import java.util.List;

// 게시글 정보를 저장하는 Article 테이블과 통신하는 DAO
public interface ArticleDao {
    // 게시글을 작성하는 메서드
    public int insertArticle(ArticleWriteRequest request);

    // 게시글 목록을 조회하는 메서드
    public List<ArticlePreview> selectArticles(PaginationCriteria criteria);

    // 선택한 게시글을 조회하는 메서드
    public Article selectArticleByArticleId(int articleId);

    // 선택한 게시글들을 조회하는 메서드
    public List<ArticlePreview> selectArticlesByArticleId(List<Integer> articlesId);

    // 선택한 회원의 게시글 목록을 조회하는 메서드
    public List<ArticlePreview> selectArticleByMemberId(int memberId);

    // 선택한 게시글의 추천수를 조회하는 메서드
    public int countLikes(int articleId);

    // 선택한 게시글을 수정하는 메서드
    public int updateArticle(ArticleModifyRequest request);

    // 선택한 게시글을 삭제하는 메서드
    public int deleteArticle(int articleId);

    // 선택한 게시글의 추천수를 1 증가시키는 메서드
    public void addLikes(int articleId);

    // 선택한 게시글의 추천수를 1 감소시키는 메서드
    public void subtractLikes(int articleId);

    // 선택한 게시글의 조회수를 1 증가시키는 메서드
    public void updateViewCnt(int articleId);

}
