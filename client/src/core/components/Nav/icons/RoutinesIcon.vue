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
        d="M27.5,43.8l-2.1-2.1l7.1-7.1L13.4,15.5l-7.1,7.1l-2.1-2.1L7,17.6l-2.8-2.8l4.2-4.2L6.3,8.4l2.1-2.1l2.2,2l4.2-4.2L17.6,7
	l2.9-2.8l2.1,2.1l-7.1,7.1l19.1,19.1l7.1-7.1l2.1,2.1L41,30.4l2.8,2.8l-4.3,4.3l2.1,2.1l-2.1,2.1l-2.1-2.1l-4.2,4.2L30.4,41
	L27.5,43.8z"
      />
    </svg>
  </div>
</template>

<style scoped>
@import url('../../../../assets/css/init.css');
@import url('../../../../assets/css/root.css');
@import url('../../../../assets/css/typography.css');
.nav_item {
  width: 1.85rem;
  height: 1.85rem;
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
      return this.$route.path.includes('routines');
    },
  },
};
</script>
