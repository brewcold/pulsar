<template>
  <div id="landing_wrapper">
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

#landing_wrapper {
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>
