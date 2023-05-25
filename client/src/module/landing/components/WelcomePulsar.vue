<template>
  <div id="welcome_pulsar">
    <div>
      <img src="../../../assets/images/logo.svg" />
    </div>
  </div>
</template>

<script>
export default {
  name: 'WelcomePulsar',

  created() {
    //axios
  },
};
</script>

<style scoped>
#welcome_pulsar {
  width: 430px;
  display: flex;
  padding-left: 1.5rem;
  align-items: flex-end;
}
#welcome_pulsar_title {
  margin-top: 0.5rem;
  padding-right: 1rem;
  font-size: 2.5rem;
}
img {
  width: 33%;
}
</style>
