<template>
  <div :style="styles">
    <!-- Generator: Adobe Illustrator 27.2.0, SVG Export Plug-In . SVG Version: 6.00 Build 0)  -->
    <svg
      version="1.1"
      class="nav_item"
      xmlns="http://www.w3.org/2000/svg"
      xmlns:xlink="http://www.w3.org/1999/xlink"
      x="0px"
      y="0px"
      viewBox="0 0 48 48"
      style="enable-background: new 0 0 48 48"
      xml:space="preserve"
    >
      <path
        d="M4,41.5v-3h40v3H4z M6,35.5V22h5v13.5H6z M16.3,35.5V12h5v23.5H16.3z M26.6,35.5V18h5v17.5H26.6z M37,35.5V6h5v29.5H37z"
      />
    </svg>
  </div>
</template>

<style scoped>
@import url('../../../../assets/css/init.css');
@import url('../../../../assets/css/root.css');
@import url('../../../../assets/css/typography.css');
.nav_item {
  width: 1.6rem;
  height: 1.6rem;
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
        '--active': this.active ? '#ff8048' : '#cccccc',
      };
    },
    active() {
      return this.$route.path.includes('statistics');
    },
  },
};
</script>
