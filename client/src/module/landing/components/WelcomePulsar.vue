<template>
  <div id="welcome_pulsar">
    <div>
      <img src="../../../assets/images/logo.svg" />
      <h1 id="welcome_pulsar_title">PULSAR</h1>
    </div>
  </div>
</template>

<style scoped>
#welcome_pulsar {
  width: 430px;
  height: 33vh;
  display: flex;
  justify-content: center;
  text-align: center;
  align-items: end;
}
#welcome_pulsar_title {
  margin-top: 1rem;
  padding-right: 1.5rem;
  font-size: 4rem;
}
img {
  width: 50%;
}
</style>

<script>
export default {
  name: 'WelcomePulsar',
  components: {},
  created() {
    //axios
  },
};
</script>
