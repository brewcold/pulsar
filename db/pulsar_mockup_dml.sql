### MOCKUP 데이터
-- 임시 회원 데이터 추가
INSERT INTO TB_MEMBER (EMAIL, PASSWORD, NICKNAME)
VALUES ('test1@test.com', 'test1234!', '테스트1'),
    ('test2@test.com', 'test1234!', '테스트2'),
    ('test3@test.com', 'test1234!', '테스트3'),
    ('test4@test.com', 'test1234!', '테스트4'),
    ('test5@test.com', 'test1234!', '테스트5'),
    ('test6@test.com', 'test1234!', '테스트6');

-- 임시 게시글 데이터 추가
INSERT INTO TB_ARTICLE (TITLE, WRITER_ID, CONTENT, LIKE_CNT, VIEW_CNT)
VALUES ('제목1입니다', 2, '내용1입니다', 2, 4),
    ('제목2입니다', 6, '내용2입니다', 0, 0),
    ('제목3입니다', 3, '내용3입니다', 1, 10),
    ('제목4입니다', 4, '내용4입니다', 1, 5),
    ('제목5입니다', 5, '내용5입니다', 1, 30),
    ('제목6입니다', 3, '내용6입니다', 1, 1);

-- 임시 추천
INSERT INTO TB_LIKE
VALUES (1, 4),
    (1, 3),
    (3, 4),
    (4, 6),
    (5, 6),
    (6, 6);

-- 임시 태그
INSERT INTO TB_TAG_INFO
VALUES (1, '체중'),
    (2, '운동'),
    (3, '요가'),
    (4, '헬스'),
    (5, '근육'),
    (6, '필라테스');

-- 임시 운동
INSERT INTO TB_EXERCISE
VALUES (1, '상체'),
    (2, '하체'),
    (3, '복근'),
    (4, '요가'),
    (5, '필라테스'),
    (6, '등');

-- 임시 게시글 태그
INSERT INTO TB_ARTICLE_TAG
VALUES (1, 2), (2, 3), (2, 4), (2, 6), (3, 1), (4, 4), (5, 1), (6, 4);

-- 임시 고민 태그
INSERT INTO TB_CONCERN_TAG
VALUES (1, 2), (2, 3), (2, 4), (2, 6), (3, 1), (4, 4), (5, 1), (6, 4);

-- 임시 댓글
INSERT INTO TB_COMMENT (ARTICLE_ID, WRITER_ID, CONTENT)
VALUES (1, 2, '내용1입니다'),
    (1, 6, '내용2입니다'),
    (2, 3, '내용3입니다'),
    (3, 4, '내용4입니다'),
    (3, 5, '내용5입니다'),
    (4, 3, '내용6입니다');

-- 임시 루틴
INSERT INTO TB_ROUTINE (MEMBER_ID, TITLE, REPEAT_UNIT, REPEAT_PERIOD, START_HOUR, START_MIN)
VALUES (1, '힘든루틴1', 'WEEK', 2, 12, 30),
    (1, '힘든루틴2', 'WEEK', 1, 10, 30),
    (3, '힘든루틴3', 'DAY', 2, 12, 30),
    (4, '힘든루틴4', 'MONTH', 1, 12, 30),
    (6, '힘든루틴5', 'WEEK', 2, 12, 30);

-- 임시 세부 계획
INSERT INTO TB_ROUTINE_DETAIL (ROUTINE_ID, EXERCISE_ID, EXERCISE_ORDER, DURATION, COUNT)
VALUES (1, 1, 1, 10, 10),
    (1, 2, 3, 10, 15),
    (1, 4, 2, 10, 15),
    (2, 2, 1, 10, 10),
    (2, 5, 1, 10, 15),
    (3, 3, 1, 10, 20),
    (4, 2, 1, 10, 30);

-- 임시 루틴요일 정보
INSERT INTO TB_DAY
VALUES (1, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE, FALSE),
    (2, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE, FALSE),
    (3, FALSE, TRUE, TRUE, TRUE, FALSE, TRUE, FALSE),
    (4, FALSE, FALSE, FALSE, FALSE, FALSE, TRUE, FALSE),
    (5, FALSE, TRUE, FALSE, FALSE, FALSE, TRUE, FALSE);

