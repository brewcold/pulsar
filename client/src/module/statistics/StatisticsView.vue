<template>
  <div id="routines_view">
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'StatisticsView',
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

#routines_view {
  height: 100vh;
  overflow-y: auto;
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
}
#routines_view::-webkit-scrollbar {
  display: none; /* Chrome, Safari, Opera*/
}
</style>
