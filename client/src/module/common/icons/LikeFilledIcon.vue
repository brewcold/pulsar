<template>
  <div :style="styles">
    <svg
      xmlns="http://www.w3.org/2000/svg"
      height="48"
      viewBox="0 -960 960 960"
      width="48"
      class="item"
    >
      <path
        d="m233-80 65-281L80-550l288-25 112-265 112 265 288 25-218 189 65 281-247-149L233-80Z"
      />
    </svg>
  </div>
</template>

<style scoped>
.item {
  width: 1.5rem;
  height: 1.5rem;
  fill: var(--active);
  cursor: pointer;
}
.item:hover {
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
