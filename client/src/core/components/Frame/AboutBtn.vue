<!--버튼입니다. 누르면 상태가 토글되고, about 페이지가 바뀝니다.-->
<!--Container이 flex로서 안의 버튼을 정가운데에 위치시킵니다. (hover 때문에 사이즈가 바뀌어도)-->
<template>
  <div id="aboutBtn_container">
    <button id="aboutBtn">?</button>
  </div>
</template>

<script>
export default {
  name: 'AboutBtn',
  data() {
    return {};
  },
};
</script>

<style scoped>
@import url('@/assets/css/init.css');
@import url('@/assets/css/root.css');
@import url('@/assets/css/typography.css');

#aboutBtn_container {
  width: 3rem;
  height: 3rem;
  position: fixed;
  right: 1rem;
  top: 1rem;
  display: flex;
  justify-content: center;
  align-items: center;
}

#aboutBtn {
  border-radius: 24px;
  border: 1px solid var(--light-color-darkgrey);
  color: var(--light-color-darkgrey);
  background: white;
  cursor: pointer;
  height: 3rem;
  width: 3rem;
  font-size: 1.25rem;
  z-index: 99;
}

#aboutBtn:hover {
  width: 2.75rem;
  height: 2.75rem;
  font-size: 1rem;
}

#aboutBtn:active {
  background: var(--light-color-lightgrey);
}

@media screen and (max-width: 600px) {
  #about {
    display: none;
  }
}
</style>
