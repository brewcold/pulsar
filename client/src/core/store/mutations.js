//state를 변경합니다
//첫 번째 인자로 state가 들어옴
export default {
  login(state, member, token) {
    state.authenticated = true;
    state.memberNo = member.memberNo;
    state.nickname = member.nickname;
    state.selectedTag = member.selectedTag;
    state.profileImg = member.profileImg;
    state.token = token;
  },
  logout() {
    state.authenticated = false;
    state.memberNo = null;
    state.nickname = null;
    state.selectedTag = null;
    state.profileImg = null;
    state.token = null;
  },
};
