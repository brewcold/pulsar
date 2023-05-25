<template>
  <div id="landing_view">
    <welcome-pulsar />
    <router-view />
  </div>
</template>

<script>
import WelcomePulsar from './components/WelcomePulsar.vue';

export default {
  name: 'LandingView',
  components: { WelcomePulsar },
  data() {
    return {};
  },
  methods: {
    staticDataCall() {
      return Promise.all([]).then((res) => res.data);
    },
  },
};
</script>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');

#landing_view {
  display: flex;
  flex-direction: column;
  height: 100vh;
  justify-content: center;
}
</style>
