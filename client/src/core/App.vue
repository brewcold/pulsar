<template>
  <div id="app">
    <!--v-if를 사용한 Router-view 조건부 렌더링-->

    <empty-layout v-if="$route.path === '/'">
      <router-view />
    </empty-layout>
    <full-layout v-else>
      <router-view />
    </full-layout>
  </div>
</template>

<script>
import FullLayout from './components/Layout/FullLayout.vue';
import EmptyLayout from './components/Layout/EmptyLayout.vue';
export default {
  name: 'HomeView',
  components: {
    FullLayout,
    EmptyLayout,
  },
  created() {
    //fetch
  },
};
</script>
