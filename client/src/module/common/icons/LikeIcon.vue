<template>
  <div :style="styles">
    <svg
      xmlns="http://www.w3.org/2000/svg"
      height="48"
      viewBox="0 96 960 960"
      width="48"
      class="item"
    >
      <path
        d="m323 851 157-94 157 95-42-178 138-120-182-16-71-168-71 167-182 16 138 120-42 178Zm-90 125 65-281L80 506l288-25 112-265 112 265 288 25-218 189 65 281-247-149-247 149Zm247-355Z"
      />
    </svg>
  </div>
</template>

<style scoped>
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
