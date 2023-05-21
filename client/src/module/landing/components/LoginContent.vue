<template>
  <div id="login_content">
    <!-- 상위 컴포넌트에서 v-model은 하위 컴포넌트에서 emit해 바인딩할 수 있습니다.
         v-model이 하위 컴포넌트에서의 emit + 그 하위 컴포넌트로 pass prop인 것을 이용한 것입니다. -->
    <h2>로그인</h2>
    <p class="login_content_caption">
      서비스를 이용하려면 로그인해야 합니다.
    </p>
    <text-input
      :input-name="'Email'"
      :placeholder="'Email'"
      :type="'email'"
      :margin="'1rem'"
      v-model="email"
    />
    <text-input
      :input-name="'Password'"
      :placeholder="'Password'"
      :type="'password'"
      :margin="'1rem'"
      :caption="'영문 소문자, 숫자, 특수문자 포함 8자리 이상'"
      v-model="password"
    />
    <square-button
      :theme="'highlight'"
      :value="'LOGIN'"
      @handle-click="handleClick"
    />
    <square-button :theme="'white'" :value="'SIGN UP'" />
  </div>
</template>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');

#login_content {
  padding: 1.5rem;
}
.login_content_caption {
  margin: 1rem 0 2rem 0;
}
</style>

<script>
import SquareButton from '../../common/SquareButton.vue';
import TextInput from '../../common/TextInput.vue';

export default {
  name: 'LoginContent',
  components: { TextInput, SquareButton },
  data() {
    return {
      //각 커스텀 인풋 컴포넌트에서 받은 입력값을 v-model로 양방향 바인딩합니다.
      email: '',
      password: '',
    };
  },
  methods: {
    handleClick() {
      //로그인을 시도하기 위해 위쪽으로 로그인 이벤트와 값을 보내고,
      //양방향 바인딩되어 있는 데이터 쪽의 값을 초기화해 인풋을 빈 값으로 만듭니다.
      this.$emit('login', this.email, this.password);
      this.email = '';
      this.password = '';
    },
  },
};
</script>
