//state의 값을 가져옵니다.
export default {
  getLogined() {
    return state.authenticated;
  },
  getLoginUser(state) {
    return state;
  },
};
