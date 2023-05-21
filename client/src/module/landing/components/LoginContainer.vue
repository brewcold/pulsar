<template>
  <div id="login_container">
    <login-content @login="login" />
  </div>
</template>

<script>
import LoginContent from './LoginContent.vue';
import { postMemberLogIn } from '../../../core/api/member';

export default {
  name: 'LoginContainer',
  components: { LoginContent },
  data() {
    return {
      email: '',
      password: '',
    };
  },
  methods: {
    login() {
      const data = {
        email: this.email,
        password: this.password,
      }; //데이터를 API 형식에 맞춰 서버로 보냅니다
      postMemberLogIn(data)
        .then((res) => {
          //vuex store에 정보 저장
          console.log(res.data);
          console.log('로그인이 되었어요');
          //기본 화면인 루틴으로 리다이렉트시킵니다.
          this.$router.push('/routines');
        })
        .catch((err) => err.status);
    },
  },
};
</script>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');

#login_container {
  height: 66vh;
}
</style>
