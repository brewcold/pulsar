import call from './axiosConfig';

/**
 * ### `memberNo`번 유저의 모든 루틴을 가져옵니다.
 * @param {number} memberNo
 * @returns Promise with CODE (200, 500, 401)
 */
export const getRoutines = (memberNo) =>
  call(`/routines/${memberNo}`, 'get', [], 'auth');

/**
 * ### `routineNo`번 루틴의 상세 정보를 가져옵니다.
 * @param {number} routineNo
 * @returns Promise with CODE (200, 500, 401)
 */
export const getRoutineDetail = (routineNo) =>
  call(`/routines/routine/${routineNo}`, 'get', [], 'auth');

/**
 * ### 루틴을 작성합니다.
 * @param {Object} data
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const postRoutine = (data) =>
  call(`/routines/routine`, 'post', data, 'auth');

/**
 * ### `routineNo`번 루틴을 수정합니다. 또는, 루틴에 운동 리스트를 추가합니다.
 * @param {Object} data
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const putRoutine = (routineNo, data) =>
  call(`/routines/routine/${routineNo}`, 'put', data, 'auth');

/**
 * ### `routineNo`번 루틴을 삭제합니다.
 * @param {number} routineNo
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const deleteRoutine = (routineNo) =>
  call(`/routines/routine/${routineNo}`, 'delete', [], 'auth');
