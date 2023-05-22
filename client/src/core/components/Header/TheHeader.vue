<!--특정 페이지에는 헤더와 내비게이션이 없어야 합니다.-->
<!--레이아웃 페이지는 라우트와 함께 전체 사이트 골격을 잡습니다.-->
<template>
  <div id="header_container">
    <div id="profile" />
    <button @click="logout">LOGOUT</button>
  </div>
</template>

<script>
import { postMemberLogOut } from '@/api/member';

export default {
  name: 'TheHeader',
  methods: {
    // 테스트 로그아웃 코드
    logout() {
      try {
        postMemberLogOut(this.$store.getters.getSessionId);
        this.$store.dispatch('logout');
        console.log('로그아웃됨');
      } catch (err) {
        return console.log(err);
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
  flex-direction: column;
  justify-content: center;
  position: sticky;
  border-bottom: 1px solid var(--light-color-lightgrey);
  background: var(--light-color-white);
  width: 100%;
  height: 3.5rem;
}
#profile {
  margin-left: 1rem;
  border: 1px solid var(--light-color-darkgrey);
  border-radius: 2rem;
  width: 2rem;
  height: 2rem;
}
</style>
