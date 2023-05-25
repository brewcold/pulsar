<template>
  <div id="mypage_container">
    <div id="logo_container">
      <img id="logo" src="../../assets/images/logo.svg" alt="logo" />
    </div>
    <h1>Mypage</h1>
    <p>회원정보와 활동 내역을 확인하실 수 있어요.</p>
    <div id="mypage_category">
      <SquareButton :value="'log out'" @handle-click="logout" />
    </div>
  </div>
</template>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');
#mypage_container {
  padding: 2rem;
}
#logo_container {
  margin: 1.5rem 0 0.25rem 0;
}
#logo {
  width: 2.25rem;
  height: 2.25rem;
}
#mypage_category {
  margin-top: 2rem;
}
p {
  margin: 0;
}
</style>

<script>
import { postMemberLogOut } from '../../core/api/member';
import SquareButton from '../common/SquareButton.vue';

export default {
  name: 'MypageContainer',
  components: { SquareButton },
  methods: {
    logout() {
      postMemberLogOut().then((res) => {
        this.$store.dispatch('logout');
        alert('로그아웃에 성공했어요.');
        this.$router.push('/');
      });
    },
  },
};
</script>
