//method단에서 dispatch로 호출됩니다
//여기에서 commit으로 mutations를 호출합니다
//(만약 해야 한다면 여기서)backend API와 통신합니다
export default {
  login({ commit }, member, token) {
    commit('login', member, token);
  },
  logout({ commit }) {
    commit('logout');
  },
};
