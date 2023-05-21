<template>
  <div id="Login_Container">
    <login-content @login="login" />
  </div>
</template>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');
</style>

<script>
import LoginContent from './LoginContent.vue';
import { postMemberLogIn } from '../../../core/api/member';

export default {
  name: 'LogIn',
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
      };
      postMemberLogIn(data).then((a) => {
        //vuex store에 정보 저장
        //redirect
      });
    },
  },
};
</script>
