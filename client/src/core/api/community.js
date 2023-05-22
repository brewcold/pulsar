import call from './axiosConfig';

/**
 * ### 게시판의 글 리스트를 10개씩 조회합니다.
 * @returns `Promise` with CODE(200, 500)
 * */
export const getArticleList = () => call('/community');

/**
 * ### `articleNo`번 글의 상세 정보를 리턴합니다.
 * @param {number} articleNo
 * @returns `Promise` with CODE(200, 500, 404)
 */
export const getArticleDetail = (articleNo) =>
  call(`/community/${articleNo}/static`); //글 상세보기 - static datas

/**
 * ### 글을 씁니다
 * @param {number} articleNo
 * @param {Object} data
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const postArticle = (data) =>
  call(`/community`, 'post', data, 'auth_img', sessionId); //글 수정하기

/**
 * ### `articleNo`번 글을 수정합니다.
 * @param {number} articleNo
 * @param {Object} data
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const putArticle = (articleNo, data) =>
  call(`/community/${articleNo}`, 'put', data, 'auth_img', sessionId); //글 수정하기

/**
 * ### `articleNo`번 글을 삭제합니다.
 * @param {number} articleNo
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const deleteArticle = (articleNo) =>
  call(`/community/${articleNo}`, 'delete', [], 'auth', sessionId); //글 삭제하기

/**
 * ### `articleNo`번 글의 좋아요 여부 및 개수를 확인합니다.
 * @param {number} articleNo
 * @returns `Promise` with CODE (200, 500, 404)
 */
export const getArticleLike = (articleNo) =>
  call(`/community/${articleNo}/active/like`); //

/**
 * ### `articleNo`번 글에 좋아요가 되어있다면 좋아요를 취소, 그렇지 않다면 좋아요 처리합니다.
 * @param {number} articleNo
 * @returns `Promise` with CODE (200, 500, 404, 401)
 */
export const postArticleLike = (articleNo) => {
  call(
    `/community/${articleNo}/active/like`,
    'post',
    [],
    'auth',
    sessionId
  );
};

/**
 * ### `articleNo`번 글의 댓글을 모두 가져옵니다.
 * @param {number} articleNo
 * @returns `Promise` with CODE (200, 500, 404)
 */
export const getArticleComment = (articleNo) =>
  call(
    `/community/${articleNo}/active/comment`,
    'get',
    [],
    'auth',
    sessionId
  ); //글 상세보기 - active data - 댓글 가져오기

/**
 * ### `articleNo`번 글에 댓글을 작성합니다.
 * @param {number} articleNo
 * @param {Object} data
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const postArticleComment = (articleNo, data) =>
  call(
    `/community/${articleNo}/active/comment`,
    'post',
    data,
    'auth',
    sessionId
  );

/**
 * ### `articleNo`번 글의 `commentNo`번 댓글을 삭제합니다.
 * @param {number} articleNo
 * @param {number} commentNo
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const deleteArticleComment = (articleNo, commentNo) =>
  call(
    `/community/${articleNo}/active/comment/${commentNo}`,
    'delete',
    [],
    'auth',
    sessionId
  );
