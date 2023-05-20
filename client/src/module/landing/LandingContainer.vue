<template>
  <div id="landing_wrapper">
    <router-view />
  </div>
</template>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');
</style>

<script>
export default {
  name: '',
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
