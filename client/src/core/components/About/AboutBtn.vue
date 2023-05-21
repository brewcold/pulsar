<!--About Button입니다. 누르면 상태가 토글되고, about 페이지가 바뀝니다.-->
<!--Container이 flex로서 안의 버튼을 정가운데에 위치시킵니다. (hover 때문에 사이즈가 바뀌어도)-->
<template>
  <div id="aboutBtn_container">
    <!--버튼을 누르면 상위 컴포넌트로 emit합니다.-->
    <button id="aboutBtn" @click="showContent">?</button>
  </div>
</template>

<script>
export default {
  name: 'AboutBtn',
  methods: {
    showContent() {
      //show-content event가 발생했다고 상위컴포넌트에 보고합니다
      this.$emit('show-content');
    },
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
  z-index: 99;
}

#aboutBtn {
  border-radius: 3rem;
  border: 1px solid var(--light-color-darkgrey);
  color: var(--light-color-darkgrey);
  background: white;
  cursor: pointer;
  height: 2.75rem;
  width: 3rem;
  font-size: 1.25rem;
}

#aboutBtn:hover {
  opacity: 0.7;
  font-size: 1rem;
}

#aboutBtn:active {
  background: var(--light-color-lightgrey);
}

@media screen and (max-width: 600px) {
  #aboutBtn_container {
    display: none;
  }
}
</style>
