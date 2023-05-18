<template>
  <div id="app">
    <!--v-show로 이 부분에서 조건부로 라우팅해야 할 것 같습니다-->
    <!--어떤 페이지에는 다른 레이아웃이 적용되어야 합니다-->

    <the-layout v-if="$route.path !== '/'">
      <router-view />
    </the-layout>
    <router-view v-else />
  </div>
</template>

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
