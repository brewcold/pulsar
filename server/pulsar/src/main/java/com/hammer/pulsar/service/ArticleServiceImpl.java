package com.hammer.pulsar.service;

import com.hammer.pulsar.dao.ArticleDao;
import com.hammer.pulsar.dao.ArticleTagDao;
import com.hammer.pulsar.dto.NotDetermined;
import com.hammer.pulsar.dto.article.Article;
import com.hammer.pulsar.dto.article.ArticlePreview;
import com.hammer.pulsar.dto.article.ArticleWriteForm;
import com.hammer.pulsar.dto.article.ArticleWriteRequest;
import com.hammer.pulsar.dto.common.Tag;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleServiceImpl implements ArticleService {
    private ArticleDao articleDao;
    private ArticleTagDao articleTagDao;

    private FileManagementService fileManagementService;

    /**
     * 사용자가 작성한 게시글 정보에 작성자의 회원번호를 추가한 Request를 만들어 테이블에 정보를 추가하는 메서드
     *
     * @param form
     * @return
     */
    @Override
    public int writeArticle(ArticleWriteForm form, MultipartFile[] imgFiles, int memberId) {
        // 작성자 정보를 Request에 담는다
        ArticleWriteRequest request = new ArticleWriteRequest();

        // 게시글 테이블에 새로운 게시글을 추가한다.
        int articleId = articleDao.insertArticle(request);

        // 첨부된 이미지를 추가한다.
        fileManagementService.uploadArticleImgs(imgFiles, articleId);

        // 선택한 태그를 추가한다.
        articleTagDao.insertArticleTags(form.getTagList()
                .stream()
                .map(Tag::getTagNo)
                .collect(Collectors.toList()));

        return articleId;
    }

    /**
     * 게시글 목록을 모두 조회하는 메서드
     *
     * @return
     */
    @Override
    public List<ArticlePreview> getAllArticles() {
        return articleDao.selectArticles();
    }

    /**
     * 게시글 세부 정보를 조회하는 메서드
     *
     * @param articleId
     * @return
     */
    @Override
    public Article getArticle(int articleId) {
        return articleDao.selectArticleByArticleId(articleId);
    }

    @Override
    public void modifyArticle(NotDetermined request) {

    }

    /**
     * 게시글을 삭제하는 메서드
     *
     * @param articleId
     */
    @Override
    public void removeArticle(int articleId) {
        articleDao.deleteArticle(articleId);
    }
}
