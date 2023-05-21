<template>
  <div id="Login_Container">
    <text-input
      :placeholder="'email'"
      :width="'10rem'"
      @handle-change="email = $event.target.value"
    />
    <text-input
      :placeholder="'password'"
      :width="'10rem'"
      @handle-change="password = $event.target.value"
    />
    <round-button
      :theme="'black'"
      :value="'LOGIN'"
      @handle-click="$emit('login', email, password)"
    />
  </div>
</template>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');
</style>

<script>
import RoundButton from '../../common/RoundButton.vue';
import TextInput from '../../common/TextInput.vue';

export default {
  name: 'LogIn',
  components: { TextInput, RoundButton },
  data() {
    return {
      email: '',
      password: '',
    };
  },
};
</script>
