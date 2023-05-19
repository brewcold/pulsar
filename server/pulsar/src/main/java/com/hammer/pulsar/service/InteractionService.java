package com.hammer.pulsar.service;

import com.hammer.pulsar.dto.interaction.Comment;
import com.hammer.pulsar.dto.interaction.CommentWriteRequest;
import com.hammer.pulsar.dto.interaction.Like;
import com.hammer.pulsar.dto.interaction.LikeRequest;

import java.util.List;

// 회원과 게시글의 상호작용 관련 로직을 처리하기 위한 서비스의 인터페이스
// 글 상세보기: ajax 관련 로직
public interface InteractionService {
    // 게시글의 추천수를 조회하는 로직
    public Like countAllLikes(LikeRequest request);

    // 게시글에 추천 / 취소하는 로직
    public Like toggleLike(LikeRequest request);

    // 해당 게시글의 댓글 목록을 조회하는 로직
    public List<Comment> getAllComments(int articleId);

    // 해당 게시글에 댓글을 작성하는 로직
    public List<Comment> writeComment(CommentWriteRequest request);

    // 댓글을 삭제하는 로직
    public List<Comment> removeComment(int articleId, int commentId);

}
