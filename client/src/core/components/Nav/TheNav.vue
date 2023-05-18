<!--특정 페이지에는 헤더와 내비게이션이 없어야 합니다.-->
<!--레이아웃 페이지는 라우트와 함께 전체 사이트 골격을 잡습니다.-->
<template>
  <nav id="nav_container">
    <div id="nav_list_container">
      <router-link to="/"> LINK </router-link>
      <router-link to="/"> LINK </router-link>
      <router-link to="/"> LINK </router-link>
      <router-link to="/"> LINK </router-link>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'TheHeader',
};
</script>

<style scoped>
@import url('@/assets/css/init.css');
@import url('@/assets/css/root.css');
@import url('@/assets/css/typography.css');

#nav_container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  position: fixed;
  bottom: 0;
  border-top: 1px solid var(--light-color-lightgrey);
  width: 100%;
  height: 4rem;
}
#nav_list_container {
  width: 100%;
  display: flex;
  justify-content: space-around;
}
</style>
