package com.hammer.pulsar.service;

import com.hammer.pulsar.dto.NotDetermined;
import com.hammer.pulsar.dto.article.Comment;
import com.hammer.pulsar.dto.article.Like;

import java.util.List;

// 회원과 게시글의 상호작용 관련 로직을 처리하기 위한 서비스의 인터페이스
// 글 상세보기: ajax 관련 로직
public interface InteractionService {
    // 회원의 해당 게시글 북마크 여부를 확인하는 로직
    public boolean checkBookmarked(int memberId, int articleId);

    // 회원의 북마크를 등록 / 취소하는 로직
    public boolean toggleBookmark(int memberId, int articleId);

    // 게시글의 추천수를 조회하는 로직
    public Like countAllLikes(int articleId);

    // 게시글에 추천 / 취소하는 로직
    public Like toggleLike(int memberId, int articleId);

    // 해당 게시글의 댓글 목록을 조회하는 로직
    public List<Comment> getAllComments(int articleId);

    // 해당 게시글에 댓글을 작성하는 로직
    public List<Comment> writeComment(NotDetermined request);

    // 댓글을 삭제하는 로직
    public List<Comment> removeComment(int commentId);

}
