<!--특정 페이지에는 헤더와 내비게이션이 없어야 합니다.-->
<!--레이아웃 페이지는 라우트와 함께 전체 사이트 골격을 잡습니다.-->
<template>
  <div id="header_container">
    <div id="profile" />
    <round-button @handle-click="logout" :value="'Logout'" />
  </div>
</template>

<script>
import { postMemberLogOut } from '../../api/member';
import RoundButton from '../../../module/common/RoundButton.vue';

export default {
  name: 'TheHeader',
  components: { RoundButton },
  methods: {
    // 테스트 로그아웃 코드
    logout() {
      try {
        postMemberLogOut(this.$store.getters.getToken);
        this.$store.dispatch('logout');
        alert('성공적으로 로그아웃했어요.');
      } catch (err) {
        return console.log('로그아웃에 실패했어요.');
      }
    },
  },
};
</script>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');

#header_container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  position: sticky;
  padding: 0 1rem 0 1rem;
  border-bottom: 1px solid var(--light-color-lightgrey);
  background: var(--light-color-white);
  width: calc(100% - 2rem);
  height: 3.5rem;
}
#profile {
  border: 1px solid var(--light-color-darkgrey);
  border-radius: 2rem;
  width: 2rem;
  height: 2rem;
}
</style>
