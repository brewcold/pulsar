package com.hammer.pulsar.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// 파일 입출력을 위한 서비스 인터페이스
public interface FileManagementService {

    // 회원 프로필 이미지 파일을 저장하고 저장된 경로를 반환하는 메서드
    public String uploadMemberProfileImg(MultipartFile imgFile);

    // 게시글에 이미지를 첨부하고 저장된 경로들을 반환하는 메서드
    public void uploadArticleImgs(MultipartFile[] imgFiles, int articleId);
}
