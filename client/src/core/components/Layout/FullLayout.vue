<!--레이아웃 페이지는 전체 사이트 골격을 잡습니다.-->
<template>
  <div>
    <about-container />
    <div id="container">
      <the-header />
      <router-view />
      <the-nav />
    </div>
  </div>
</template>

<script>
import TheHeader from '../Header/TheHeader.vue';
import TheNav from '../Nav/TheNav.vue';
import AboutContainer from '../About/AboutContainer.vue';

export default {
  name: 'FullLayout',
  components: { TheHeader, TheNav, AboutContainer },
};
</script>

<style scoped>
@import url('@/assets/css/init.css');
@import url('@/assets/css/root.css');
@import url('@/assets/css/typography.css');

#container {
  position: absolute;
  border-left: 1px solid var(--light-color-white);
  border-right: 1px solid var(--light-color-white);
  width: 430px;
  height: fit-content;
  min-height: 100%;
  /* 메인 컨테이너를 가운데 정렬합니다. */
  left: 50%;
  transform: translateX(-50%);
}
</style>
