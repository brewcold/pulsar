<!-- AboutBtn에서 emit한 상태에 따라, class명이 바뀌면서 토글됩니다. -->
<template>
  <article id="about_content_container" :class="{ show: show }">
    <div id="about_content_content">
      <h1>PULSAR</h1>
      <p>TEAM 최종병기 망치</p>
    </div>
  </article>
</template>

<script>
export default {
  name: 'AboutContent',
  props: {
    show: Boolean,
  },
};
</script>

<style scoped>
@import url('@/assets/css/init.css');
@import url('@/assets/css/root.css');
@import url('@/assets/css/typography.css');

#about_content_container {
  position: fixed;
  display: none;
  width: 100vw;
  height: 100vh;
  background: var(--light-color-highlight);
  z-index: 9;
}
#about_content_content {
  width: 430px;
  color: var(--light-color-white);
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  padding-top: 2rem;
}
.show {
  display: block !important;
}
</style>
