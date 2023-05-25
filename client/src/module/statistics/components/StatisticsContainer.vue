<template>
  <div id="statistics_container">
    <div id="logo_container">
      <img id="logo" src="../../../assets/images/logo.svg" alt="logo" />
    </div>
    <h1>STATISTICS</h1>
    <p>통계 및 업적 달성 현황을 확인하실 수 있어요.</p>
    <div class="statistics_items">
      <h1>기계인간</h1>
      <p>100일 연속 루틴 성공</p>
      <p class="achieve_date">2023. 05. 26 달성</p>
    </div>
    <div class="statistics_items">
      <h1>작심삼일</h1>
      <p>3일 연속 루틴 성공</p>
      <p class="achieve_date">2023. 02. 01 달성</p>
    </div>
  </div>
</template>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');
#statistics_container {
  padding: 2rem;
}
p {
  margin: 0;
}
.statistics_items {
  margin-top: 1rem;
  border: 1px solid var(--light-color-grey);
  border-radius: 8px;
  padding: 1rem;
}
.statistics_items h1 {
  font-size: 2.5rem;
}
.achieve_date {
  color: var(--light-color-point);
}
#logo_container {
  margin: 1.5rem 0 0.25rem 0;
}
#logo {
  width: 2.25rem;
  height: 2.25rem;
}
</style>

<script>
export default {
  name: '',
  components: {},
  created() {
    //axios
  },
};
</script>
