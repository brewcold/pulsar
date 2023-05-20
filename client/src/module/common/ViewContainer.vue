<!--데이터 처리, axios 통신을 담당합니다. 라우터의 2nd depth에 해당하는 경로의
차상위에 자리하면서 컴포넌트의 서브트리를 구성합니다. -->
<template>
  <div id="viewContainer_wrapper"></div>
</template>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');
</style>

<script>
export default {
  name: '',
  props: {
    apiCall: Function,
  },
  data() {
    return {
      data: [],
    };
  },
  created() {
    this.data = apiCall();
  },
};
</script>
