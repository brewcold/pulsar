-- 0. 사전 작업
-- SCHEMA 초기화
DROP SCHEMA IF EXISTS PULSAR;
CREATE SCHEMA PULSAR;
USE PULSAR;

-- 1. 회원 테이블을 생성
CREATE TABLE TB_MEMBER(
    -- 일련번호, 이메일, 비밀번호, 닉네임, 프로필 이미지, 등록일
    ID INT PRIMARY KEY AUTO_INCREMENT,    -- 기본키
    EMAIL VARCHAR(256) UNIQUE NOT NULL,
    PASSWORD VARCHAR(256) NOT NULL,
    NICKNAME VARCHAR(12) UNIQUE NOT NULL,
    SRC VARCHAR(256),
    REG_DATE TIMESTAMP DEFAULT NOW()
);

-- 9. 루틴 테이블
CREATE TABLE TB_ROUTINE(
    -- 일련번호, 회원 일련번호, 이름, 반복 단위, 반복 주기, 시작 시간, 시작 분
    ID INT PRIMARY KEY AUTO_INCREMENT,
    MEMBER_ID INT NOT NULL,
    TITLE VARCHAR(20),
    REPEAT_UNIT VARCHAR(20),
    REPEAT_PERIOD INT,
    START_HOUR INT,
    START_MIN INT,
    /*    MEMBER_ID는 회원의 일련번호를 참조하는 참조키
        게시글이 삭제되면 같이 삭제됨 */
    FOREIGN KEY (MEMBER_ID) REFERENCES TB_MEMBER (ID)
    ON DELETE CASCADE
);

-- 2. 게시글 테이블 생성
CREATE TABLE TB_ARTICLE(
    -- 일련번호, 제목, 작성자 일련번호, 내용, 조회수, 작성일, 수정일
    ID INT PRIMARY KEY AUTO_INCREMENT,    -- 기본키
    TITLE VARCHAR(256) NOT NULL,
    WRITER_ID INT NOT NULL,
    CONTENT TEXT NOT NULL,
    ROUTINE_ID INT,
    VIEW_CNT INT DEFAULT 0,
    LIKE_CNT INT DEFAULT 0,
    REG_DATE TIMESTAMP DEFAULT NOW(),
    MODIFY_DATE TIMESTAMP,
    /*    MEMBER_ID는 회원의 일련번호를 참조하는 참조키
        게시글이 삭제되면 같이 삭제됨 */
    FOREIGN KEY (WRITER_ID) REFERENCES TB_MEMBER (ID)
    ON DELETE CASCADE,
    FOREIGN KEY (ROUTINE_ID) REFERENCES TB_ROUTINE (ID)
    ON DELETE CASCADE
);

-- 3. 댓글 테이블
CREATE TABLE TB_COMMENT(
    -- 일련번호, 글 일련번호, 작성자 일련번호, 내용, 작성일
    ID INT PRIMARY KEY AUTO_INCREMENT,    -- 기본키 
    ARTICLE_ID INT NOT NULL,
    WRITER_ID INT NOT NULL,
    CONTENT TEXT NOT NULL,
    REG_DATE TIMESTAMP DEFAULT NOW(),
    /*    ARTICLE_ID는 게시글의 일련번호를 참조하는 참조키
        게시글이 삭제되면 같이 삭제됨 */
    FOREIGN KEY (ARTICLE_ID) REFERENCES TB_ARTICLE (ID)
    ON DELETE CASCADE,
    -- MEMBER_ID는 회원의 일련번호를 참조하는 참조키
    FOREIGN KEY (WRITER_ID) REFERENCES TB_MEMBER (ID)
    ON DELETE CASCADE
);

-- 4. 게시글 이미지 테이블
CREATE TABLE TB_IMG(
    -- 일련번호, 글 일련번호, 첨부된 이미지 경로
    ID INT PRIMARY KEY AUTO_INCREMENT,    -- 기본키
    ARTICLE_ID INT NOT NULL,
    SRC VARCHAR(256) NOT NULL,
    /*    ARTICLE_ID는 게시글의 일련번호를 참조하는 참조키
        게시글이 삭제되면 같이 삭제됨 */
    FOREIGN KEY (ARTICLE_ID) REFERENCES TB_ARTICLE (ID)
    ON DELETE CASCADE
);

-- 5. 추천 테이블
CREATE TABLE TB_LIKE(
    -- 게시글 일련번호, 회원 일련번호
    ARTICLE_ID INT NOT NULL,
    MEMBER_ID INT NOT NULL,
    -- 기본키 = (게시글 일련번호, 회원 일련번호)
    PRIMARY KEY (ARTICLE_ID, MEMBER_ID),
    /*    ARTICLE_ID는 게시글의 일련번호를 참조하는 참조키
        게시글이 삭제되면 같이 삭제됨 /
    FOREIGN KEY (ARTICLE_ID) REFERENCES TB_ARTICLE (ID)
    ON DELETE CASCADE,
    /    MEMBER_ID는 회원의 일련번호를 참조하는 참조키
        게시글이 삭제되면 같이 삭제됨 */
    FOREIGN KEY (MEMBER_ID) REFERENCES TB_MEMBER (ID)
    ON DELETE CASCADE,
    FOREIGN KEY (ARTICLE_ID) REFERENCES TB_ARTICLE (ID)
    ON DELETE CASCADE
);

