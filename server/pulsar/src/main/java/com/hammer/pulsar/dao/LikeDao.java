package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.article.ArticlePreview;
import com.hammer.pulsar.dto.interaction.LikeRequest;

import java.util.List;

// 추천 정보를 저장하고 있는 Like 테이블과 통신하는 DAO
public interface LikeDao {
    // 선택한 게시글의 추천수를 조회하는 메서드
    public int selectLikes(int articleId);

    // 회원이 선택한 게시글에 추천한 적있는지 조회하는 메서드
    public boolean selectLikeByMemberId(LikeRequest request);

    // 회원이 추천한 게시글 미리보기 목록을 조회하는 메서드
    public List<ArticlePreview> selectLikedByMemberId(int memberId);

    // 회원이 선택한 게시글에 추천을 추가하는 메서드
    public boolean insertLike(LikeRequest request);

    // 회원이 선택한 게시글에 추천을 삭제하는 메서드
    public boolean deleteLike(LikeRequest request);
}
