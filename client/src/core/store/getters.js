//state의 값을 가져옵니다.
export default {
  getLogined({ authenticated }) {
    return authenticated;
  },
  getLoginUser(state) {
    return state;
  },
  getToken({ token }) {
    return token;
  },
};
