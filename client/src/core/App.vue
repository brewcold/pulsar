<template>
  <div id="app">
    <!--v-if를 사용한 Router-view 조건부 렌더링-->
    <the-layout v-if="$route.path !== '/'">
      <router-view />
    </the-layout>
    <router-view v-else />
  </div>
</template>

<script>
import TheLayout from './components/Layout/TheLayout.vue';
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
