import call from './axiosConfig';

/**
 * ### 이메일 중복을 검사합니다.
 * @param {Object} data
 * @returns `Promise` with CODE (200, 409)
 */
export const postMemberEmailDuplicated = (data) =>
  call(`/member/signup/validation/email`, 'post', data);

/**
 * ### 닉네임 중복을 검사합니다.
 * @param {Object} data
 * @returns `Promise` with CODE (200, 409)
 */
export const postMemberNicknameDuplicated = (data) =>
  call(`/member/signup/validation/nickname`, 'post', data);

/**
 * ### 회원가입을 진행합니다.
 * @param {Object} data
 * @returns `Promise` with CODE (201, 500, 418)
 */
export const postMemberSignUp = (data) =>
  call(`/member/signup`, 'post', data, 'normal_img');

/**
 * ### 로그인을 진행합니다.
 * @param {Object} data
 * @returns `Promise` with CODE (200, 500, 401)
 */
export const postMemberLogIn = (data) =>
  call(`/member/login`, 'post', data);

/**
 * ### 로그아웃을 진행합니다.
 * @returns `Promise` with CODE (200, 500, 418)
 */
export const postMemberLogOut = (token) =>
  call(`/member/logout`, 'post', [], 'auth', token);

/**
 * ### `memberNo`번 유저 프로필 정보를 가져옵니다.
 * @param {number} memberNo
 * @returns `Promise` with CODE (200, 501, 418)
 */
export const getMemberProfile = (memberNo) =>
  call(`/member/${memberNo}`, 'get');

/**
 * ### `memberNo`번 유저 프로필을 수정합니다.
 * @param {number} memberNo
 * @param {Object} data
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const putMemberProfile = (memberNo, data, token) =>
  call(`/member/${memberNo}`, 'put', data, 'auth', token);

/**
 * ### `memberNo`번 유저를 탈퇴시킵니다.
 * @param {number} memberNo
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const deleteMember = (memberNo, data, token) =>
  call(`/member/${memberNo}`, 'post', data, 'auth', token);

/**
 * ### `memberNo`번 유저가 쓴 글을 가져옵니다.
 * @param {*} memberNo
 * @returns `Promise` with CODE (200, 500, 401);
 */
export const getMyArticle = (memberNo) =>
  call(`/member/${memberNo}/history/myarticle`);

/**
 * ### `memberNo`번 유저가 쓴 댓글과 글을 가져옵니다.
 * @param {*} memberNo
 * @returns `Promise` with CODE (200, 500, 401);
 */
export const getMyLikes = (memberNo) =>
  call(`/member/${memberNo}/history/recommended`);

/**
 * ### `memberNo`번 유저가 좋아요를 누른 글을 가져옵니다.
 * @param {*} memberNo
 * @returns `Promise` with CODE (200, 500, 401);
 */
export const getMyComments = (memberNo) =>
  call(`/member/${memberNo}/history/comment`);
