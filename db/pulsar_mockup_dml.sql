### MOCKUP 데이터
DROP TABLE IF EXISTS MOCKUP;
CREATE TABLE MOCKUP (
	ID INT PRIMARY KEY AUTO_INCREMENT,
    A_TITLE TEXT,
    A_CONTENT TEXT,
    `COMMENT` TEXT
);

INSERT INTO MOCKUP (A_TITLE, A_CONTENT, COMMENT)
VALUES ('안녕하세요', '처음입니다', '직접 알아보세요'),
		('자세가 고민이에요', '자꾸 무게중심이 뒤로 쏠려서 넘어질 것 같은데 어떻게 해결할까요', '저도 궁금합니다'),
		('루틴 계획좀 봐주세요', '팔굽혀펴기가 어쩌고 스쿼트가 저쩌고', '이런 글 쓸 시간에 덤벨 한 번 더 드십쇼'),
		('식단좀 봐주세요', '체지방 17%고 다이어트중인데 식단 어떻게 해야할까요? 매일 풀만 먹으니까 힘든데 부탁드립니다.', '밥 잘 챙겨드세요'),
		('헬린이 20일차 눈바디 결과', '이제 안해도 될 듯? ㅋㅋ', '저도 모릅니다'),
		('필라테스 학원 추천좀 해주세요', '지역은 강남입니다. 역삼도 괜찮아요', '미리 감사합니다'),
		('집에서 맨몸운동', '참고할만한 영상 있을까요', '유튜브 찾아보세요'),
		('운동 유튜브 추천좀요', '직장인인데 퇴근 후 간단하게라도 하려고 합니다', '이런건 어떠신가요? 어쩌고 저쩌고'),
		('닭가슴살 어디가 맛있나요', '처음 시도하는데 안물리는 곳 알려주세요', '저도 찾는 중인데 정보 공유좀요'),
		('오늘의 하체운동', '은 거릅니다', '회원님?'),
		('챗지피티가 알려준 운동법', '하지말라고 합니다', '득근하십쇼'),
		('매일 점심 20층 올라가기', '어떤가요', '건강 챙기면서 하세요'),
		('PT비용좀 봐주세요', '처음이라 그런데 50회 200만원인데 이정도면 괜찮나요', '그렇군요');


-- 임시 회원 데이터 추가
INSERT INTO TB_MEMBER (EMAIL, PASSWORD, NICKNAME)
VALUES ('test1@test.com', 'test1234!', '테스트1'),
    ('test2@test.com', 'test1234!', '테스트2'),
    ('test3@test.com', 'test1234!', '테스트3'),
    ('test4@test.com', 'test1234!', '테스트4'),
    ('test5@test.com', 'test1234!', '테스트5'),
    ('test6@test.com', 'test1234!', '테스트6'),
    ('test7@test.com', 'test1234!', '테스트7'),
    ('test8@test.com', 'test1234!', '테스트8'),
    ('test9@test.com', 'test1234!', '테스트9'),
    ('test11@test.com', 'test1234!', '테스트10');
    

-- 임시 태그
INSERT INTO TB_TAG_INFO
VALUES (1, '체중감량'),
    (2, '자세'),
    (3, '식단'),
    (4, '지구력'),
    (5, '체지방'),
    (6, '근육'),
    (7, '실천'),
    (8, '목표설정'),
    (9, '운동방식'),
    (10, '헬스장'),
    (11, '요가'),
    (12, '필라테스'),
    (13, '헬스'),
    (14, '부상'),
    (15, '건강'),
    (16, '동기부여'),
    (17, '시간'),
    (18, '헬린이'),
    (19, '고인물'),
    (20, '바디프로필'),
    (21, '근력'),
    (22, '균형'),
    (23, '유연성'),
    (24, '꿀팁');

-- 임시 운동
INSERT INTO TB_EXERCISE
VALUES (1, '상체운동'),
    (2, '하체운동'),
    (3, '복근운동'),
    (4, '요가'),
    (5, '필라테스'),
    (6, '등운동'),
    (7, '이두운동'),
    (8, '삼두운동'),
    (9, '어깨운동'),
    (10, '가슴운동'),
    (11, '다리운동'),
    (12, '스트레칭'),
    (13, '맨몸운동'),
    (14, '유산소운동'),
    (15, '명상'),
    (16, '휴식');
    
