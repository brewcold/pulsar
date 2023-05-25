import call from './axiosConfig';

/**
 * ### `memberNo`번 유저의 모든 루틴을 가져옵니다.
 * @param {number} memberNo
 * @returns Promise with CODE (200, 500, 401)
 */
export const getRoutines = (memberNo, token) =>
  call(`/routines/${memberNo}`, 'get', [], 'auth', token);
// call(`/routines`, 'get', [], 'auth', token);
/**
 * ### `routineNo`번 루틴의 상세 정보를 가져옵니다.
 * @param {number} routineNo
 * @returns Promise with CODE (200, 500, 401)
 */
export const getRoutineDetail = (routineNo, token) =>
  call(`/routines/routine/${routineNo}`, 'get', [], 'auth', token);

/**
 * ### 루틴을 작성합니다.
 * @param {Object} data
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const postRoutine = (data, token) =>
  call(`/routines/routine`, 'post', data, 'auth', token);

/**
 * ### `routineNo`번 루틴을 수정합니다. 또는, 루틴에 운동 리스트를 추가합니다.
 * @param {Object} data
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const putRoutine = (routineNo, data, token) =>
  call(`/routines/routine/${routineNo}`, 'put', data, 'auth', token);

/**
 * ### `routineNo`번 루틴을 삭제합니다.
 * @param {number} routineNo
 * @returns `Promise` with CODE (200, 500, 401, 418)
 */
export const deleteRoutine = (routineNo, token) =>
  call(`/routines/routine/${routineNo}`, 'delete', [], 'auth', token);
