<template>
  <div id="app">
    <h1>구조 테스트 화면입니다.</h1>
    <the-layout>
      <router-view />
    </the-layout>
  </div>
</template>

<style scoped>
/* 
Global CSS Import
*/
</style>

<script>
import TheLayout from './components/layout/TheLayout.vue';
export default {
  name: 'HomeView',
  components: {
    TheLayout,
  },
  created() {
    //fetch
  },
};
</script>
