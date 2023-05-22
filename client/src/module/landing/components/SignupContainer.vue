<template>
  <div id="signup_container">
    <signup-content @signup="signup" />
  </div>
</template>

<script>
import SignupContent from './SignupContent.vue';
import { postMemberSignUp } from '../../../core/api/member';

export default {
  name: 'SignupContainer',
  components: { SignupContent },
  methods: {
    signup(form, file) {
      const data = {
        form,
        file,
      };
      postMemberSignUp(data)
        .then((res) => {
          if (res.status === 201) {
            console.log('회원가입이 잘 되었어요');
            this.$router.push('/');
          }
        })
        .catch((err) => {
          console.log('회원가입에 실패했어요');
        });
    },
  },
};
</script>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');
</style>
