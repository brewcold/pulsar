package com.hammer.pulsar.dao;

import java.util.List;

// 북마크 정보를 저장하는 Bookmark 테이블과 통신하는 DAO
public interface BookmarkDao {
    // 회원이 선택한 게시글에 북마크를 추가하는 메서드
    public int insertBookmark(int articleId, int memberId);

    // 회원이 선택한 게시글에 북마크를 했는지 조회하는 메서드
    public boolean selectBookmark(int articleId, int memberId);

    // 회원이 북마크한 게시글 번호 목록을 조회하는 메서드
    public List<Integer> selectBookmarkedByMemberId(int memberId);

    // 회원이 선택한 게시글에 북마크를 삭제하는 메서드
    public int deleteBookmark(int articleId, int memberId);
}