-- 6. 태그 테이블
CREATE TABLE TB_TAG_INFO(
    -- 일련번호, 태그명
    ID INT PRIMARY KEY AUTO_INCREMENT,
    TAG_NAME VARCHAR(20)
); 

-- 7. 게시글 태그 테이블
CREATE TABLE TB_ARTICLE_TAG(
    -- 게시글 일련번호, 태그 일련번호
    ARTICLE_ID INT NOT NULL,
    TAG_ID INT NOT NULL,
    -- 고유키 = (게시글 일련번호, 태그 일련번호)
    PRIMARY KEY (ARTICLE_ID, TAG_ID),
    /*    ARTICLE_ID는 게시글의 일련번호를 참조하는 참조키
        게시글이 삭제되면 같이 삭제됨 /
    FOREIGN KEY (ARTICLE_ID) REFERENCES TB_ARTICLE (ID)
    ON DELETE CASCADE,
    /    TAG_ID는 태그의 일련번호를 참조하는 참조키
        태그가 삭제되거나 변경되면 같이 변경됨 */
    FOREIGN KEY (TAG_ID) REFERENCES TB_TAG_INFO (ID)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY (ARTICLE_ID) REFERENCES TB_ARTICLE (ID)
    ON DELETE CASCADE
); 

-- 8. 고민 태그 테이블
CREATE TABLE TB_CONCERN_TAG(
    -- 회원 일련번호, 고민으로 설정한 태그 일련번호
    MEMBER_ID INT NOT NULL,
    TAG_ID INT NOT NULL,
    -- 고유키 = (회원 일련번호, 태그 일련번호)
    PRIMARY KEY (MEMBER_ID, TAG_ID),
    /*    MEMBER_ID는 게시글의 일련번호를 참조하는 참조키
        게시글이 삭제되면 같이 삭제됨 /
    FOREIGN KEY (MEMBER_ID) REFERENCES TB_MEMBER (ID)
    ON DELETE CASCADE,
    /    TAG_ID는 태그의 일련번호를 참조하는 참조키
        태그가 삭제되거나 변경되면 같이 변경됨 */
    FOREIGN KEY (TAG_ID) REFERENCES TB_TAG_INFO (ID)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY (MEMBER_ID) REFERENCES TB_MEMBER (ID)
    ON DELETE CASCADE
); 

-- 10. 운동 테이블
CREATE TABLE TB_EXERCISE(
    -- 운동 일련번호, 운동 이름
    ID INT PRIMARY KEY,
    EXERCISE_NAME VARCHAR(20)
);

-- 11. 루틴 세부 계획 테이블
CREATE TABLE TB_ROUTINE_DETAIL(
    -- 일련번호, 루틴 일련번호, 운동 순서, 운동 이름, 운동 시간, 운동 횟수
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ROUTINE_ID INT NOT NULL,
    EXERCISE_ORDER INT,
    EXERCISE_ID INT,
    DURATION INT,
    COUNT INT,
    /*    ROUTINE_ID는 회원의 일련번호를 참조하는 참조키
        게시글이 삭제되면 같이 삭제됨 /
    FOREIGN KEY (ROUTINE_ID) REFERENCES TB_ROUTINE (ID)
    ON DELETE CASCADE,
    /    EXERCISE_ID는 운동의 일련번호를 참조하는 참조키
        운동 테이블이 변경되거나 삭제되면 같이 변경됨
    */
    FOREIGN KEY (EXERCISE_ID) REFERENCES TB_EXERCISE (ID)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY (ROUTINE_ID) REFERENCES TB_ROUTINE (ID)
    ON DELETE CASCADE
); 

-- 12. 활동 기록 테이블 (우선순위 낮음)
/*
    보류
    회원이 연속으로 했는지를 루틴마다 체크할건지
    아니면 루틴 안가리고 하나라도 했으면 될건지
*/
CREATE TABLE TB_HISTORY(
    -- 활동일
    YEAR INT,
    MONTH INT,
    DAY INT,
    MEMBER_ID INT,
    FOREIGN KEY (MEMBER_ID) REFERENCES TB_MEMBER (ID)
    ON DELETE CASCADE
);

CREATE TABLE TB_DAY(
    -- 루틴 고유번호, 월, 화, 수, 목, 금, 토, 일 운동여부
    ROUTINE_ID INT PRIMARY KEY,
    MON BOOLEAN DEFAULT FALSE,
    TUE BOOLEAN DEFAULT FALSE,
    WED BOOLEAN DEFAULT FALSE,
    THU BOOLEAN DEFAULT FALSE,
    FRI BOOLEAN DEFAULT FALSE,
    SAT BOOLEAN DEFAULT FALSE,
    SUN BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (ROUTINE_ID) REFERENCES TB_ROUTINE (ID)
    ON DELETE CASCADE
);