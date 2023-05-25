<template>
  <div id="community_view" ref="listContainer">
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'CommunityView',
  data() {
    return {};
  },
  mounted() {
    this.$refs.listContainer.addEventListener(
      'scroll',
      this.infiniteScroll
    );
  },
  beforeUnmount() {
    this.$refs.listContainer.removeEventListener(
      'scroll',
      this.infiniteScroll
    );
  },
  methods: {
    infiniteScroll() {
      const target = this.$refs.listContainer;
      console.log(target.scrollTop);
    },
  },
};
</script>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');
</style>
