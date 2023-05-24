<template>
  <div id="community_view">
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'CommunityView',
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

#community_view {
  height: 100vh;
  overflow-y: auto;
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
}
#community_view::-webkit-scrollbar {
  display: none; /* Chrome, Safari, Opera*/
}
</style>
