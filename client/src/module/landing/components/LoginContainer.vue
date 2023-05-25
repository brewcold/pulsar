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
  methods: {
    login(email, password) {
      const data = { email, password }; //데이터를 API 형식에 맞춰 서버로 보냅니다
      postMemberLogIn(data)
        .then((res) => {
          //vuex store에 정보 저장
          if (res && res.status < 400) {
            console.log('로그인에 성공했어요');

            this.$store.dispatch(
              'login',
              res.data
              // res.data.token
            );
            //기본 화면인 루틴으로 리다이렉트시킵니다.
            this.$router.push('/routines');
          } else if (res && res.status < 500)
            alert(
              '로그인에 실패했어요. 아이디와 비밀번호를 확인해 주세요.'
            );
          else {
            alert('서버가 아파요. 최대한 빠르게 치료할게요.');
          }
        })
        .catch((err) => err.status);
    },
  },
};
</script>
