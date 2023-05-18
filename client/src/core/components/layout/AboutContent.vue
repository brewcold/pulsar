<!-- AboutBtn에서 emit한 상태에 따라, class명이 바뀌면서 토글됩니다. -->
<template>
  <article id="about" class="display_none">
    <p>
      팀 소개 및 프로젝트 소개 페이지입니다. 전체 화면을 덮는 것이 원래
      맞습니다.
    </p>
  </article>
</template>

<script>
export default {
  name: 'AboutContent',
};
</script>

<style scoped>
@import url('@/assets/css/init.css');
@import url('@/assets/css/root.css');
@import url('@/assets/css/typography.css');

#about {
  display: none;
  position: fixed;
  width: 100vw;
  height: 100vh;
  background: white;
  z-index: 9;
}
.display {
  display: block;
}
</style>
