package com.hammer.pulsar.service;

import com.hammer.pulsar.dao.ArticleDao;
import com.hammer.pulsar.dao.LikeDao;
import com.hammer.pulsar.dto.NotDetermined;
import com.hammer.pulsar.dto.article.Comment;
import com.hammer.pulsar.dto.article.Like;
import com.hammer.pulsar.dto.article.LikeRequest;

import java.util.List;

public class InteractionServiceImpl implements InteractionService {
    private LikeDao likeDao;
    private ArticleDao articleDao;

    /**
     * 게시글의 총 추천수와 회원의 추천 여부를 반환하는 메서드
     *
     * @param articleId
     * @return
     */
    @Override
    public Like countAllLikes(LikeRequest request) {
        Like result = new Like();

        // 추천 여부 불러오기
        result.setLiked(likeDao.selectLikeByMemberId(request));
        // 총 추천수 불러오기
        result.setLikes(likeDao.selectLikes(request.getArticleId()));

        return result;
    }

    /**
     * 회원의 추천 상태를 확인한 후, 추천 상태를 반대로 바꾼다
     * 게시글의 추천수를 변경한다.
     *
     * @param request
     * @return
     */
    @Override
    public Like toggleLike(LikeRequest request) {
        Like result = new Like();

        // 추천 여부 불러오기
        boolean liked = likeDao.selectLikeByMemberId(request);

        // 추천 상태 토글하고 결과 반환
        result.setLiked(toggleStatus(request, liked));
        result.setLikes(likeDao.selectLikes(request.getArticleId()));

        return result;
    }

    /**
     * 현재 회원의 추천 여부를 토글하고 결과를 반환하는 메서드
     *
     * @param request
     * @param liked
     * @return
     */
    private boolean toggleStatus(LikeRequest request, boolean liked) {
        if(liked) {
            likeDao.deleteLike(request);
            articleDao.subtractLikes(request.getArticleId());

            return false;
        } else {
            likeDao.insertLike(request);
            articleDao.addLikes(request.getArticleId());

            return true;
        }
    }

    @Override
    public List<Comment> getAllComments(int articleId) {
        return null;
    }

    @Override
    public List<Comment> writeComment(NotDetermined request) {
        return null;
    }

    @Override
    public List<Comment> removeComment(int commentId) {
        return null;
    }
}
