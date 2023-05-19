package com.hammer.pulsar.dao;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

// 게시글에 추가된 태그를 저장하는 ArticleTag 테이블과 통신하기 위한 DAO
public interface ArticleTagDao {
    // 선택된 게시글의 태그 목록을 불러오기 위한 메서드
    public List<Tag> selectTagByArticleId(int articleId);

    // 선택한 게시글에 태그를 추가하는 메서드
    public void insertArticleTags(List<Integer> tagsId);

}
