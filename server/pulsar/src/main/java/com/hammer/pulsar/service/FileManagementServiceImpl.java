package com.hammer.pulsar.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

// 실제 로직이 구현된 FileManagementService 인터페이스의 구현체 클래스
@Service
public class FileManagementServiceImpl implements FileManagementService {
    @Override
    public String uploadMemberProfileImg(MultipartFile imgFile) {
        return null;
    }

    @Override
    public void uploadArticleImgs(MultipartFile[] imgFiles, int articleId) {

    }

}
