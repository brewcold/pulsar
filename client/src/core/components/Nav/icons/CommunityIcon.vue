<template>
  <div :style="styles">
    <svg
      xmlns="http://www.w3.org/2000/svg"
      height="48"
      viewBox="0 96 960 960"
      width="48"
      class="nav_item"
    >
      <path
        d="M880 976 720 816H140q-23 0-41.5-18.5T80 756V236q0-23 18.5-41.5T140 176h680q24 0 42 18.5t18 41.5v740ZM140 236v520h605l75 75V236H140Zm0 0v595-595Z"
      />
    </svg>
  </div>
</template>

<style scoped>
@import url('../../../../assets/css/init.css');
@import url('../../../../assets/css/root.css');
@import url('../../../../assets/css/typography.css');
.nav_item {
  width: 1.5rem;
  height: 1.5rem;
  fill: var(--active);
  cursor: pointer;
}
.nav_item:hover {
  opacity: 0.75;
}
</style>

<script>
export default {
  name: '',
  components: {},
  computed: {
    styles() {
      return {
        '--active': this.active ? '#666666' : '#cccccc',
      };
    },
    active() {
      return this.$route.path.includes('community');
    },
  },
};
</script>