### 임시 고민태그 등록
DROP PROCEDURE IF EXISTS INSERT_CONCERNS;
DELIMITER $$
CREATE PROCEDURE INSERT_CONCERNS()
BEGIN
	DECLARE X INT;
    SET X = 1;
    
    WHILE X <= 10 DO
		INSERT INTO TB_CONCERN_TAG
        VALUES (X, (SELECT FLOOR(RAND() * 23 + 1)));
		SET X = X+1; 
	END WHILE;
END $$
DELIMITER ;

CALL INSERT_CONCERNS();

INSERT INTO TB_CONCERN_TAG
VALUES (1, 2), (2, 3), (2, 4), (2, 6), (3, 1), (4, 4), (5, 1), (6, 4);

SELECT * FROM TB_CONCERN_TAG ORDER BY MEMBER_ID;

### 시연용 게시글 데이터 추가
DROP PROCEDURE IF EXISTS INSERT_ARTICLES;
DELIMITER $$
CREATE PROCEDURE INSERT_ARTICLES()
BEGIN
	DECLARE X INT;
    DECLARE R INT;
    SET X = 1;
    
    WHILE X <= 100 DO
		SET R = FLOOR(RAND() * 12) + 1;
		INSERT INTO TB_ARTICLE (TITLE, WRITER_ID, CONTENT, LIKE_CNT, VIEW_CNT)
		VALUES ((SELECT A_TITLE FROM MOCKUP WHERE ID = R),
					FLOOR(RAND() * 9) + 1, 
				(SELECT A_CONTENT FROM MOCKUP WHERE ID = R),
				  FLOOR(RAND() * 100), 
                  FLOOR(RAND() * 100) + 200);
		SET X = X+1; 
	END WHILE;
END $$
DELIMITER ;

CALL INSERT_ARTICLES();

SELECT * FROM TB_ARTICLE ORDER BY ID DESC;

### 임시 게시글태그 등록
DROP PROCEDURE IF EXISTS INSERT_ARTICLE_TAGS;
DELIMITER $$
CREATE PROCEDURE INSERT_ARTICLE_TAGS()
BEGIN
	DECLARE X INT;
    SET X = 1;
    
    WHILE X <= 100 DO
		INSERT INTO TB_ARTICLE_TAG
        VALUES (X, (SELECT FLOOR(RAND() * 23 + 1)));
		SET X = X+1; 
	END WHILE;
END $$
DELIMITER ;

CALL INSERT_ARTICLE_TAGS();

INSERT INTO TB_ARTICLE_TAG
VALUES (100, 2), (92, 3), (82, 4), (72, 6), (93, 1), (94, 4), (95, 1), (86, 4);

SELECT * FROM TB_ARTICLE_TAG ORDER BY ARTILCE_ID;

### 시연용 댓글 데이터 추가
DROP PROCEDURE IF EXISTS INSERT_COMMENTS;
DELIMITER $$
CREATE PROCEDURE INSERT_COMMENTS()
BEGIN
	DECLARE X INT;
    DECLARE R INT;
    SET X = 1;
    
    WHILE X <= 200 DO
		SET R = FLOOR(RAND() * 12) + 1;
		INSERT INTO TB_ARTICLE (WRITER_ID, CONTENT, ARTICLE_ID)
		VALUES (FLOOR(RAND() * 9) + 1,
				(SELECT COMMENT FROM MOCKUP WHERE ID = R),
				  FLOOR(RAND() * 100));
		SET X = X+1; 
	END WHILE;
END $$
DELIMITER ;

CALL INSERT_COMMENTS();

SELECT * FROM TB_ARTICLE ORDER BY ID DESC;

-- 임시 댓글
INSERT INTO TB_COMMENT (ARTICLE_ID, WRITER_ID, CONTENT)
VALUES (100, 2, '내용1입니다'),
    (91, 6, '내용2입니다'),
    (92, 3, '내용3입니다'),
    (83, 4, '내용4입니다'),
    (93, 5, '내용5입니다'),
    (94, 3, '내용6입니다');

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