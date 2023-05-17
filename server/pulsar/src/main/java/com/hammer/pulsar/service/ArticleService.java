package com.hammer.pulsar.service;

import com.hammer.pulsar.dto.NotDetermined;
import com.hammer.pulsar.dto.article.Article;
import com.hammer.pulsar.dto.article.ArticlePreview;

import java.util.List;

// 게시판 관련 로직을 처리할 서비스의 인터페이스
// 게시판, 글 상세보기: static 관련 로직
public interface ArticleService {
    // 게시글을 작성하는 로직
    public int writeArticle(NotDetermined request);

    // 게시판에 등록된 글 목록을 보여주는 로직
    public List<ArticlePreview> getAllArticles();

    // 선택한 게시글의 상세 정보를 보여주는 로직
    public Article getArticle(int articleId);

    // 검색 조건에 일치하는 게시글 목록을 보여주는 로직
    public List<ArticlePreview> searchArticles(NotDetermined searchCondition);

    // 선택한 게시글을 수정하는 로직
    public void modifyArticle(NotDetermined request);

    // 선택한 게시글을 삭제하는 로직
    public void removeArticle(int articleId);

}
