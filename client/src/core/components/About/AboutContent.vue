<!-- AboutBtn에서 emit한 상태에 따라, class명이 바뀌면서 토글됩니다. -->
<template>
  <!--class attribute의 show를 바인딩해 사용합니다.-->
  <article id="about_content_container" :class="{ show: show }">
    <div id="about_content_content">
      <h1>CREDITS</h1>
      <div class="credit_item">
        <h2 class="credit_title"><strong> 제작 </strong></h2>
        <h2>민병기 유승윤</h2>
      </div>
      <div class="credit_item">
        <h2 class="credit_title"><strong> Back-end </strong></h2>
        <h2>
          <a href="https://github.com/bmincof">민병기</a>
        </h2>
      </div>
      <div class="credit_item">
        <h2 class="credit_title">
          <strong> Front-end </strong>
        </h2>
        <h2>
          <a href="https://github.com/s-y-yu">유승윤</a>
        </h2>
      </div>
      <div class="credit_item">
        <h2 class="credit_title"><strong> TECH STACK </strong></h2>
        <h2>
          Back-end<br />
          <h3>JAVA 8</h3>
          <h3>SPRING BOOT</h3>
          <h3>MYSQL</h3>
          <h3>MYBATIS</h3>
          Front-end<br />
          <h3>VUE</h3>
          <h3>VUEX</h3>
          <h3>STORYBOOK</h3>
          Project Manage<br />
          <h3>
            <a
              href="https://seung-yoon-yu.notion.site/PULSAR-API-DOCUMENT-073b3b6940a943a794ffd16b75cfba02"
              >API DOCS</a
            >
          </h3>
          <h3>GITHUB</h3>
        </h2>
      </div>
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
  background: var(--light-color-black);
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
h1,
h2,
p {
  opacity: 0.75;
  margin: 0 1rem 0.5rem 1rem;
  line-height: 1.65;
}
h3 {
  margin: 0;
  line-height: 1.65;
}
h1 {
  font-size: 3.5rem;
  text-align: center;
}
h2 a {
  text-decoration: underline;
}
h2,
h3 {
  font-size: 1.2rem;
}
.credit_item {
  width: 100%;
  display: flex;
  justify-content: center;
}
h2 {
  width: 50%;
}
.credit_title {
  text-align: right;
}
.show {
  display: block !important;
}
</style>
