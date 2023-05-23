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
      const data = new FormData();
      data.append('profileImg', file);
      data.append(
        'form',
        new Blob([JSON.stringify(form)], { type: 'application/json' })
      );
      postMemberSignUp(data)
        .then((res) => {
          if (res.status === 201) {
            console.log('성공적으로 멤버가 되었어요!');
            this.$router.push('/');
          }
        })
        .catch((err) => {
          console.log('회원가입에 실패했어요.');
        });
    },
  },
};
</script>
