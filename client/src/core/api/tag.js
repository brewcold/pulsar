import call from './axiosConfig';

/**
 * ### 전체 태그 목록을 가져옵니다.
 * @returns `Promise` with CODE(200, 500)
 */
export const getTag = () => call(`/tag`);
